package cn.edu.hutb.exam.core.exception;

import cn.edu.hutb.exam.core.result.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 田章
 * @description 统一异常处理类
 * @datetime 2022/12/10 0:01
 */
@Slf4j
@RestControllerAdvice
public class CustomerExceptionHandler {

    /**
     * 捕获ServiceException
     */
    @ExceptionHandler({BizException.class})
    public JsonResult<?> serviceExceptionHandler(BizException e) {
        e.printStackTrace();
        log.error("服务器异常 {}", e.getMsg());
        return new JsonResult<>(e);
    }

}