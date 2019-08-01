package com.example.ciyaagain.component.dashboard;

import android.os.Handler;

import com.example.ciyaagain.BaseUnitTest;
import com.example.ciyaagain.MockJSONData;
import com.example.ciyaagain.data.dashboard.DashBoard;
import com.example.ciyaagain.data.dashboard.DashBoardItem;
import com.example.ciyaagain.db.AssetReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DashBoardModelTest extends BaseUnitTest {

    DashBoardModel dashBoardModel;

    @Mock
    AssetReader assetReader;

    @Mock
    Handler handler;

    @Mock
    DashBoardContract.Presenter presenter;

    @Override
    public void setup() {
        super.setup();
        MockitoAnnotations.initMocks(this);
        dashBoardModel = new DashBoardModel(assetReader, handler);
        dashBoardModel.setPresenter(presenter);
    }

    private void givenJSONResult(String result) {
        when(assetReader.getFileJSON("dashboard.json")).thenReturn(result);
        when(handler.postDelayed(any(Runnable.class), anyLong())).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Runnable runnable = invocation.getArgument(0);
                runnable.run();
                return null;
            }
        });
    }

    @Test
    public void fetchDashBoardFromJson() throws IOException {
        givenJSONResult(MockJSONData.DEFAULT_DASHBOARD);
        whenFetchDashBoard();
        thenContainsResults();
    }

    @Test
    public void fetchDashBoardFromJson_InvalidResponse() {
        givenJSONResult("");
        whenFetchDashBoard();
        thenFail();
    }

    private void thenFail() {
        verify(presenter, never()).onDashBoardLoaded(ArgumentMatchers.<DashBoardItem>anyList());
    }

    private void thenContainsResults() {
        verify(presenter).onDashBoardLoaded(ArgumentMatchers.<DashBoardItem>anyList());
    }

    private void whenFetchDashBoard() {
        dashBoardModel.fetchDashBoard();
    }
}