package com.example.ciyaagain.component.dashboard;

import androidx.annotation.NonNull;

import com.example.ciyaagain.data.dashboard.DashBoardItem;

import java.util.List;

public class DashBoardPresenter implements DashBoardContract.Presenter {

    DashBoardContract.View view;
    DashBoardContract.Model model;

    public DashBoardPresenter(@NonNull DashBoardContract.View view, @NonNull DashBoardContract.Model model) {
        this.view = view;
        this.model = model;
        this.model.setPresenter(this);
    }

    @Override
    public void onDestroy() {
        model.onDestroy();
        view = null;
        model = null;
    }

    @Override
    public void loadDashBoard() {
        model.fetchDashBoard();
    }

    @Override
    public void onDashBoardLoaded(List<DashBoardItem> dashBoardItems) {
        view.onDashBoardLoaded(dashBoardItems);
    }
}
