package com.hezd.navigationbar.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;

import com.hezd.navigationbar.R;

/**
 * 商城
 */
public class ShopFragment extends BaseFragment {

    public static ShopFragment newInstance(String param1, String param2) {
        ShopFragment fragment = new ShopFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_shop;
    }

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {
    }
}
