package com.smartseat.workgroup.main.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smartseat.workgroup.R;

/**
 * 首页页面
 *
 * @author jx
 */
public class MainFragment extends Fragment {
    private RelativeLayout mRlContanier;

    //睡眠模式布局控件
    private RelativeLayout mRlSleepModel;
    //一键复位模式布局控件
    private RelativeLayout mRlOneKeyResetModel;
    //睡眠模式图片
    private ImageView mIvSleepModel;
    //睡眠模式中午名称
    private TextView mTvSleepModelTitle;
    //睡眠模式英文名称
    private TextView mTvSleepModelEnglishName;
    //一键复位模式图片
    private ImageView mIvOneKeyResetModel;
    //一键复位模式中文名称
    private TextView mTvOneKeyResetModelTitle;
    //一键复位模式英文名称
    private TextView mTvOneKeyResetModelEnglishName;
    //睡眠模式弹框
    private RelativeLayout mRlSleepModelAlert;
    //一键复位弹框
    private RelativeLayout mRlOneKeyResetModelAlert;
    //睡眠模式存储图标
    private ImageView mIvSleepModelSave;
    //睡眠模式删除图标
    private ImageView mIvSleepModelDelete;
    //显示睡眠模式存储文案
    private TextView mTvSleepModelTip;
    //一键复位存储图标
    private ImageView mIvOneKeyResetSave;
    //一键复位删除图标
    private ImageView mIvOneKeyResetDelete;
    //显示一键复位存储文案
    private TextView mTvOneKeyResetTip;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        //通过参数中的布局填充获取对应布局
        View view = inflater.inflate(R.layout.activity_main_fragment, container, false);
        initView(view);
        initEvent();
        return view;
    }

    private void initView(View view) {
        mRlContanier=view.findViewById(R.id.fl_container);
        mRlSleepModel = view.findViewById(R.id.rl_sleep_model);
        mIvSleepModel = view.findViewById(R.id.iv_sleep_model);
        mTvSleepModelTitle = view.findViewById(R.id.tv_sleep_model);
        mTvSleepModelEnglishName = view.findViewById(R.id.tv_sleep_model_englishname);
        mRlOneKeyResetModel = view.findViewById(R.id.rl_one_keyreset);
        mIvOneKeyResetModel = view.findViewById(R.id.iv_one_keyreset);
        mTvOneKeyResetModelTitle = view.findViewById(R.id.tv_one_keyreset);
        mTvOneKeyResetModelEnglishName = view.findViewById(R.id.iv_one_keyreset_englishname);
        mRlSleepModelAlert=view.findViewById(R.id.rl_sleep_model_alert);
        mRlOneKeyResetModelAlert=view.findViewById(R.id.rl_one_keyreset_alert);
        mIvSleepModelSave = view.findViewById(R.id.iv_icon_main_alert_save);
        mIvSleepModelDelete = view.findViewById(R.id.iv_icon_main_alert_delete);
        mTvSleepModelTip = view.findViewById(R.id.tv_sleep_model_tips);
        mIvOneKeyResetSave=view.findViewById(R.id.iv_icon_one_keyreset_save);
        mIvOneKeyResetDelete=view.findViewById(R.id.iv_icon_one_keyreset_delete);
        mTvOneKeyResetTip=view.findViewById(R.id.tv_one_keyreset_tips);
    }

    private void initEvent() {
        mRlContanier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRlSleepModelAlert.setVisibility(View.INVISIBLE);
                mRlOneKeyResetModelAlert.setVisibility(View.INVISIBLE);
            }
        });
        //点击睡眠模式
        mRlSleepModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点亮设置里的睡眠模式，弹出框
                mRlSleepModelAlert.setVisibility(View.VISIBLE);
            }
        });
        //点击一键复位模式
        mRlOneKeyResetModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点亮设置里的一键复位模式
                mRlOneKeyResetModelAlert.setVisibility(View.VISIBLE);
            }
        });

        SpannableString spanContent = new SpannableString(mTvSleepModelTip.getText().toString());
        spanContent.setSpan(new ForegroundColorSpan(Color.parseColor("#3eb5e0")), 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvSleepModelTip.setText(spanContent);
        //存储睡眠
        mIvSleepModelSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvSleepModelSave.setBackgroundResource(R.drawable.icon_main_alert_save_selected);
                mIvSleepModelDelete.setBackgroundResource(R.drawable.icon_main_alert_delete);
                setSleepModelSelectedStatus();
            }
        });
        //移除睡眠
        mIvSleepModelDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvSleepModelSave.setBackgroundResource(R.drawable.icon_main_alert_save);
                mIvSleepModelDelete.setBackgroundResource(R.drawable.icon_main_alert_delete_selected);
                setSleepModelUnSelectedStatus();
            }
        });
        SpannableString spanOneKeyResetContent = new SpannableString(mTvOneKeyResetTip.getText().toString());
        spanOneKeyResetContent.setSpan(new ForegroundColorSpan(Color.parseColor("#3eb5e0")), 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvOneKeyResetTip.setText(spanOneKeyResetContent);
        mIvOneKeyResetSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvOneKeyResetSave.setBackgroundResource(R.drawable.icon_main_alert_save_selected);
                mIvOneKeyResetDelete.setBackgroundResource(R.drawable.icon_main_alert_delete);
                setOnKeyResetModelSelected();
            }
        });
        mIvOneKeyResetDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvOneKeyResetSave.setBackgroundResource(R.drawable.icon_main_alert_save);
                mIvOneKeyResetDelete.setBackgroundResource(R.drawable.icon_main_alert_delete_selected);
                setOnKeyResetModelUnSelected();
            }
        });
    }

    /**
     * 睡眠模式未选中状态样式
     */
    private void setSleepModelUnSelectedStatus() {
        mIvSleepModel.setBackgroundResource(R.drawable.icon_main_sleep);
        mTvSleepModelTitle.setTextColor(getResources().getColor(R.color.main_tubiao_unselect));
        mTvSleepModelEnglishName.setTextColor(getResources().getColor(R.color.main_tubiao_unselect));

    }

    /**
     * 睡眠模式选中状态样式
     */
    private void setSleepModelSelectedStatus() {
        mIvSleepModel.setBackgroundResource(R.drawable.icon_main_sleep_selected);
        mTvSleepModelTitle.setTextColor(getResources().getColor(R.color.main_tubiao_select));
        mTvSleepModelEnglishName.setTextColor(getResources().getColor(R.color.main_tubiao_select));
    }

    /**
     * 一键复位未选中状态样式
     */
    private void setOnKeyResetModelUnSelected() {
        mIvOneKeyResetModel.setBackgroundResource(R.drawable.icon_main_onekeyreset);
        mTvOneKeyResetModelTitle.setTextColor(getResources().getColor(R.color.main_tubiao_unselect));
        mTvOneKeyResetModelEnglishName.setTextColor(getResources().getColor(R.color.main_tubiao_unselect));
    }

    /**
     * 一键复位选中状态样式
     */
    private void setOnKeyResetModelSelected() {
        mIvOneKeyResetModel.setBackgroundResource(R.drawable.icon_main_onekeyreset_selected);
        mTvOneKeyResetModelTitle.setTextColor(getResources().getColor(R.color.main_tubiao_select));
        mTvOneKeyResetModelEnglishName.setTextColor(getResources().getColor(R.color.main_tubiao_select));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
