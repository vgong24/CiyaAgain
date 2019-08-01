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
import com.example.ciyaagain.data.dashboard.DashBoard;
import com.example.ciyaagain.db.AssetReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class DashBoardFragment extends Fragment {
    RecyclerView dashBoardReyclerView;
    DashBoardParentAdapter adapter;

    private static DashBoardFragment INSTANCE;

    public static synchronized DashBoardFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DashBoardFragment();
        }
        return INSTANCE;
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

        AssetReader assetReader = new AssetReader(getContext());

        String result = assetReader.getFileJSON("dashboard.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            DashBoard dashBoard = objectMapper.readValue(result, DashBoard.class);
            adapter.setDashBoardItems(dashBoard.getDashBoardItemList());
        } catch (IOException e) {
            Log.d("CLOWN", "Exception " + e.getMessage());
            e.printStackTrace();
        }

    }
}
