package com.chg.chgadapterdemo.Found.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chg.CHGAdapter.Adapter;
import com.chg.CHGAdapter.CHGRecyclerView;
import com.chg.CHGAdapter.EventTransmissionListener;
import com.chg.CHGAdapter.Model;
import com.chg.chgadapterdemo.Found.Holder.FuncItemViewHolder;
import com.chg.chgadapterdemo.Found.Holder.SourceViewHolder;
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
import java.io.InputStream;
import java.io.InputStreamReader;
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

    private CHGRecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List recycleViewData = new ArrayList();

    private FunctionArea functionArea;
    private int pageIndex = 0;
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
                if (target.getClass().getName().replace("$1","").equals(FuncItemViewHolder.class.getName())) {
                    Intent intent = new Intent(Main2Activity.this, SearchActivity.class);
                    startActivity(intent);
                } else if(target.getClass().getName().replace("$1","").equals(SourceViewHolder.class.getName())){
                    Intent intent = new Intent(Main2Activity.this, ShowBigImageViewActivity.class);
                    intent.putExtra("sources", (Serializable) params);
                    startActivity(intent);
                }
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
                    postAsynHttp();
                }
            }
        });

        recyclerView.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View view, int position, Model model) {
                Toast.makeText(Main2Activity.this,"我好像被点击了",Toast.LENGTH_LONG).show();
            }
        });

        recyclerView.setOnItemLongClickListener(new Adapter.OnItemLongClickListener() {
            @Override
            public Boolean onItemLongClick(RecyclerView recyclerView, View view, int position, Model model) {
                Toast.makeText(Main2Activity.this,"我好像被长按了",Toast.LENGTH_LONG).show();
                return true;
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
    void refresh(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                isLoading = false;
                swipeRefreshLayout.setRefreshing(false);
                recyclerView.setModels(recycleViewData);
            }
        });
    }

    private String readStr(InputStreamReader inputStreamReader){
        int ch;
        StringBuilder sb = new StringBuilder();
        while(true) {
            try {
                if (!((ch = inputStreamReader.read()) != -1)) break;
                sb.append((char) ch);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    //模拟网络请求
    private void postAsynHttp() {
        isLoading = true;
        pageIndex += 1;
        new Thread(new Runnable() {
            @Override
            public void run() {
                String rawName = "weibo_data_"+pageIndex;
                int responseId = Main2Activity.this.getResources().getIdentifier(rawName,"raw",Main2Activity.this.getPackageName());//获取raw中的数据
                if (responseId == 0){
                    pageIndex = 0;
                    refresh();
                    return;
                }
                try {
                    InputStream inputStream = Main2Activity.this.getResources().openRawResource(responseId);
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    String str = readStr(inputStreamReader);
                    inputStream.close();
                    Gson gson = new Gson();
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
                    refresh();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
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
            String[] funcs = {"搜索","附近的人", "闪聊", "树洞", "雷达", "校友通讯录", "附近的人", "闪聊", "树洞", "雷达", "校友通讯录"};
            int[] icons = {R.drawable.da_xue_man_you,R.drawable.da_xue_man_you, R.drawable.shan_liao, R.drawable.shu_dong, R.drawable.tong_xun_lu, R.drawable.lei_da, R.drawable.da_xue_man_you, R.drawable.shan_liao, R.drawable.shu_dong, R.drawable.tong_xun_lu, R.drawable.lei_da};
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
