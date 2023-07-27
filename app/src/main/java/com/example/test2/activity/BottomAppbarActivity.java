package com.example.test2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.test2.R;
import com.google.android.material.bottomappbar.BottomAppBar;

public class BottomAppbarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_appbar);

        BottomAppBar bottomAppBar = findViewById(R.id.appBar);
        setSupportActionBar(bottomAppBar);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        bottomAppBar.setOnMenuItemClickListener(item -> {
            if(item.getItemId() == R.id.menu_home) navController.navigate(R.id.homeFragment);
            if(item.getItemId() == R.id.menu_dashboard) navController.navigate(R.id.fragment3);
            if(item.getItemId() == R.id.menu_notifications) navController.navigate(R.id.notificationFragment);

            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_app_bar_menu, menu);
        return true;
    }

}