package cn.edu.hutb.exam.core.result;

import cn.edu.hutb.exam.core.exception.ServiceException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 田章
 * @description 响应数据统一封装结果类
 * @datetime 2022/12/9 23:39
 */
@Data
@NoArgsConstructor
@Schema(name="接口响应", description="接口响应")
public class ApiResult<T>{

    /**
     * 响应消息
     */
    @Schema(name = "响应消息")
    private String msg;

    /**
     * 响应代码
     */
    @Schema(name = "响应代码,0为成功,非0为失败", required = true)
    private Integer code;

    /**
     * 请求或响应body
     */
    @Schema(name = "响应内容")
    private T data;

    /**
     * 是否成功
     */
    public boolean isSuccess(){
        return code.equals(0);
    }

    /**
     * 通过错误码枚举类构造
     */
    public ApiResult(ApiError error){
        this.code = error.getCode();
        this.msg = error.msg;
    }

    /**
     * 通过服务器异常类构造
     */
    public ApiResult(ServiceException error){
        this.code = error.getCode();
        this.msg = error.getMsg();
    }

}