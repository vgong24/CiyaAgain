package com.example.ciyaagain.data.dashboard;


import com.example.ciyaagain.data.CommunityEventType;
import com.example.ciyaagain.data.events.UpcomingEvent;

public class UpcomingDashItem extends DashBoardItem<UpcomingEvent> {
    @Override
    public int getType() {
        return CommunityEventType.UPCOMING;
    }
}
