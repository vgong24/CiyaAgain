package com.example.ciyaagain.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ciyaagain.ui.CommunityEventsFragment;
import com.example.ciyaagain.ui.DashBoardFragment;

public class MainFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    public MainFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return DashBoardFragment.getInstance();
        }
        return CommunityEventsFragment.init(position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
