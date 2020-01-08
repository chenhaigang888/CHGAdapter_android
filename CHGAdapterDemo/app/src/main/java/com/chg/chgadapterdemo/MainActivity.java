package com.chg.chgadapterdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chg.chgadapter.CHGRecycleView;
import com.chg.chgadapter.ModelProtocol;
import com.chg.chgadapterdemo.Model.BannerItemModel;
import com.chg.chgadapterdemo.Model.BannersModel;
import com.chg.chgadapterdemo.Model.Friend;
import com.chg.chgadapterdemo.Model.SearchItem;
import com.chg.chgadapterdemo.Model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CHGRecycleView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycleView);

        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        recyclerView.setLayoutManager(manager);


        recyclerView.setData(getSearchItemPage());


    }

    public List<ModelProtocol> getSearchItemPage(){
        List<ModelProtocol> modelProtocols = new ArrayList<>();
        for (int i = 0; i<10; i++) {
            modelProtocols.add(new SearchItem(0,getUsers()));
        }
        return  modelProtocols;
    }

    public List<ModelProtocol> getUsers() {
        List<ModelProtocol> modelProtocols = new ArrayList<>();

        //添加用户
        User user = null;
        for (int i = 0; i < 100; i++) {
            if (i == 1) {
                //添加一个banner
                BannersModel bannersModel = new BannersModel();
                BannerItemModel bannerItemModel;
                List<ModelProtocol> bannerItemModels = new ArrayList<>();
                for (int ii=0; ii<10; ii++) {
                    bannerItemModel = new BannerItemModel();
                    bannerItemModels.add(bannerItemModel);
                }
                bannersModel.setBannerItemModels(bannerItemModels);
                modelProtocols.add(bannersModel);
            }

            user = new User();
            user.setUsername("姓名" + i);
            user.setGender(i % 2 == 0 ? "男" : "女");
            List<ModelProtocol> friends = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                Friend friend = new Friend();
                friend.setUsername("姓名" + j);
                friend.setGender(j % 2 == 0 ? "男" : "女");
                friends.add(friend);
            }
            user.setFriends(friends);
            modelProtocols.add(user);
        }
        return modelProtocols;
    }

}
