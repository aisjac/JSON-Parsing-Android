package com.example.recyclerviewwithcardview.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.recyclerviewwithcardview.R;
import com.example.recyclerviewwithcardview.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Item> MyItem;
    Context context;

    public MyAdapter(List<Item> myItem, Context context) {
        MyItem = myItem;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sample,viewGroup,false);
        MyViewHolder MVH = new MyViewHolder(view);
        return MVH;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Item itemPosition = MyItem.get(i);

        myViewHolder.cardView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_scale_animation));

        myViewHolder.date.setText(itemPosition.getDate());
        myViewHolder.time.setText(itemPosition.getTime());
        myViewHolder.stadium.setText(itemPosition.getStadium());
        myViewHolder.teamOne.setText(itemPosition.getTeamOne());
        myViewHolder.teamTwo.setText(itemPosition.getTeamTwo());

        Picasso.get().load(itemPosition.getLeftImgURL()).into(myViewHolder.leftImage);
        Picasso.get().load(itemPosition.getRightImgURL()).into(myViewHolder.rightImage);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Good Job !", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return MyItem.size();
    }
}
