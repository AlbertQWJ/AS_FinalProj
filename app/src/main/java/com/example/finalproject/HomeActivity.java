package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNav);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new MusicFragment()).commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.navigation_music:
                        fragment = new MusicFragment();
                        break;
                    case R.id.navigation_search:
                        fragment = new SearchFragment();
                        break;
                    case R.id.navigation_video:
                        fragment = new VideoFragment();
                        break;
                    case R.id.navigation_list:
                        fragment = new ListFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();

                return true;
            }
        });
    }
}