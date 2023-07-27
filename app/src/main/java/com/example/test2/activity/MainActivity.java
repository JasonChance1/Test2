package com.example.test2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.test2.R;
import com.example.test2.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> dataList;

    private RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();


    }
    public void initData(){
        dataList = new ArrayList<>();
        dataList.clear();
        dataList.add("badge信息数量徽标");
        dataList.add("底部按钮导航");
        dataList.add("BottomSheet");
        dataList.add("搜索提示+下拉");
        dataList.add("导航抽屉");
        dataList.add("图像列表");
    }

    public void initView(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new RecyclerViewAdapter(dataList, position -> {
            Intent intent = null;
            if(position == 0) intent = new Intent(MainActivity.this, BadgesActivity.class);
            if(position == 1) intent = new Intent(MainActivity.this, BottomAppbarActivity.class);
            if(position == 2) intent = new Intent(MainActivity.this, BottomSheetActivity.class);
            if(position == 3) intent = new Intent(MainActivity.this, AutoCompleteActivity.class);
            if(position == 4) intent = new Intent(MainActivity.this, DrawerActivity.class);
            if(position == 5) intent = new Intent(MainActivity.this, PicListActivity.class);


            startActivity(intent);
            Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
        }, MainActivity.this);
        recyclerView.setAdapter(adapter);

    }

}