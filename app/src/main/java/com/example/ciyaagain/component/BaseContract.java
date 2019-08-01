package com.example.ciyaagain.component;

public interface BaseContract {
    interface View {

    }

    interface Presenter {

        void onDestroy();
    }

    interface Model {
        void setPresenter(Presenter presenter);

        void onDestroy();
    }
}
