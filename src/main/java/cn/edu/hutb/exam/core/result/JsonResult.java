package cn.edu.hutb.exam.core.result;

import cn.edu.hutb.exam.core.exception.BizException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 田章
 * @description 响应数据统一封装结果类
 * @datetime 2022/12/9 23:39
 */
@Data
@AllArgsConstructor
@Schema(name = "接口响应", description = "接口响应")
public class JsonResult<T> {

    /**
     * 响应代码
     */
    @Schema(name = "响应代码,0为成功,非0为失败", required = true)
    private Integer code;

    /**
     * 响应消息
     */
    @Schema(name = "响应消息")
    private String msg;

    /**
     * 请求或响应body
     */
    @Schema(name = "响应内容")
    private T data;

    /**
     * 是否成功
     */
    public boolean isSuccess() {
        return code.equals(0);
    }

    /**
     * 通过错误码枚举类构造
     */
    public static JsonResult<?> bizErrorEnum(BizErrorEnum error) {
        return JsonResult.failure(error.getCode(), error.msg);
    }

    /**
     * 通过业务异常类构造
     */
    public static JsonResult bizException(BizException error) {
        return JsonResult.failure(error.getCode(), error.getMsg());
    }

    private static JsonResult<?> failure(Integer code, String msg) {
        return new JsonResult<>(code, msg, null);
    }

    /**
     * 响应失败，返回默认响应消息
     */
    public static JsonResult<?> failure() {
        return JsonResult.failure("请求失败！");
    }

    /**
     * 响应失败，返回自定义的响应消息
     */
    public static JsonResult<?> failure(String msg) {
        return JsonResult.failure(1, msg);
    }

    /**
     * 响应成功，返回默认响应信息，不携带响应数据
     */
    public static JsonResult<?> success() {
        return JsonResult.success("操作成功！", null);
    }

    /**
     * 响应成功，自定义响应信息和响应数据
     */
    public static <T> JsonResult<T> success(String msg, T data) {
        return new JsonResult<>(0, msg, data);
    }

}