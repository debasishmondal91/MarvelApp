package com.example.marvelappiness.ui.base;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by debasish on 20/03/20.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);
}
