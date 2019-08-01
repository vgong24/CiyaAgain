package com.example.ciyaagain.component.dashboard;

public interface DashBoardInjector {

    DashBoardContract.Presenter presenter(DashBoardContract.View view);

    DashBoardContract.Model model();

}
