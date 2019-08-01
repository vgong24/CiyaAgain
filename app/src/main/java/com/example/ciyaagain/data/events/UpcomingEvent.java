package com.example.ciyaagain.data.events;


import com.example.ciyaagain.data.CommunityEventType;

public class UpcomingEvent extends BaseCommunityEvent {
    @Override
    public int getType() {
        return CommunityEventType.UPCOMING;
    }
}
