package com.d2payments.simranclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.d2payments.simranclone.fragments.HomeFragment;
import com.d2payments.simranclone.fragments.MyAccountFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    Fragment currentFragment;
    HomeFragment homeFragment;
    MyAccountFragment myAccountFragment;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationBar);
        homeFragment = new HomeFragment();
        myAccountFragment = new MyAccountFragment();
        currentFragment = new HomeFragment();
        frameLayout = findViewById(R.id.mainFrameLayout);


        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.mainFrameLayout,homeFragment,"HOME_FRAGMENT").commit();
        fragmentManager.beginTransaction().add(R.id.mainFrameLayout,myAccountFragment,"MY_ACCOUNT_FRAGMENT").hide(myAccountFragment).commit();




        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:

                        fragmentManager.beginTransaction().hide(currentFragment).show(homeFragment).commit();
                        currentFragment = homeFragment;

                        return true;
                    case R.id.account :
                        fragmentManager.beginTransaction().hide(currentFragment).show(myAccountFragment).commit();
                        currentFragment = myAccountFragment;
                        return true;
                }
                return false;
            }
        });

    }




