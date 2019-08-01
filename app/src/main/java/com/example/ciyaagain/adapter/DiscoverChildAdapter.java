package com.example.ciyaagain.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ciyaagain.R;
import com.example.ciyaagain.data.events.DiscoverEvent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiscoverChildAdapter extends RecyclerView.Adapter<DiscoverChildAdapter.DiscoveryChildViewHolder> {

    List<DiscoverEvent> discoverEvents = new ArrayList<>();


    @NonNull
    @Override
    public DiscoveryChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.discover_item, parent, false);

        DiscoveryChildViewHolder discoveryChildViewHolder = new DiscoveryChildViewHolder(view);
        return discoveryChildViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoveryChildViewHolder holder, int position) {
        holder.onBind(discoverEvents.get(position));
    }

    public void setDiscoverEvents(List<DiscoverEvent> discoverEvents) {
        this.discoverEvents = discoverEvents;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return discoverEvents.size();
    }

    protected class DiscoveryChildViewHolder extends RecyclerView.ViewHolder {

        public DiscoveryChildViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(DiscoverEvent discoverEvent) {
            TextView textView = itemView.findViewById(R.id.event_title);
            textView.setText(discoverEvent.getTitle());
            TextView timeText = itemView.findViewById(R.id.start_time);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM HH:mm:ss Z");
            Date date = new Date(discoverEvent.getTime());
            timeText.setText(simpleDateFormat.format(date));
        }
    }
}
