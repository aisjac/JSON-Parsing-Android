package com.example.recyclerviewwithcardview.adapter;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewwithcardview.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView leftImage,rightImage;
    TextView date,time,stadium;
    TextView teamOne,teamTwo;
    CardView cardView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        cardView = itemView.findViewById(R.id.cardViewId);

        leftImage = itemView.findViewById(R.id.leftImageId);
        rightImage = itemView.findViewById(R.id.rightImageId);
        date = itemView.findViewById(R.id.dateTextViewId);
        time = itemView.findViewById(R.id.timeTextViewId);
        stadium = itemView.findViewById(R.id.stadiumTextViewId);
        teamOne = itemView.findViewById(R.id.leftImgNameTextViewId);
        teamTwo = itemView.findViewById(R.id.rightImgNameTextViewId);


    }
}
