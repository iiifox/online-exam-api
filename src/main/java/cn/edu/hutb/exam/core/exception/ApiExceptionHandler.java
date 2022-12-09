package cn.edu.hutb.exam.core.exception;

import cn.edu.hutb.exam.core.result.ApiResult;
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
public class ApiExceptionHandler {

    /**
     * 捕获ServiceException
     */
    @ExceptionHandler({ServiceException.class})
    public ApiResult<?> serviceExceptionHandler(ServiceException e) {
        e.printStackTrace();
        log.error("服务器异常 {}", e.getMsg());
        return new ApiResult<>(e);
    }

}