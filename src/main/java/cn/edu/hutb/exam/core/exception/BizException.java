package cn.edu.hutb.exam.core.exception;

import cn.edu.hutb.exam.core.result.BizErrorEnum;
import cn.edu.hutb.exam.core.result.JsonResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 田章
 * @description 业务异常（bizException/businessException）：
 * @datetime 2022/12/9 23:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BizException extends RuntimeException {

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
    public BizException(JsonResult<?> jsonResult) {
        this.code = jsonResult.getCode();
        this.msg = jsonResult.getMsg();
    }

    /**
     * 从枚举中获取参数
     */
    public BizException(BizErrorEnum bizErrorEnum) {
        this.code = bizErrorEnum.getCode();
        this.msg = bizErrorEnum.getMsg();
    }

    /**
     * 异常构造
     */
    public BizException(String msg) {
        this.code = 1;
        this.msg = msg;
    }

}

