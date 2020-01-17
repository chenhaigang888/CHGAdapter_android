package com.chg.chgadapterdemo.Found.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chg.CHGAdapter.Adapter;
import com.chg.CHGAdapter.CHGRecycleView;
import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.chgadapterdemo.Found.Model.Found;
import com.chg.chgadapterdemo.Found.Model.FoundSendData;
import com.chg.chgadapterdemo.Found.Model.FuncItem;
import com.chg.chgadapterdemo.Found.Model.FunctionArea;
import com.chg.chgadapterdemo.Found.Model.ServerResponse;
import com.chg.chgadapterdemo.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main2Activity extends AppCompatActivity {

    private CHGRecycleView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List recycleViewData = new ArrayList();

    private FunctionArea functionArea;
    private int time = 0;
    private Boolean isPullRefresh;
    private Boolean isLoading;//是否正在加载

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        swipeRefreshLayout = findViewById(R.id.refresh);
        recyclerView = findViewById(R.id.recycleView);

        configEventTransmissionListener();
        recycleViewData.add(getFunctionArea());
        configRefreshLayout();

        swipeRefreshLayout.setRefreshing(true);
        isPullRefresh = true;
        postAsynHttp();
    }

    /**
     * 配置RecycleView
     */
    public void configEventTransmissionListener() {
        LinearLayoutManager manager = new LinearLayoutManager(Main2Activity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);
        recyclerView.setEventTransmissionListener(new EventTransmissionListener() {
            @Override
            public Object onEventTransmission(Object target, Object params, int tag, CallBack callBack) {
                Intent intent = new Intent(Main2Activity.this, ShowBigImageViewActivity.class);
                intent.putExtra("sources", (Serializable) params);
                startActivity(intent);
                return null;
            }
        });

        recyclerView.setSlideMomentumListener(new Adapter.SlideMomentumListener() {
            @Override
            public int onRemainingAmount() {
                return 30;
            }

            @Override
            public void onArriveRemainingAmount() {
                //加载更多数据
                isPullRefresh = false;
                if (!isLoading) {
                    Log.i("chg","加载更多数据😄");
                    postAsynHttp();
                }
            }
        });
    }

    public void configRefreshLayout() {
        //下拉刷新的圆圈是否显示
        swipeRefreshLayout.setRefreshing(false);
        //设置下拉时圆圈的颜色（可以由多种颜色拼成）
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light);
        //设置下拉时圆圈的背景颜色（这里设置成白色）
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isPullRefresh = true;
                postAsynHttp();
            }
        });
    }


    private void postAsynHttp() {
        isLoading = true;
        time += 1;
        OkHttpClient mOkHttpClient = new OkHttpClient();
        HashMap params = new HashMap();
        params.put("appId", "1003604205986484225");
        params.put("lat", "0");
        params.put("lng", "0");
        params.put("pageIndex", time + "");
        params.put("pageSize", "10");
        params.put("platform", "ios");
        params.put("timestamp", "1578715788332");
        params.put("token", "fcb525ba5eebef743a028fae49ff382c9387e2ed9d5e04fcee6913fc3ee4937b64a2104a27ef241b93c3d0baa401c0b39cb17883cfbbaf9895ebc813c245d22916bcd42b5c33121972592575ac2be4f0");
        params.put("version", "1.1.4");

        final Gson gson = new Gson();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, gson.toJson(params));
        Request request = new Request.Builder()
                .url("https://api.dnaerapp.com/zoology/feed/mobile/v1/feeds")
                .post(body)
                .build();

        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
//                Log.i("chg", "str:" + str);
                ServerResponse serverResponse = gson.fromJson(str, ServerResponse.class);
                final List<Found> list = serverResponse.getData();
                for (Found found : list) {
                    String type = found.getType();
                    String factor = found.getFactor();
                    ArrayList<HashMap> feedExts = found.getFeedExts();

                    if (type.equals("0")) {
                        Log.i("chg", "内容类型：" + type);
                    } else if (type.equals("1")) {
                        if (factor.equals("4")) {//精彩小视频

                        } else {//发布的内容
                            ArrayList<FoundSendData> foundSendData = parserJsonArray(gson.toJson(feedExts));
                            if (isPullRefresh) {
                                recycleViewData.add(1,foundSendData.get(0));
                            } else {
                                recycleViewData.add(foundSendData.get(0));
                            }
                        }
                    } else if (type.equals("2")) {//好友推荐

                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        isLoading = false;
                        swipeRefreshLayout.setRefreshing(false);
                        recyclerView.setData(recycleViewData);
                    }
                });
            }
        });


    }

    public ArrayList<FoundSendData> parserJsonArray(String strJson) {
        ArrayList<FoundSendData> list = new ArrayList<>();
        //创建一个Gson对象
        Gson gson = new Gson();
        //创建一个JsonParser
        JsonParser parser = new JsonParser();
        //通过JsonParser对象可以把json格式的字符串解析成一个JsonElement对象
        JsonElement el = parser.parse(strJson);

        //把JsonElement对象转换成JsonObject
        JsonObject jsonObj = null;
        if (el.isJsonObject()) {
            jsonObj = el.getAsJsonObject();
        }
        //把JsonElement对象转换成JsonArray
        JsonArray jsonArray = null;
        if (el.isJsonArray()) {
            jsonArray = el.getAsJsonArray();
        }

        //遍历JsonArray对象
        Iterator it = jsonArray.iterator();
        while (it.hasNext()) {
            JsonElement e = (JsonElement) it.next();
            //JsonElement转换为JavaBean对象
            list.add(gson.fromJson(e, FoundSendData.class));
        }
        return list;
    }

    public FunctionArea getFunctionArea() {
        if (functionArea == null) {
            functionArea = new FunctionArea();
            String[] funcs = {"附近的人", "闪聊", "树洞", "雷达", "校友通讯录", "附近的人", "闪聊", "树洞", "雷达", "校友通讯录"};
            int[] icons = {R.drawable.da_xue_man_you, R.drawable.shan_liao, R.drawable.shu_dong, R.drawable.tong_xun_lu, R.drawable.lei_da, R.drawable.da_xue_man_you, R.drawable.shan_liao, R.drawable.shu_dong, R.drawable.tong_xun_lu, R.drawable.lei_da};
            List list = new ArrayList();
            FuncItem funcItem = null;
            for (int i = 0; i < funcs.length; i++) {
                funcItem = new FuncItem();
                funcItem.setName(funcs[i]);
                funcItem.setIcon(icons[i]);
                list.add(funcItem);
            }
            functionArea.setFuncItems(list);
        }
        return functionArea;
    }
}
