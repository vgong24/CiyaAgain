package com.example.ciyaagain.component.dashboard;

import com.example.ciyaagain.component.BaseContract;
import com.example.ciyaagain.data.dashboard.DashBoardItem;

import java.util.List;

public interface DashBoardContract extends BaseContract {

    interface View extends BaseContract.View {
        void onDashBoardLoaded(List<DashBoardItem> dashBoardItems);
    }

    interface Presenter extends BaseContract.Presenter {
        void loadDashBoard();

        void onDashBoardLoaded(List<DashBoardItem> dashBoardItems);
    }

    interface Model extends BaseContract.Model {
        void fetchDashBoard();
    }
}
