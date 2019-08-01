package com.example.ciyaagain.data.dashboard;

import com.example.ciyaagain.data.CommunityEventType;
import com.example.ciyaagain.data.events.DiscoverEvent;

public class DiscoverDashItem extends DashBoardItem<DiscoverEvent> {
    @Override
    public int getType() {
        return CommunityEventType.DISCOVER;
    }
}
