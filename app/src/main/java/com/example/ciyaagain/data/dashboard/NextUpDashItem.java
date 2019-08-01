package com.example.ciyaagain.data.dashboard;

import com.example.ciyaagain.data.CommunityEventType;
import com.example.ciyaagain.data.events.NextUpEvent;

public class NextUpDashItem extends DashBoardItem<NextUpEvent> {

    @Override
    public int getType() {
        return CommunityEventType.NEXT_UP;
    }
}
