package com.example.ciyaagain.data.events;


import com.example.ciyaagain.data.CommunityEventType;

public class NextUpEvent extends BaseCommunityEvent {
    @Override
    public int getType() {
        return CommunityEventType.NEXT_UP;
    }
}
