package com.example.ciyaagain.viewholders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class EventViewHolder<T> extends RecyclerView.ViewHolder {

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void onBind(T event, RecyclerView.RecycledViewPool recycledViewPool);
}
