package com.example.ciyaagain.component.dashboard;

import android.content.Context;
import android.os.Handler;

import com.example.ciyaagain.db.AssetReader;

public class DashBoardInjectorImpl implements DashBoardInjector {

    Context context;

    public DashBoardInjectorImpl(Context context) {
        this.context = context;
    }

    @Override
    public DashBoardContract.Presenter presenter(DashBoardContract.View view) {
        return new DashBoardPresenter(view, model());
    }

    @Override
    public DashBoardContract.Model model() {
        return new DashBoardModel(assetReader(), handler());
    }

    private AssetReader assetReader() {
        return new AssetReader(context);
    }

    private Handler handler() {
        return new Handler();
    }
}
