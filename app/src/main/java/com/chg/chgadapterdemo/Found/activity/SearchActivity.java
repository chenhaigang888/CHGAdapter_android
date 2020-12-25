package com.chg.chgadapterdemo.Found.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chg.CHGAdapter.CHGRecyclerView;
import com.chg.chgadapterdemo.R;

public class SearchActivity extends AppCompatActivity {

    private EditText editText;
    private CHGRecyclerView recycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = findViewById(R.id.editText);

        configBtn();
        configRecycleView();
    }

    public void configRecycleView(){
        recycleView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(SearchActivity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);


    }

    public void configBtn(){
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
