package com.token.jwt.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * API 统一返回状态码
 */
public enum ResultCode implements Serializable {

    /**
     * 成功状态码
     */
    SUCCESS(0, "成功"),


    /**
     * 参数错误：10001-19999
     */
    PARAM_IS_BLANK(10001, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10002, "参数类型错误"),
    PARAM_NOT_COMPLETE(10003, "参数缺失"),
    PARAM_IS_INVALID(10004, "参数无效"),

    /**
     * 系统用户错误：20001-29999
     */
    SYS_USER_NOT_LOGGED_IN(20001, "用户未登录"),
    SYS_USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
    SYS_USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    SYS_USER_NOT_EXIST(20004, "用户不存在"),
    SYS_USER_HAS_EXISTED(20005, "用户已存在"),
    ORIGIN_PWD_ERROR(20006, "原始密码错误"),


    /**
     * 业务错误：30001-39999
     */
    SDK_NO_FEATURE_DATA(30001, "未获取到特征值"),
    SDK_NO_FEATURE_DATA1(30002, "未获取到图片1的特征值"),
    SDK_NO_FEATURE_DATA2(30003, "未获取到图片2的特征值"),
    SDK_ERROR_IMAGE(30004, "图片解析错误"),
    SDK_ERROR_IMAGE1(30005, "图片1解析错误"),
    SDK_ERROR_IMAGE2(30006, "图片2解析错误"),
    SDK_NOT_FOUND_FEATURE(30007, "未找到该特征值"),
    SDK_COMPARE_ERROR(30008, "比较失败"),
    SDK_NOT_FOUND_1VN_RESULT(30009, "未找到1vn结果"),
    SDK_TOO_LOW_SCORE(30010, "识别得分过低"),

    USER_NOT_FOUND(30011, "未找到该人员"),
    USER_HAS_EXISTED(30012, "人员已存在"),

    DEPARTMENT_HAS_USER(30013, "该部门存在相关人员"),

    MONITORING_POINT_NOT_STOPPED(30014, "监控点未停止"),

    NOTICE_HAS_PUBLISHED(30015, "公告已更新"),


    SDK_SERVER_HAS_MONITORING_POINT(30016, "已绑定监控点"),


    /**
     * 系统错误：40001-49999
     */
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),
    SYSTEM_ERROR(40002, "系统发生错误"),
    METHOD_NOT_ALLOWED(40003, "不支持当前方法"),
    NOT_FOUND(40004, "404"),
    NO_MENUS(40005, "未获取到菜单"),
    NETWORK_UNREACHABLE(40006, "网络发生错误"),
    SYSTEM_BUSY(40007,"业务限流"),


//    ILLEGAL_USER(0, "未刷身份证进入用户"),

    /**
     * 数据错误：50001-599999
     */
    DATA_RESULT_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),
    DATA_UPDATE_ERROR(50004, "数据更新失败"),

    /**
     * 接口错误：60001-69999
     */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

    /**
     * 权限错误：70001-79999
     */
    PERMISSION_NO_ACCESS(70001, "无访问权限"),
    UNAUTHORIZED(70002, "未获得授权，请登录");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

    //校验重复的code值
    public static void main(String[] args) {
        ResultCode[] ApiResultCodes = ResultCode.values();
        List<Integer> codeList = new ArrayList<Integer>();
        for (ResultCode ApiResultCode : ApiResultCodes) {
            if (codeList.contains(ApiResultCode.code)) {
                System.out.println(ApiResultCode.code);
            } else {
                codeList.add(ApiResultCode.code());
            }
        }
    }
}