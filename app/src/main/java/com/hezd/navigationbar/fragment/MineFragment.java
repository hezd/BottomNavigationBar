package com.hezd.navigationbar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.hezd.navigationbar.R;

/**
 * 我的
 */
public class MineFragment  extends BaseFragment {

    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

    }

}