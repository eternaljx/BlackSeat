package com.smartseat.workgroup.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smartseat.workgroup.R;

/**
 * 调节页面
 *
 * @author jx
 */
public class AdjustFragment extends Fragment {

    //座椅前后背景图片控件
    private ImageView mIvSeatQianhou;
    //座椅向前调节点击控件
    private View mVSeatBeforeClick;
    //座椅向后调节点击控件
    private View mVSeatAfterClick;
    //座椅头枕点击控件
    private View mViewTouzhenClick;
    //座椅头枕选中背景图片控件
    private ImageView mIvTouzhenSelected;
    //座椅头枕向上调节点击控件
    private View mViewTouzhenTopClick;
    //座椅头枕向下调节点击控件
    private View mViewTouzhenBottomClick;
    //座椅头枕上下调节控件
    private ImageView mIvTouzhenDefault;
    //座椅腿托点击控件
    private View mViewTuituoClick;
    //座椅腿托选中背景图片控件
    private ImageView mIvTuituoSelected;
    //座椅腿托向后点击控件
    private View mViewTuituoAfterClick;
    //座椅腿托向前点击控件
    private View mViewTuituoBeforeClick;
    //座椅腿托前后默认背景控件
    private ImageView mIvSeatTuituoDefault;
    //座椅靠背点击控件
    private View mViewKaobeiClick;
    //座椅靠背选中背景图片控件
    private ImageView mIvKaobeiSelected;
    //座椅靠背默认图片
    private ImageView mIvKaobeiDefault;
    //座椅靠背向后调节点击控件
    private View mVKaobeiLeftClick;
    //座椅靠背向前调节点击控件
    private View mVKaobeiRightClick;
    //座椅腰枕点击控件
    private View mViewYaozhenClick;
    //座椅腰枕选中图片控件
    private ImageView mIvYaozhenSelected;
    //座椅腰枕调节默认图片控件
    private ImageView mIvYaozhenDefault;
    //座椅腰枕向上调节点击控件
    private View mViewYaozhenTopClick;
    //座椅腰枕向下调节点击控件
    private View mViewYaozhenBottomClick;
    //座椅腰枕向左调节点击控件
    private View mViewYaozhenLeftClick;
    //座椅腰枕向右调节点击控件
    private View mViewYaozhenRightClick;


    public static AdjustFragment newInstance() {
        return new AdjustFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //通过参数中的布局填充获取对应布局
        View view = inflater.inflate(R.layout.activity_adjust_fragment, container, false);
        initView(view);
        initEvent();
        return view;

    }

    private void initView(View view) {
        mViewKaobeiClick = view.findViewById(R.id.v_seat_kaobei_click);
        mIvKaobeiSelected = view.findViewById(R.id.v_seat_kaobei_selected);
        mIvKaobeiDefault = view.findViewById(R.id.v_seat_kaobei);
        mVKaobeiLeftClick = view.findViewById(R.id.v_seat_kaobei_left);
        mVKaobeiRightClick = view.findViewById(R.id.v_seat_kaobei_right);
        mIvSeatQianhou = view.findViewById(R.id.iv_seat_qianhou);
        mVSeatBeforeClick = view.findViewById(R.id.v_seat_before_click);
        mVSeatAfterClick = view.findViewById(R.id.v_seat_after_click);
        mViewTuituoClick = view.findViewById(R.id.v_seat_tuituo_click);
        mIvTuituoSelected = view.findViewById(R.id.v_seat_tuituo_selected);
        mViewTuituoAfterClick = view.findViewById(R.id.v_seat_tuituo_left_click);
        mViewTuituoBeforeClick = view.findViewById(R.id.v_seat_tuituo_right_click);
        mIvSeatTuituoDefault = view.findViewById(R.id.iv_seat_tuituo_default);
        mViewTouzhenClick = view.findViewById(R.id.v_seat_touzhen_click);
        mIvTouzhenSelected = view.findViewById(R.id.v_seat_touzhen_selected);
        mViewTouzhenTopClick = view.findViewById(R.id.v_seat_touzhen_top_click);
        mViewTouzhenBottomClick = view.findViewById(R.id.v_seat_touzhen_bottom_click);
        mIvTouzhenDefault = view.findViewById(R.id.iv_seat_touzhen_default);
        mViewYaozhenClick = view.findViewById(R.id.v_seat_yaozhen_click);
        mIvYaozhenSelected = view.findViewById(R.id.v_seat_yaozhen_selected);
        mIvYaozhenDefault = view.findViewById(R.id.iv_seat_yaozhen_default);
        mViewYaozhenTopClick = view.findViewById(R.id.v_seat_yaozhen_top_click);
        mViewYaozhenBottomClick = view.findViewById(R.id.v_seat_yaozhen_bottom_click);
        mViewYaozhenLeftClick = view.findViewById(R.id.v_seat_yaozhen_left_click);
        mViewYaozhenRightClick = view.findViewById(R.id.v_seat_yaozhen_right_click);
    }

    private void initEvent() {
        //座椅靠背点击事件
        mViewKaobeiClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示靠背选中背景图片、前后调节白色图片
                mIvKaobeiSelected.setVisibility(View.VISIBLE);
                mIvKaobeiDefault.setVisibility(View.VISIBLE);
                mIvKaobeiDefault.setBackgroundResource(R.drawable.icon_seat_kaobei_default);
                mViewKaobeiClick.setClickable(false);

            }
        });
        //座椅靠背向后调节点击事件
        mVKaobeiLeftClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvKaobeiDefault.setBackgroundResource(R.drawable.icon_seat_kaobei_before);
            }
        });
        //座椅靠背向前调节点击事件
        mVKaobeiRightClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvKaobeiDefault.setBackgroundResource(R.drawable.icon_seat_kaobei_after);
            }
        });
        //座椅腿托调节点击事件
        mViewTuituoClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示腿托选中背景图片、前后调节白色图片
                mIvTuituoSelected.setVisibility(View.VISIBLE);
                mIvSeatTuituoDefault.setVisibility(View.VISIBLE);
                mIvSeatTuituoDefault.setBackgroundResource(R.drawable.icon_seat_tuituo_default);
                mViewTuituoClick.setClickable(false);
            }
        });
        //座椅腿托向后调节点击事件
        mViewTuituoAfterClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvSeatTuituoDefault.setBackgroundResource(R.drawable.icon_seat_tuituo_after);
            }
        });
        //座椅腿托向前调节点击事件
        mViewTuituoBeforeClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvSeatTuituoDefault.setBackgroundResource(R.drawable.icon_seat_tuituo_before);
            }
        });
        //座椅头枕调节点击事件
        mViewTouzhenClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvTouzhenSelected.setVisibility(View.VISIBLE);
                mIvTouzhenDefault.setVisibility(View.VISIBLE);
                mIvTouzhenDefault.setBackgroundResource(R.drawable.icon_seat_touzhen_default);
                mViewTouzhenClick.setClickable(false);
            }
        });
        //座椅头枕向上调节点击事件
        mViewTouzhenTopClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvTouzhenDefault.setBackgroundResource(R.drawable.icon_seat_touzhen_top);
            }
        });
        //座椅头枕向下调节点击事件
        mViewTouzhenBottomClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvTouzhenDefault.setBackgroundResource(R.drawable.icon_seat_touzhen_bottom);
            }
        });
        //座椅腰枕点击事件
        mViewYaozhenClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvYaozhenSelected.setVisibility(View.VISIBLE);
                mIvYaozhenDefault.setVisibility(View.VISIBLE);
                mViewYaozhenClick.setClickable(false);
            }
        });
        //座椅腰枕向上调节点击事件
        mViewYaozhenTopClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvYaozhenDefault.setBackgroundResource(R.drawable.icon_seat_yaozhen_top);
            }
        });
        //座椅腰枕向下调节点击事件
        mViewYaozhenBottomClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvYaozhenDefault.setBackgroundResource(R.drawable.icon_seat_yaozhen_bottom);
            }
        });
        //座椅腰枕向后调节点击事件
        mViewYaozhenLeftClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvYaozhenDefault.setBackgroundResource(R.drawable.icon_seat_yaozhen_left);
            }
        });
        //座椅腰枕向前调节点击事件
        mViewYaozhenRightClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvYaozhenDefault.setBackgroundResource(R.drawable.icon_seat_yaozhen_right);
            }
        });
        //座椅向前调节点击事件
        mVSeatBeforeClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvSeatQianhou.setBackgroundResource(R.drawable.icon_seat_qianhou_after);
            }
        });
        //座椅向后调节点击事件
        mVSeatAfterClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvSeatQianhou.setBackgroundResource(R.drawable.icon_seat_qianhou_before);
            }
        });
    }
}
