package com.chg.chgadapterdemo.Found.activity;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chg.CHGAdapter.CHGRecycleView;
import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.ModelProtocol;
import com.chg.chgadapterdemo.R;

import java.util.HashMap;
import java.util.List;

public class ShowBigImageViewActivity extends AppCompatActivity {
    private CHGRecycleView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_big_image_view);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager manager = new LinearLayoutManager(ShowBigImageViewActivity.this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);

        HashMap map = (HashMap) getIntent().getExtras().get("sources");
        recyclerView.setData((List<ModelProtocol>) map.get("sources"));
        recyclerView.scrollToPosition((Integer) map.get("position"));
        recyclerView.setEventTransmissionListener(new EventTransmissionListener() {
            @Override
            public Object onEventTransmission(Object target, Object params, int tag, CallBack callBack) {
                finish();
                return null;
            }
        });


    }
}
