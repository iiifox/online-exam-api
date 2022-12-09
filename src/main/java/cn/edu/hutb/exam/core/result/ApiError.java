package cn.edu.hutb.exam.core.result;

/**
 * @author 田章
 * @description 全局错误码：用于定义接口的响应数据，枚举类免去取名难的问题。
 * @datetime 2022/12/9 23:26
 */
public enum ApiError {

    //************ 通用错误，接口参数不全 ************//
    ERROR_10010001("参数不全或类型错误！"),
    ERROR_10010002("您还未登录，请先登录！"),
    ERROR_10010003("数据不存在！"),

    //************ 考试相关错误 ************//
    ERROR_20010001("试题被删除，无法继续考试！"),
    ERROR_20010002("您有正在进行的考试！"),

    //************ 系统账号错误 ************//
    ERROR_90010001("账号不存在，请确认！"),
    ERROR_90010002("账号或密码错误！"),
    ERROR_90010003("至少要包含一个角色！"),
    ERROR_90010005("账号被冻结，请联系管理员！");

    public String msg;

    ApiError(String msg) {
        this.msg = msg;
    }

    /**
     * 获取错误码
     */
    public Integer getCode(){
        return Integer.parseInt(this.name().replace("ERROR_", ""));
    }

}
