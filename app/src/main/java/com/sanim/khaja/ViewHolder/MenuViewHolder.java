package com.sanim.khaja.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sanim.khaja.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtMenuName;
    public ImageView imageView;


    public MenuViewHolder(View itemView) {
        super(itemView);
        txtMenuName=(TextView)itemView.findViewById(R.id.menu_name);
        imageView=(ImageView)itemView.findViewById(R.id.menu_image);
        itemView.setOnClickListener(this);

        }
        public void setItemClickLis


    @Override
    public void onClick(View v) {

    }
}
