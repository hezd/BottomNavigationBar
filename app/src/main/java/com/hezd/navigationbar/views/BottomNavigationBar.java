package com.hezd.navigationbar.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hezd.navigationbar.R;
import com.hezd.navigationbar.utils.DensityUtil;

/**
 * 自定义底部导航栏
 * @auther hezd
 * created on 2018/8/19 19:54
 */
public class BottomNavigationBar extends LinearLayout implements IViews, View.OnClickListener {

    private TextView mMainBtn;
    private TextView mMineBtn;
    private TextView mMessageBtn;
    private TextView mPublishBtn;
    private TextView mShopBtn;
    private OnNavigationBarClickListener mListener;
    private TextView mMessageCountTv;

    public BottomNavigationBar(Context context) {
        super(context);
        init(context);
    }

    public BottomNavigationBar(Context context, AttributeSet attrs) {
        super(context,attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_navigation_bar,this);
        getViews();
        setViews();
        setListener();
    }


    @Override
    public void getViews() {
        mMainBtn = findViewById(R.id.tv_main);
        mShopBtn = findViewById(R.id.tv_shop);
        mPublishBtn = findViewById(R.id.tv_publish);
        mMessageBtn = findViewById(R.id.tv_message);
        mMineBtn = findViewById(R.id.tv_mine);
        mMessageCountTv = findViewById(R.id.tv_message_count);
    }

    @Override
    public void setViews() {
        mMessageBtn.post(new Runnable(){
            @Override
            public void run() {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mMessageCountTv.getLayoutParams();
                int width = mMessageBtn.getWidth();
                int height = mMessageBtn.getHeight();
                layoutParams.leftMargin = mMessageBtn.getRight()-width/2+ DensityUtil.dip2px(getContext(),5);
                layoutParams.topMargin = mMessageBtn.getTop()-height/2+height/7;
            }

        });
    }

    @Override
    public void setListener() {
        mMainBtn.setOnClickListener(this);
        mShopBtn.setOnClickListener(this);
        mPublishBtn.setOnClickListener(this);
        mMessageBtn.setOnClickListener(this);
        mMineBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Drawable drawableTop;
        switch (v.getId()) {
            case R.id.tv_main:
                resetViews();
                drawableTop = getContext().getResources().getDrawable(R.mipmap.icon_main_selected);
                mMainBtn.setCompoundDrawablesWithIntrinsicBounds(null,drawableTop,null,null);
                mMainBtn.setTextColor(Color.RED);
                addListerner(0);
                break;
            case R.id.tv_shop:
                resetViews();
                drawableTop = getContext().getResources().getDrawable(R.mipmap.icon_shop_selected);
                mShopBtn.setCompoundDrawablesWithIntrinsicBounds(null,drawableTop,null,null);
                mShopBtn.setTextColor(Color.RED);
                addListerner(1);
                break;
            case R.id.tv_publish:
                addListerner(2);
                break;
            case R.id.tv_message:
                resetViews();
                drawableTop = getContext().getResources().getDrawable(R.mipmap.icon_message_selected);
                mMessageBtn.setCompoundDrawablesWithIntrinsicBounds(null,drawableTop,null,null);
                mMessageBtn.setTextColor(Color.RED);
                addListerner(3);
                break;
            case R.id.tv_mine:
                resetViews();
                mMineBtn.setTextColor(Color.RED);
                addListerner(4);
                break;
        }
    }

    private void addListerner(int position) {
        if(mListener!=null)
            mListener.onNavigationBarClick(position);
    }

    private void resetViews() {

        mMainBtn.setTextColor(Color.BLACK);
        mShopBtn.setTextColor(Color.BLACK);
        mPublishBtn.setTextColor(Color.BLACK);
        mMessageBtn.setTextColor(Color.BLACK);
        mMineBtn.setTextColor(Color.BLACK);

        Drawable drawableTop;
        drawableTop = getContext().getResources().getDrawable(R.mipmap.icon_unselected);
        mMainBtn.setCompoundDrawablesWithIntrinsicBounds(null,drawableTop,null,null);

        drawableTop = getContext().getResources().getDrawable(R.mipmap.icon_shop_unselected);
        mShopBtn.setCompoundDrawablesWithIntrinsicBounds(null,drawableTop,null,null);

        drawableTop = getContext().getResources().getDrawable(R.mipmap.icon_message_unselected);
        mMessageBtn.setCompoundDrawablesWithIntrinsicBounds(null,drawableTop,null,null);
    }

    public void setOnNavigationBarClickListener(OnNavigationBarClickListener onNavigationBarClickListener) {
        this.mListener = onNavigationBarClickListener;
    }

    public interface OnNavigationBarClickListener {
        void onNavigationBarClick(int position);
    }
}
