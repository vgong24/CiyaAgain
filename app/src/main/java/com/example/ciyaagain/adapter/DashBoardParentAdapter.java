package com.example.ciyaagain.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ciyaagain.R;
import com.example.ciyaagain.data.dashboard.DashBoardItem;
import com.example.ciyaagain.viewholders.DiscoverViewHolder;
import com.example.ciyaagain.viewholders.EventViewHolder;
import com.example.ciyaagain.viewholders.NextEventViewHolder;
import com.example.ciyaagain.viewholders.UpcomingViewHolder;

import java.util.ArrayList;
import java.util.List;

import static com.example.ciyaagain.data.CommunityEventType.DISCOVER;
import static com.example.ciyaagain.data.CommunityEventType.UPCOMING;

/**
 * Main Dashboard Adapter that displays the NextUp, Upcoming, and Discover Sections
 */
public class DashBoardParentAdapter extends RecyclerView.Adapter<EventViewHolder> {

    List<DashBoardItem> dashBoardItems = new ArrayList<>();
    RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EventViewHolder eventViewHolder;
        View view;
        switch (viewType) {
            case DISCOVER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.discover_layout, parent, false);
                eventViewHolder = new DiscoverViewHolder(view);
                break;
            case UPCOMING:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_layout, parent, false);
                eventViewHolder = new UpcomingViewHolder(view);
                break;
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.next_event_layout, parent, false);
                eventViewHolder = new NextEventViewHolder(view);
                break;
        }

        return eventViewHolder;
    }

    public void setDashBoardItems(List<DashBoardItem> dashBoardItems) {
        this.dashBoardItems = dashBoardItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return dashBoardItems.get(position).getType();
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Log.d("CLOWN", "binding " + dashBoardItems.get(0).getType());
        holder.onBind(dashBoardItems.get(position), viewPool);
    }

    @Override
    public int getItemCount() {
        return dashBoardItems.size();
    }
}
