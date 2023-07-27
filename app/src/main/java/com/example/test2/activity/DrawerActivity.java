package com.example.test2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.test2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.blankj.utilcode.util.ToastUtils;
public class DrawerActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        drawerLayout = findViewById(R.id.drawerLayout);
        FloatingActionButton btn = findViewById(R.id.spread_btn);
        btn.setOnClickListener(view -> {
            if(drawerLayout.isOpen())
                drawerLayout.close();
            else drawerLayout.openDrawer(GravityCompat.START);
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
//        navigationView.setNavigationItemSelectedListener(item ->   {
//            int id = item.getItemId();
//
//            if (id == R.id.item1 || id == R.id.item2 || id == R.id.item3) {
//                item.setChecked(true);
//            } else if (id == R.id.item4 || id == R.id.item5) {
//                navigationView.getMenu().findItem(R.id.subtitle).setChecked(true);
//                item.setChecked(true);
//            }
//
//            if (id == R.id.item1) {
//                Toast.makeText(this, "Menu Item 1 Clicked", Toast.LENGTH_SHORT).show();
//                return true;
//            } else if (id == R.id.item2) {
//                Toast.makeText(this, "Menu Item 2 Clicked", Toast.LENGTH_SHORT).show();
//                return true;
//            } else if (id == R.id.item3) {
//                Toast.makeText(this, "Menu Item 3 Clicked", Toast.LENGTH_SHORT).show();
//                return true;
//            } else if (id == R.id.item4) {
//                Toast.makeText(this, "Menu Item 4 Clicked", Toast.LENGTH_SHORT).show();
//                return true;
//            } else if (id == R.id.item5) {
//                Toast.makeText(this, "Menu Item 5 Clicked", Toast.LENGTH_SHORT).show();
//                return true;
//            } else {
//                return false;
//            }
//        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                item.setChecked(true);
                return true;
            }
        });
    }
}