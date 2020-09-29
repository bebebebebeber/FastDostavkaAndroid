package com.example.smarthome.fragments.stores;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.smarthome.R;

public class StoreCardViewHolder extends RecyclerView.ViewHolder {

    private View view;
    public NetworkImageView productImage;
    public TextView productTitle;
    public TextView productDescription;
    public StoreCardViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view=itemView;
        productImage = itemView.findViewById(R.id.product_image);
        productTitle = itemView.findViewById(R.id.product_title);
        productDescription = itemView.findViewById(R.id.product_description);
    }

    public View getView() {
        return view;
    }


}