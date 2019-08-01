package com.example.ciyaagain.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ciyaagain.R;
import com.example.ciyaagain.data.events.UpcomingEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Nested recyclerview adapter for upcomings section in dashboard
 */
public class UpcomingChildAdapter extends RecyclerView.Adapter<UpcomingChildAdapter.UpcomingChildViewHolder> {
    List<UpcomingEvent> upcomingEvents = new ArrayList<>();

    public UpcomingChildAdapter() {

    }

    public void setUpcomingEvents(List<UpcomingEvent> upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UpcomingChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_item, parent, false);
        UpcomingChildViewHolder upcomingChildViewHolder = new UpcomingChildViewHolder(view);
        return upcomingChildViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingChildViewHolder holder, int position) {
        holder.onBind(upcomingEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return upcomingEvents.size();
    }

    protected class UpcomingChildViewHolder extends RecyclerView.ViewHolder {
        public UpcomingChildViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(UpcomingEvent upcomingEvent) {
            TextView title = itemView.findViewById(R.id.event_title);
            title.setText(upcomingEvent.getTitle());
            Log.d("CLOWN", "upcoming child");
        }
    }
}
