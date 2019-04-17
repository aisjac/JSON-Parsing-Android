package com.example.recyclerviewwithcardview.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerviewwithcardview.adapter.MyAdapter;
import com.example.recyclerviewwithcardview.R;
import com.example.recyclerviewwithcardview.model.Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String  url = "https://api.jsonbin.io/b/5c9267f808b9a73c3abcdeb9/4";
    MyAdapter myAdapter;
    List<Item> listItem;

    ProgressDialog progressDialog;
//    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        lottieAnimationView = findViewById(R.id.animation_view);

        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItem = new ArrayList<>();


        loadData();
    }

    private void loadData() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();



        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressDialog.dismiss();
//                        lottieAnimationView.cancelAnimation();

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("MyData");
                            for (int i = 0;i<jsonArray.length();i++){
                                JSONObject receive = jsonArray.getJSONObject(i);

                                Item myItem = new Item(receive.getString("date"),receive.getString("time"),receive.getString("stadium"),receive.getString("leftImage"),receive.getString("rightImage"),receive.getString("leftTeam"),receive.getString("rightTeam"));
                                listItem.add(myItem);
                            }
                            myAdapter = new MyAdapter(listItem,getApplicationContext());
                            recyclerView.setAdapter(myAdapter);


                        }catch (JSONException e){
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Server Error!", Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }
}
