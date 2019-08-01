package com.example.ciyaagain.component.dashboard;

import android.os.Handler;
import android.util.Log;

import com.example.ciyaagain.component.BaseContract;
import com.example.ciyaagain.data.dashboard.DashBoard;
import com.example.ciyaagain.db.AssetReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class DashBoardModel implements DashBoardContract.Model {

    private final String TAG = DashBoardModel.class.getName();
    protected final String FILE_DASHBOARD = "dashboard.json";
    DashBoardContract.Presenter presenter;
    AssetReader assetReader;
    Handler handler;

    public DashBoardModel(AssetReader assetReader, Handler handler) {
        this.assetReader = assetReader;
        this.handler = handler;
    }

    @Override
    public void setPresenter(BaseContract.Presenter presenter) {
        this.presenter = (DashBoardContract.Presenter) presenter;
    }

    @Override
    public void onDestroy() {
        presenter = null;
        handler = null;
    }

    @Override
    public void fetchDashBoard() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fetchDashBoardFromJson();
            }
        }, 1000);
    }

    protected void fetchDashBoardFromJson() {
        try {
            String result = assetReader.getFileJSON(FILE_DASHBOARD);
            ObjectMapper objectMapper = new ObjectMapper();
            DashBoard dashBoard = objectMapper.readValue(result, DashBoard.class);
            presenter.onDashBoardLoaded(dashBoard.getDashBoardItemList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
