package cn.edu.hutb.exam.core.exception;

import cn.edu.hutb.exam.core.result.ApiError;
import cn.edu.hutb.exam.core.result.ApiResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 田章
 * @description 异常类：服务器错误
 * @datetime 2022/12/9 23:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -7034897190745766939L;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 从结果初始化
     */
    public ServiceException(ApiResult<?> apiResult) {
        this.code = apiResult.getCode();
        this.msg = apiResult.getMsg();
    }

    /**
     * 从枚举中获取参数
     */
    public ServiceException(ApiError apiError) {
        this.code = apiError.getCode();
        this.msg = apiError.msg;
    }

    /**
     * 异常构造
     */
    public ServiceException(String msg) {
        this.code = 1;
        this.msg = msg;
    }

}

