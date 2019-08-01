package com.example.ciyaagain.data.dashboard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Top level response body for the dashboard json
 */
public class DashBoard implements Serializable {

    private NextUpDashItem nextUp = new NextUpDashItem();
    private UpcomingDashItem upcoming = new UpcomingDashItem();
    private DiscoverDashItem discover = new DiscoverDashItem();

    public void setNextUp(NextUpDashItem nextUp) {
        this.nextUp = nextUp;
    }

    public void setUpcoming(UpcomingDashItem upcoming) {
        this.upcoming = upcoming;
    }

    public void setDiscover(DiscoverDashItem discover) {
        this.discover = discover;
    }

    public NextUpDashItem getNextUp() {
        return nextUp;
    }

    public UpcomingDashItem getUpcoming() {
        return upcoming;
    }

    public DiscoverDashItem getDiscover() {
        return discover;
    }

    public List<DashBoardItem> getDashBoardItemList() {
        List<DashBoardItem> list = new ArrayList<>();
        list.add(nextUp);
        list.add(upcoming);
        list.add(discover);
        return list;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
