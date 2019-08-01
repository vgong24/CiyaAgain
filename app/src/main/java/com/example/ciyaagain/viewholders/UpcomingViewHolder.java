package com.example.ciyaagain.viewholders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ciyaagain.R;
import com.example.ciyaagain.adapter.UpcomingChildAdapter;
import com.example.ciyaagain.data.dashboard.UpcomingDashItem;

public class UpcomingViewHolder extends EventViewHolder<UpcomingDashItem> {
    UpcomingChildAdapter upcomingChildAdapter;
    public UpcomingViewHolder(@NonNull View itemView) {
        super(itemView);
        upcomingChildAdapter = new UpcomingChildAdapter();
    }

    @Override
    public void onBind(UpcomingDashItem event, RecyclerView.RecycledViewPool recycledViewPool) {
        RecyclerView recyclerView = itemView.findViewById(R.id.upcoming_reyclerview);
        recyclerView.setRecycledViewPool(recycledViewPool);
        recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        recyclerView.setAdapter(upcomingChildAdapter);
        upcomingChildAdapter.setUpcomingEvents(event.getEventList());
    }
}
