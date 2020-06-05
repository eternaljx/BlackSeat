package com.smartseat.workgroup.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.smartseat.workgroup.R;
import com.smartseat.workgroup.common.event.InitSwitchEvent;
import com.smartseat.workgroup.common.utils.SPUtils;
import com.smartseat.workgroup.main.fragment.AdjustFragment;
import com.smartseat.workgroup.main.fragment.FunctionFragment;
import com.smartseat.workgroup.main.fragment.MainFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 智能座椅主页面
 *
 * @author jx
 */
public class SeatMainActivity extends FragmentActivity {

    //底部功能布局控件
    private RelativeLayout mRlBottomFunction;
    //底部首页布局控件
    private RelativeLayout mRlBottomMain;
    //底部调节布局控件
    private RelativeLayout mRlBottomAdjust;
    private FragmentTransaction transaction;
    //调节页面
    private AdjustFragment mAdjustFragment;
    //功能页面
    private FunctionFragment functionFragment;
    //首页页面
    private MainFragment mainFragment;
    //功能页面底部图标控件
    private ImageView mIvFunctionBottom;
    //主页面底部图标控件
    private ImageView mIvMainBottom;
    //调节页面底部图标控件
    private ImageView mIvAdjustBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_main);
        EventBus.getDefault().register(this);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mRlBottomFunction = findViewById(R.id.rl_bottom_one);
        mRlBottomMain = findViewById(R.id.rl_bottom_two);
        mRlBottomAdjust = findViewById(R.id.rl_bottom_three);
        mIvFunctionBottom = findViewById(R.id.iv_function_bottom);
        mIvMainBottom = findViewById(R.id.iv_main_bottom);
        mIvAdjustBottom = findViewById(R.id.iv_adjust_bottom);
    }

    private void initData() {
        //添加初始Fragment
        defaultFragment(null == mAdjustFragment ? mAdjustFragment = AdjustFragment.newInstance() : mAdjustFragment);
        if (null == mainFragment) {
            mainFragment = MainFragment.newInstance();
        }
        replaceFragment(mainFragment);
    }

    private void initEvent() {
        //点击功能事件
        mRlBottomFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvFunctionBottom.setBackgroundResource(R.drawable.icon_one_bottom_selected);
                mIvMainBottom.setBackgroundResource(R.drawable.icon_two_bottom);
                mIvAdjustBottom.setBackgroundResource(R.drawable.icon_three_bottom);
                if (null == functionFragment) {
                    functionFragment = FunctionFragment.newInstance();
                }
                replaceFragment(functionFragment);
            }
        });
        //点击首页事件
        mRlBottomMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvFunctionBottom.setBackgroundResource(R.drawable.icon_one_bottom);
                mIvMainBottom.setBackgroundResource(R.drawable.icon_two_bottom_selected);
                mIvAdjustBottom.setBackgroundResource(R.drawable.icon_three_bottom);
                if (null == mainFragment) {
                    mainFragment = MainFragment.newInstance();
                }
                replaceFragment(mainFragment);
            }
        });
        //点击调节事件
        mRlBottomAdjust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvFunctionBottom.setBackgroundResource(R.drawable.icon_one_bottom);
                mIvMainBottom.setBackgroundResource(R.drawable.icon_two_bottom);
                mIvAdjustBottom.setBackgroundResource(R.drawable.icon_three_bottom_selected);
                if (null == mAdjustFragment) {
                    mAdjustFragment = AdjustFragment.newInstance();
                }
                replaceFragment(mAdjustFragment);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();
        transaction.replace(R.id.main_fragment_layout, fragment);
//        transaction.hide();
        transaction.commit();

    }

    private void defaultFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();
        transaction.add(R.id.main_fragment_layout, fragment);
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void exitLogin(InitSwitchEvent.exitLogin event) {
        SPUtils.remove(SeatMainActivity.this, "isLogin");
        finish();
    }

}
