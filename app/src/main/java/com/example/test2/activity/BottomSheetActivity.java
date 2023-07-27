package com.example.test2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.example.test2.R;
import com.example.test2.adapter.RecyclerViewAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);


        NestedScrollView nestedScrollView = findViewById(R.id.nestedScrollView);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(nestedScrollView);

        LinearLayout layout = findViewById(R.id.topButton);
        layout.setOnClickListener(view -> {
            if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED)
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
            if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HALF_EXPANDED)
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        });

        int peekHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
        bottomSheetBehavior.setPeekHeight(peekHeight);//设置最小高度
        bottomSheetBehavior.setHideable(false);//设置是否可隐藏
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);


        //获取屏幕的高度
        int heightPixels = getResources().getDisplayMetrics().heightPixels;
        final CardView cardView = findViewById(R.id.cardView);
        cardView.post(() -> {
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) cardView.getLayoutParams();

            //获取状态栏的高度
            int statusBarHeight = 0;
            int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                statusBarHeight = getResources().getDimensionPixelSize(resourceId);
            }
            //输入框至屏幕顶部的高度
            int marginTop = cardView.getHeight() + lp.topMargin + lp.bottomMargin / 2 + statusBarHeight;
            //底部列表的最大高度
            int maxHeight = heightPixels - marginTop ;

            bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    if (newState != BottomSheetBehavior.STATE_DRAGGING) {
                        ViewGroup.LayoutParams layoutParams = bottomSheet.getLayoutParams();
                        if (bottomSheet.getHeight() > maxHeight ) {
                            layoutParams.height = maxHeight ;
                            bottomSheet.setLayoutParams(layoutParams);
                        }
                    }
                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                }
            });
        });



        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(BottomSheetActivity.this));
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        RecyclerView.Adapter adapter = new RecyclerViewAdapter(list, position -> {

        },this);

        recyclerView.setAdapter(adapter);
    }
}