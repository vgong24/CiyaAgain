package com.example.ciyaagain.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ciyaagain.R;
import com.example.ciyaagain.adapter.DashBoardParentAdapter;
import com.example.ciyaagain.component.dashboard.DashBoardContract;
import com.example.ciyaagain.component.dashboard.DashBoardInjector;
import com.example.ciyaagain.component.dashboard.DashBoardInjectorImpl;
import com.example.ciyaagain.component.dashboard.DashBoardPresenter;
import com.example.ciyaagain.data.dashboard.DashBoard;
import com.example.ciyaagain.data.dashboard.DashBoardItem;
import com.example.ciyaagain.db.AssetReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class DashBoardFragment extends Fragment implements DashBoardContract.View {
    RecyclerView dashBoardReyclerView;
    DashBoardParentAdapter adapter;
    DashBoardInjector dashBoardInjector;
    DashBoardContract.Presenter dashBoardPresenter;

    private static DashBoardFragment INSTANCE;

    public static synchronized DashBoardFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DashBoardFragment();
        }
        return INSTANCE;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dashBoardInjector = new DashBoardInjectorImpl(getContext());
        dashBoardPresenter = dashBoardInjector.presenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dashboard_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dashBoardReyclerView = view.findViewById(R.id.rv_dash_board);
        adapter = new DashBoardParentAdapter();
        dashBoardReyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dashBoardReyclerView.setAdapter(adapter);

        dashBoardPresenter.loadDashBoard();

    }

    @Override
    public void onDashBoardLoaded(List<DashBoardItem> dashBoardItems) {
        adapter.setDashBoardItems(dashBoardItems);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dashBoardPresenter.onDestroy();
    }
}
