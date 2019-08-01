package com.example.ciyaagain.viewholders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ciyaagain.R;
import com.example.ciyaagain.adapter.DiscoverChildAdapter;
import com.example.ciyaagain.data.dashboard.DiscoverDashItem;


public class DiscoverViewHolder extends EventViewHolder<DiscoverDashItem> {
    DiscoverChildAdapter discoverChildAdapter;

    public DiscoverViewHolder(@NonNull View itemView) {
        super(itemView);
        discoverChildAdapter = new DiscoverChildAdapter();
    }

    @Override
    public void onBind(DiscoverDashItem event, RecyclerView.RecycledViewPool recycledViewPool) {
        RecyclerView recyclerView = itemView.findViewById(R.id.discover_reyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        recyclerView.setAdapter(discoverChildAdapter);
        recyclerView.setRecycledViewPool(recycledViewPool);
        discoverChildAdapter.setDiscoverEvents(event.getEventList());
    }
}
