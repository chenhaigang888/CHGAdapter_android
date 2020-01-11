package com.chg.chgadapterdemo;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chg.CHGAdapter.CHGRecycleView;
import com.chg.CHGAdapter.ModelProtocol;
import com.chg.chgadapterdemo.Model.BannerItemModel;
import com.chg.chgadapterdemo.Model.BannersModel;
import com.chg.chgadapterdemo.Model.Friend;
import com.chg.chgadapterdemo.Model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CHGRecycleView recyclerView;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycleView);

        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(manager);
//        recyclerView.setData(getUsers());
        recyclerView.setData(getFriends());
    }

    /**
     * Demo 1
     *
     * @return
     */
    public List getFriends() {
        List list = new ArrayList();
        Friend friend;
        for (int ii = 0; ii < 10; ii++) {
            friend = new Friend();
            friend.setUsername("姓名" + ii);
            friend.setGender(ii % 2 == 0 ? "男" : "女");
            list.add(friend);
        }
        return list;
    }

//    /**
//     * Demo 2
//     * @return
//     */
//    public List getUsers() {
//        List list = new ArrayList();
//        //添加用户
//        User user = null;
//        for (int i = 0; i < 100; i++) {
//            if (i == 1) {
//                //添加一个banner
//                BannersModel bannersModel = new BannersModel();
//                BannerItemModel bannerItemModel;
//                List<ModelProtocol> bannerItemModels = new ArrayList<>();
//                for (int ii = 0; ii < 10; ii++) {
//                    bannerItemModel = new BannerItemModel();
//                    bannerItemModels.add(bannerItemModel);
//                }
//                bannersModel.setBannerItemModels(bannerItemModels);
//                list.add(bannersModel);
//            }
//
//            user = new User();
//            user.setUsername("姓名" + i);
//            user.setGender(i % 2 == 0 ? "男" : "女");
//            List<ModelProtocol> friends = new ArrayList<>();
//            for (int j = 0; j < 10; j++) {
//                Friend friend = new Friend();
//                friend.setUsername("姓名" + j);
//                friend.setGender(j % 2 == 0 ? "男" : "女");
//                friends.add(friend);
//            }
//            user.setFriends(friends);
//            list.add(user);
//        }
//        return list;
//    }


}
