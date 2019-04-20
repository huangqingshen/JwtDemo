package com.token.jwt.util;

/**
 * @author haort
 * @date 2018/3/15
 */
public interface Constants {
    Long DEFAULT_DEPARTMENT_ID = 1L;
    String DEFAULT_DEPARTMENT_NAME = "默认部门";
    String ROLE_ADMIN = "ADMIN";
    String ROUTING_KEY = "capture-info-queue";
    String QUEUE_NAME = "capture-info-queue";
    String CACHE_USER_ID = "USER";
    String DEFAULT_ADMIN_NAME = "admin";
    String CACHE_CAMERAS = "CAMERAS";
    String CACHE_USER_LIST_ID = "userList";
    String CACHE_USERS_KEY = "UsersKey";
    String CACHE_USER_PRE = "USERS:";

    String CARD_INFO_ID = "id";
    String CARD_INFO_NAME = "name";
    String CARD_INFO_PHOTO = "photo";
    String CARD_INFO_ACCESS_DATE = "accessDate";
    String CARD_INFO_USER_TYPE = "userType";

    String SIMILARITY_KEY = "SIMILARITY";

    Integer MESSAGE_BATCH_ADD_MESSAGE = 1;
    String LOCK_COMMAND_TYPE_ON1 = "on1";
    String LOCK_COMMAND_TYPE_ON2 = "on2";
    String LOCK_COMMAND_TYPE_OFF1 = "off1";
    String LOCK_COMMAND_TYPE_OFF2 = "off2";
    Integer Lock_STATE_OPEN = 1;
    Integer Lock_STATE_CLOSE = 0;
    String DEFAULT_SUPER_ADMIN_NAME = "ylkc!1@2";
    String DEFAULT_ADMIN_PWD = "123456";

    Integer NOTICE_STATE_PUBLISHED = 1;
    Integer NOTICE_STATE_UNPUBLISHED = 0;
    Integer MONITORING_POINT_STATE_STOPPED = 0;
    Integer MONITORING_POINT_STATE_STARTED = 1;
    String CACHE_MONITORING_POINTS = "MONITORING_POINTS";
    Integer SDK_SERVER_SLAVER = 0;
    Integer SDK_SERVER_MASTER = 1;
    String SDK_SERVER_LIST = "SDK_SERVER_LIST";

    String CACHE_GATE_KEY = "gates";
    String GATE_CONFIG_KEY = "config";
    String GATE_STATUS_KEY = "status";
    String SIMILARITY_KEY_1V1 = "similarity_key_1v1";
    String CACHE_GATE_LIST_KEY = "GateList";

    String SYS_CONFIG_KEY = "sys_config";

    /**
     * 活检配置
     */
    String LIVING_ON = "living_on";
    String LIVING_MIN_FACE_SCORE = "living_min_face_score";
    String LIVING_MIN_LIVING_SCORE = "living_min_living_score";


    /**
     * 考勤配置
     */
    String ATTEND_AM_START_TIME = "attend_am_start_time";

    String ATTEND_AM_END_TIME = "attend_am_end_time";


    String ATTEND_PM_START_TIME = "attend_pm_start_time";

    String ATTEND_PM_END_TIME = "attend_pm_end_time";


    int ATTENDANCE_TYPE_IN = 1;
    int ATTENDANCE_TYPE_OUT = 2;
    String ATTEND_RULE_CHECK_IN = "attend_rule_check_in";
    String ATTEND_RULE_CHECK_OUT = "attend_rule_check_out";
    String ATTEND_ATTENDANCE_ID = "attend_attendance_id";
    String ATTEND_SIGN_ADDRESS = "attend_sign_address";
    String CACHE_ATTEND_CONFIG = "attend_config";
}
