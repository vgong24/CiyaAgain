package com.example.ciyaagain.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ciyaagain.R;
import com.example.ciyaagain.adapter.CommunityEventListAdapter;
import com.example.ciyaagain.data.events.BaseCommunityEvent;
import com.example.ciyaagain.data.events.DiscoverEvent;
import com.example.ciyaagain.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class CommunityEventsFragment extends BaseFragment {

    private static CommunityEventsFragment INSTANCE;
    private static String KEY = "key";
    CommunityEventListAdapter communityEventListAdapter;
    int fragVal = 0;

    public static synchronized CommunityEventsFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommunityEventsFragment();
        }

        return INSTANCE;
    }

    public static CommunityEventsFragment init(int pos) {
        CommunityEventsFragment communityEventsFragment = new CommunityEventsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY, pos);
        communityEventsFragment.setArguments(bundle);
        return communityEventsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            fragVal = getArguments().getInt(KEY, 0) + 1;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.community_events_layout, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.event_list);
        communityEventListAdapter = new CommunityEventListAdapter();
        recyclerView.setAdapter(communityEventListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        List<BaseCommunityEvent> baseCommunityEvents = new ArrayList<>();
        for (int i = 0; i < fragVal * 20; i++) {
            BaseCommunityEvent b = new DiscoverEvent();
            b.setTitle("Title " + i);
            baseCommunityEvents.add(b);
        }

        communityEventListAdapter.setCommunityEventList(baseCommunityEvents);
    }
}
