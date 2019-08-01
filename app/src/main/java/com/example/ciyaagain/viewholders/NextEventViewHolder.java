package com.example.ciyaagain.viewholders;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ciyaagain.R;
import com.example.ciyaagain.data.dashboard.NextUpDashItem;
import com.example.ciyaagain.data.events.NextUpEvent;

public class NextEventViewHolder extends EventViewHolder<NextUpDashItem> {

    public NextEventViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void onBind(NextUpDashItem event, RecyclerView.RecycledViewPool recycledViewPool) {
        NextUpEvent nextUpEvent = new NextUpEvent();
        if (!event.getEventList().isEmpty()){
            nextUpEvent = event.getEventList().get(0);
        }
        TextView eventTitle = itemView.findViewById(R.id.event_title);
        eventTitle.setText(nextUpEvent.getTitle());
        Log.d("CLOWN", "NextEventViewHolder on bind " + nextUpEvent.getTitle());
    }
}
