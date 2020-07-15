package com.hezd.navigationbar.fragment;


import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;

import com.hezd.navigationbar.R;

/**
 * 消息中心
 */
public class MessageFragment extends BaseFragment {

    public static MessageFragment newInstance(String param1, String param2) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_message;
    }

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {

    }
}
