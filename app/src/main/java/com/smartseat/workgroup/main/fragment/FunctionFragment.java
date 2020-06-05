package com.smartseat.workgroup.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smartseat.workgroup.R;

/**
 * 功能页面
 */

public class FunctionFragment extends Fragment {
    //加热布局控件
    private RelativeLayout mRlHeatingModel;
    //加热图片控件
    private ImageView mIvHeating;
    //加热选中图片控件
    private ImageView mIvHeatingSelected;
    //加热中文名称
    private TextView mTvHeatingTitle;
    //加热英文名称
    private TextView mTvHeatingEnglishName;
    //通风布局控件
    private RelativeLayout mRlVentilationModel;
    //通风图片控件
    private ImageView mIvVentilation;
    private ImageView mIvVentilationSelected;
    //通风中文名称
    private TextView mTvVentilationTitle;
    //通风英文名称
    private TextView mTvVentilationEnglishName;
    //按摩布局控件
    private RelativeLayout mRlMassageModel;
    //按摩图片控件
    private ImageView mIvMassage;
    //按摩中文名称
    private TextView mTvMassageTitle;
    //按摩英文名称
    private TextView mTvMassageEnglishName;
    //氛围灯布局控件
    private RelativeLayout mRlAmbientModel;
    //氛围灯图片控件
    private ImageView mIvAmbient;
    //氛围灯中文名称
    private TextView mTvAmbientTitle;
    //氛围灯英文名称
    private TextView mTvAmbientEnglishName;
    //加热座椅档位一档
    private RelativeLayout mRlHeatingOneGear;
    //加热座椅档位--底部
    private RelativeLayout mRlHeatingOneGearBottom;
    private ImageView mIvHeatingOneGear;
    private ImageView mIvHeatingOneGearBottom;
    //通风座椅档位top布局控件
    private RelativeLayout mRlVentilationOneGearTop;
    //通风座椅档位一top布局控件
    private ImageView mIvVentilationOneGearTop;
    //通风座椅档位bottom布局控件
    private RelativeLayout mRlVentilationOneGearBottom;
    //通风座椅档位一bottom布局控件
    private ImageView mIvVentilationOneGearBottom;
    //按摩座椅档位小手布局控件
    private RelativeLayout mRlMasageOneGear;
    //按摩座椅档位图片控件
    private ImageView mIvMassageGear;
    //座椅背景图控件
    private ImageView mIvVembient;
    //氛围灯阴影图片控件
    private ImageView mIvVembientShadow;
    //加热圆点档位图片控件
    private ImageView mIvHeatingCircleGear;
    //通风圆点档位图片控件
    private ImageView mIvVentilationCircleGear;
    //按摩圆点档位图片控件
    private ImageView mIvMassageCircleGear;
    //是否开启氛围灯
    private boolean mIsOpenVembientShadow = true;
    private int mHeatingCount = 1;
    private int mVentilationCount = 1;
    private int mMassageCount = 1;

    public static FunctionFragment newInstance() {
        return new FunctionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //通过参数中的布局填充获取对应布局
        View view = inflater.inflate(R.layout.activity_function_fragment, container, false);
        initView(view);
        initData();
        initEvent();
        return view;
    }

    private void initView(View view) {
        mRlHeatingModel = view.findViewById(R.id.rl_heating_model);
        mIvHeating = view.findViewById(R.id.iv_heating_model);
        mIvHeatingSelected = view.findViewById(R.id.iv_heating_model_selected);
        mTvHeatingTitle = view.findViewById(R.id.tv_heating_model_title);
        mTvHeatingEnglishName = view.findViewById(R.id.tv_heating_model_englishname);
        mRlVentilationModel = view.findViewById(R.id.rl_ventilation);
        mIvVentilation = view.findViewById(R.id.iv_ventilation);
        mIvVentilationSelected = view.findViewById(R.id.iv_ventilation_selected);
        mTvVentilationTitle = view.findViewById(R.id.tv_ventilation_title);
        mTvVentilationEnglishName = view.findViewById(R.id.tv_ventilation_englishname);
        mRlMassageModel = view.findViewById(R.id.rl_massage);
        mIvMassage = view.findViewById(R.id.iv_massage);
        mTvMassageTitle = view.findViewById(R.id.tv_massage_title);
        mTvMassageEnglishName = view.findViewById(R.id.tv_massage_englishname);
        mRlAmbientModel = view.findViewById(R.id.rl_ambient);
        mIvAmbient = view.findViewById(R.id.iv_ambient);
        mTvAmbientTitle = view.findViewById(R.id.tv_ambient_title);
        mTvAmbientEnglishName = view.findViewById(R.id.tv_ambient_englishname);
        mRlHeatingOneGear = view.findViewById(R.id.rl_heating_onegear);
        mRlHeatingOneGearBottom = view.findViewById(R.id.rl_heating_onegear_bottom);
        mIvHeatingOneGear = view.findViewById(R.id.iv_heating_onegear);
        mIvHeatingOneGearBottom = view.findViewById(R.id.iv_heating_onegear_bottom);
        mRlVentilationOneGearTop = view.findViewById(R.id.rl_ventilation_onegear_top);
        mIvVentilationOneGearTop = view.findViewById(R.id.iv_ventilation_onegear_top);
        mRlVentilationOneGearBottom = view.findViewById(R.id.rl_ventilation_onegear_bottom);
        mIvVentilationOneGearBottom = view.findViewById(R.id.iv_ventilation_onegear_bottom);
        mRlMasageOneGear = view.findViewById(R.id.rl_massage_onegear);
        mIvMassageGear = view.findViewById(R.id.iv_massage_onegear);
        mIvVembient = view.findViewById(R.id.iv_vebient);
        mIvVembientShadow = view.findViewById(R.id.iv_vebient_shadow);
        mIvHeatingCircleGear = view.findViewById(R.id.iv_heating_circle_gear);
        mIvVentilationCircleGear = view.findViewById(R.id.iv_ventilation_circle_gear);
        mIvMassageCircleGear = view.findViewById(R.id.iv_massage_circle_gear);

    }

    private void initData() {

    }

    private void initEvent() {
        //点击加热事件
        mRlHeatingModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mHeatingCount == 1) {//1
                    setHeatingModelSelected();
                    openHeatingOneGearView();
                    mHeatingCount = 2;
                } else if (mHeatingCount == 2) {//2
                    setHeatingModelSelected();
                    openHeatingTwoGearView();
                    mHeatingCount = 3;
                } else if (mHeatingCount == 3) {//3
                    setHeatingModelSelected();
                    openHeatingThreeGearView();
                    mHeatingCount = 0;
                } else {//0
                    closeHeatingGearView();
                    mHeatingCount = 1;
                }
            }
        });
        //点击通风事件
        mRlVentilationModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mVentilationCount == 1) {
                    setVentilationModelSelected();
                    openVentilationOneGearView();
                    mVentilationCount = 2;
                } else if (mVentilationCount == 2) {
                    setVentilationModelSelected();
                    openVentilationTwoGearView();
                    mVentilationCount = 3;
                } else if (mVentilationCount == 3) {
                    setVentilationModelSelected();
                    openVentilationThreeGearView();
                    mVentilationCount = 0;
                } else {
                    closeVentilationGearView();
                    mVentilationCount = 1;
                }
            }
        });
        //点击按摩事件
        mRlMassageModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMassageCount == 1) {
                    setmRlMassageModelSelected();
                    openMassageOneGearView();
                    mMassageCount = 2;
                } else if (mMassageCount == 2) {
                    setmRlMassageModelSelected();
                    openMassageTwoGearView();
                    mMassageCount = 0;
                } else {
                    closeMassageGearView();
                    mMassageCount = 1;
                }
            }
        });
        //点击氛围灯事件
        mRlAmbientModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIsOpenVembientShadow) {
                    openAmbientShadowView();
                    setAmbientModelSelected();
                    mIsOpenVembientShadow = false;
                } else {
                    closeAmbientShadowView();
                    setAmbientModelUnSelected();
                    mIsOpenVembientShadow = true;
                }

            }
        });
    }

    /**
     * 加热未选中状态样式
     */
    private void setHeatingModelUnSelected() {
        mIvHeating.setBackgroundResource(R.drawable.icon_function_heating);
        mTvHeatingTitle.setTextColor(getResources().getColor(R.color.main_tubiao_unselect));
        mTvHeatingEnglishName.setTextColor(getResources().getColor(R.color.main_tubiao_unselect));
    }

    /**
     * 加热选中状态样式
     */
    private void setHeatingModelSelected() {
        mIvHeating.setBackgroundResource(R.drawable.icon_function_heating_selected);
        mTvHeatingTitle.setTextColor(getResources().getColor(R.color.main_tubiao_select));
        mTvHeatingEnglishName.setTextColor(getResources().getColor(R.color.main_tubiao_select));
    }

    /**
     * 通风未选中状态样式
     */
    private void setVentilationModelUnSelected() {
        mIvVentilation.setBackgroundResource(R.drawable.icon_function_ventilation);
        mTvVentilationTitle.setTextColor(getResources().getColor(R.color.main_tubiao_unselect));
        mTvVentilationEnglishName.setTextColor(getResources().getColor(R.color.main_tubiao_unselect));
    }

    /**
     * 通风选中状态样式
     */
    private void setVentilationModelSelected() {
        mIvVentilation.setBackgroundResource(R.drawable.icon_function_ventilation_selected);
        mTvVentilationTitle.setTextColor(getResources().getColor(R.color.main_tubiao_select));
        mTvVentilationEnglishName.setTextColor(getResources().getColor(R.color.main_tubiao_select));
    }

    /**
     * 按摩未选中状态样式
     */
    private void setMassageModelUnSelected() {
        mIvMassage.setBackgroundResource(R.drawable.icon_function_massage);
        mTvMassageTitle.setTextColor(getResources().getColor(R.color.main_tubiao_unselect));
        mTvMassageEnglishName.setTextColor(getResources().getColor(R.color.main_tubiao_unselect));
    }

    /**
     * 按摩选中状态样式
     */
    private void setmRlMassageModelSelected() {
        mIvMassage.setBackgroundResource(R.drawable.icon_function_massage_selected);
        mTvMassageTitle.setTextColor(getResources().getColor(R.color.main_tubiao_select));
        mTvMassageEnglishName.setTextColor(getResources().getColor(R.color.main_tubiao_select));
    }

    /**
     * 氛围灯未选中状态样式
     */
    private void setAmbientModelUnSelected() {
        mIvAmbient.setBackgroundResource(R.drawable.icon_function_ambient);
        mTvAmbientTitle.setTextColor(getResources().getColor(R.color.main_tubiao_unselect));
        mTvAmbientEnglishName.setTextColor(getResources().getColor(R.color.main_tubiao_unselect));
    }

    /**
     * 氛围灯选中状态样式
     */
    private void setAmbientModelSelected() {
        mIvAmbient.setBackgroundResource(R.drawable.icon_function_ambient_selected);
        mTvAmbientTitle.setTextColor(getResources().getColor(R.color.main_tubiao_select));
        mTvAmbientEnglishName.setTextColor(getResources().getColor(R.color.main_tubiao_select));
    }

    /**
     * 打开加热一档view布局样式
     */
    private void openHeatingOneGearView() {
        mIvHeatingCircleGear.setVisibility(View.VISIBLE);
        mRlHeatingOneGear.setVisibility(View.VISIBLE);
        mRlHeatingOneGearBottom.setVisibility(View.VISIBLE);
        mIvHeatingCircleGear.setBackgroundResource(R.drawable.icon_circle_onegear);
        mIvHeatingOneGear.setBackgroundResource(R.drawable.image_heating_onegear);
        mIvHeatingOneGearBottom.setBackgroundResource(R.drawable.image_heating_onegear);
    }

    /**
     * 打开加热二档view布局样式
     */
    private void openHeatingTwoGearView() {
        mRlHeatingOneGear.setVisibility(View.VISIBLE);
        mRlHeatingOneGearBottom.setVisibility(View.VISIBLE);
        mIvHeatingCircleGear.setBackgroundResource(R.drawable.icon_circle_twogear);
        mIvHeatingOneGear.setBackgroundResource(R.drawable.image_heating_twogear);
        mIvHeatingOneGearBottom.setBackgroundResource(R.drawable.image_heating_twogear);
    }

    /**
     * 打开加热三档view布局样式
     */
    private void openHeatingThreeGearView() {
        mRlHeatingOneGear.setVisibility(View.VISIBLE);
        mRlHeatingOneGearBottom.setVisibility(View.VISIBLE);
        mIvHeatingCircleGear.setBackgroundResource(R.drawable.icon_circle_threegear);
        mIvHeatingOneGear.setBackgroundResource(R.drawable.image_heating_threegear);
        mIvHeatingOneGearBottom.setBackgroundResource(R.drawable.image_heating_threegear);
    }

    /**
     * 关闭加热档位view布局样式
     */
    private void closeHeatingGearView() {
        mIvHeatingCircleGear.setVisibility(View.INVISIBLE);
        mIvHeatingCircleGear.setBackgroundResource(R.drawable.icon_circle_onegear);
        mRlHeatingOneGear.setVisibility(View.INVISIBLE);
        mRlHeatingOneGearBottom.setVisibility(View.INVISIBLE);
        setHeatingModelUnSelected();
    }

    /**
     * 打开通风一档view布局样式
     */
    private void openVentilationOneGearView() {
        mRlVentilationOneGearTop.setVisibility(View.VISIBLE);
        mRlVentilationOneGearBottom.setVisibility(View.VISIBLE);
        mIvVentilationCircleGear.setVisibility(View.VISIBLE);
        mIvVentilationCircleGear.setBackgroundResource(R.drawable.icon_circle_onegear);
        mIvVentilationOneGearTop.setBackgroundResource(R.drawable.image_ventilation_onegear);
        mIvVentilationOneGearBottom.setBackgroundResource(R.drawable.image_ventilation_onegear);
    }

    /**
     * 打开通风二档view布局样式
     */
    private void openVentilationTwoGearView() {
        mRlVentilationOneGearTop.setVisibility(View.VISIBLE);
        mRlVentilationOneGearBottom.setVisibility(View.VISIBLE);
        mIvVentilationCircleGear.setBackgroundResource(R.drawable.icon_circle_twogear);
        mIvVentilationOneGearTop.setBackgroundResource(R.drawable.image_ventilation_twogear);
        mIvVentilationOneGearBottom.setBackgroundResource(R.drawable.image_ventilation_twogear);
    }

    /**
     * 打开通风三档view布局样式
     */
    private void openVentilationThreeGearView() {
        mRlVentilationOneGearTop.setVisibility(View.VISIBLE);
        mRlVentilationOneGearBottom.setVisibility(View.VISIBLE);
        mIvVentilationCircleGear.setBackgroundResource(R.drawable.icon_circle_threegear);
        mIvVentilationOneGearTop.setBackgroundResource(R.drawable.image_ventilation_threegear);
        mIvVentilationOneGearBottom.setBackgroundResource(R.drawable.image_ventilation_threegear);
    }

    /**
     * 关闭通风档位view布局样式
     */
    private void closeVentilationGearView() {
        mIvVentilationCircleGear.setVisibility(View.INVISIBLE);
        mRlVentilationOneGearTop.setVisibility(View.INVISIBLE);
        mRlVentilationOneGearBottom.setVisibility(View.INVISIBLE);
        mIvVentilationCircleGear.setBackgroundResource(R.drawable.icon_circle_onegear);
        setVentilationModelUnSelected();
    }

    /**
     * 打开按摩一档view布局样式
     */
    private void openMassageOneGearView() {
        mRlMasageOneGear.setVisibility(View.VISIBLE);
        mIvMassageCircleGear.setVisibility(View.VISIBLE);
        mIvMassageCircleGear.setBackgroundResource(R.drawable.icon_circle_massage_onegear);
        mIvMassageGear.setBackgroundResource(R.drawable.image_massage_left_onegear);
    }

    /**
     * 打开按摩二档view布局样式
     */
    private void openMassageTwoGearView() {
        mRlMasageOneGear.setVisibility(View.VISIBLE);
        mIvMassageCircleGear.setBackgroundResource(R.drawable.icon_circle_massage_twogear);
        mIvMassageGear.setBackgroundResource(R.drawable.image_massage_right_onegear);
    }

    /**
     * 关闭按摩档位view布局样式
     */
    private void closeMassageGearView() {
        mIvMassageCircleGear.setVisibility(View.INVISIBLE);
        mRlMasageOneGear.setVisibility(View.INVISIBLE);
        mIvMassageCircleGear.setBackgroundResource(R.drawable.icon_circle_massage_onegear);
        setMassageModelUnSelected();
    }

    /**
     * 打开氛围灯view布局
     */
    private void openAmbientShadowView() {
        mIvVembientShadow.setVisibility(View.VISIBLE);
    }

    /**
     * 关闭氛围灯view布局
     */
    private void closeAmbientShadowView() {
        mIvVembientShadow.setVisibility(View.GONE);
    }

}
