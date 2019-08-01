package com.example.ciyaagain.data.dashboard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class DashBoardItem<T> implements Serializable {
    protected List<T> eventList = new ArrayList<>();

    public void setEventList(List<T> eventList) {
        this.eventList = eventList;
    }

    public List<T> getEventList() {
        return eventList;
    }

    public boolean hasItems() {
        return !eventList.isEmpty();
    }

    public abstract int getType();
}
