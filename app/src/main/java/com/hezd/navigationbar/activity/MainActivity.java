package com.hezd.navigationbar.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.hezd.navigationbar.R;
import com.hezd.navigationbar.fragment.MainFragment;
import com.hezd.navigationbar.fragment.MessageFragment;
import com.hezd.navigationbar.fragment.MineFragment;
import com.hezd.navigationbar.fragment.ShopFragment;
import com.hezd.navigationbar.views.BottomNavigationBar;


/**
 * 首页
 */
public class MainActivity extends FragmentActivity implements BottomNavigationBar.OnNavigationBarClickListener {
    BottomNavigationBar mNavigationBar;
    MainFragment mainFragment;
    ShopFragment shopFragment;
    MessageFragment messageFragment;
    MineFragment mineFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();
        init();
    }

    private void initViews() {
        mNavigationBar = findViewById(R.id.navigationBar);
    }

    private void init() {
        onNavigationBarClick(0);
    }

    public void setListeners() {
        mNavigationBar.setOnNavigationBarClickListener(this);
    }

    @Override
    public void onNavigationBarClick(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                hideFragments(fragmentTransaction);
                if(mainFragment == null) {
                    mainFragment = MainFragment.newInstance(null,null);
                    fragmentTransaction.add(R.id.fl_content,mainFragment);
                }else {
                    fragmentTransaction.show(mainFragment);
                }
                break;
            case 1:
                hideFragments(fragmentTransaction);
                if(shopFragment == null) {
                    shopFragment = ShopFragment.newInstance(null,null);
                    fragmentTransaction.add(R.id.fl_content,shopFragment);
                }else {
                    fragmentTransaction.show(shopFragment);
                }
                break;
            case 2:
                Toast.makeText(this,"发布",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                hideFragments(fragmentTransaction);
                if(messageFragment == null) {
                    messageFragment = MessageFragment.newInstance(null,null);
                    fragmentTransaction.add(R.id.fl_content,messageFragment);
                }else {
                    fragmentTransaction.show(messageFragment);
                }
                break;
            case 4:
                hideFragments(fragmentTransaction);
                if(mineFragment == null) {
                    mineFragment = MineFragment.newInstance(null,null);
                    fragmentTransaction.add(R.id.fl_content,mineFragment);
                }else {
                    fragmentTransaction.show(mineFragment);
                }
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void hideFragments(FragmentTransaction fragmentTransaction) {
        if(mainFragment !=null) {
            fragmentTransaction.hide(mainFragment);
        }

        if(shopFragment !=null) {
            fragmentTransaction.hide(shopFragment);
        }

        if(messageFragment !=null) {
            fragmentTransaction.hide(messageFragment);
        }

        if(mineFragment !=null) {
            fragmentTransaction.hide(mineFragment);
        }
    }

}
