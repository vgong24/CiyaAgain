package com.example.ciyaagain.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ciyaagain.R;
import com.example.ciyaagain.data.events.BaseCommunityEvent;

import java.util.ArrayList;
import java.util.List;

public class CommunityEventListAdapter extends RecyclerView.Adapter<CommunityEventListAdapter.CommunityEventViewHolder> {

    List<BaseCommunityEvent> baseCommunityEventList = new ArrayList<>();

    @NonNull
    @Override
    public CommunityEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.community_event_item, parent, false);
        CommunityEventViewHolder communityEventViewHolder = new CommunityEventViewHolder(itemView);
        return communityEventViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityEventViewHolder holder, int position) {
        holder.onBind(baseCommunityEventList.get(position));
    }

    public void setCommunityEventList(List<BaseCommunityEvent> baseCommunityEventList) {
        this.baseCommunityEventList = baseCommunityEventList;
    }

    @Override
    public int getItemCount() {
        return baseCommunityEventList.size();
    }

    public class CommunityEventViewHolder extends RecyclerView.ViewHolder {

        public CommunityEventViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(BaseCommunityEvent baseCommunityEvent) {
            TextView titleView = itemView.findViewById(R.id.title);
            titleView.setText(baseCommunityEvent.getTitle());

        }
    }
}
