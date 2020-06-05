package com.smartseat.workgroup.common.event;


import com.smartseat.workgroup.main.model.SettingServiceModel;

import java.util.List;

/**
 * @author jx
 * 首页模块开关事件
 */

public class InitSwitchEvent extends BaseEvent {

    public static class getSettingServiceList extends InitSwitchEvent {
        private List<SettingServiceModel> mSettingServiceModelList;

        public getSettingServiceList(List<SettingServiceModel> settingServiceModelList) {
            this.mSettingServiceModelList = settingServiceModelList;
        }

        public List<SettingServiceModel> getmSettingServiceModelList() {
            return mSettingServiceModelList;
        }

        public void setmSettingServiceModelList(List<SettingServiceModel> mSettingServiceModelList) {
            this.mSettingServiceModelList = mSettingServiceModelList;
        }
    }

    /**
     * 刪除集合中某条数据，更新数据
     */
    public static class deleteSingleListData extends InitSwitchEvent {

    }

    /**
     * 退出登录
     */
    public static class exitLogin extends InitSwitchEvent {

    }

    /**
     * 睡眠模式存储接收事件
     */
    public static class handleSleepModelSave extends InitSwitchEvent {

    }

    /**
     * 睡眠模式移除接收事件
     */
    public static class handleSleepModelDelete extends InitSwitchEvent {

    }

    /**
     * 一键复位模式存储接收事件
     */
    public static class handleOneKeyResetModelSave extends InitSwitchEvent {

    }

    /**
     * 一键复位模式移除接收事件
     */
    public static class handleOneKeyResetModelDelete extends InitSwitchEvent {

    }

}
