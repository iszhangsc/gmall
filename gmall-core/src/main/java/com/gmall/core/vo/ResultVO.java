package com.gmall.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *  服务端返回数据结果封装
 * </p>
 *
 * @author zhangshichang
 * @date 2020/2/13 下午5:04
 */
@Data
@ApiModel(description = "服务端返回数据结果封装")
public final class ResultVO<T> {


    @ApiModelProperty(notes = "success", value = "是否成功", example = "true")
    private Boolean success;

    /**
     * 状态码<br/>
     * 200-请求成功<br/>
     * 400-请求失败<br/>
     * 500-服务器内部错误<br/>
     */
    @ApiModelProperty(name = "code", value = "code: 200->请求成功, 400->请求失败:一般为参数格式错误, 500->服务器错误", position = 1, example = "200")
    private Integer code;

    /**
     * 返回成功或者失败的消息
     */
    @ApiModelProperty(name = "msg", value = "提示信息", position = 2, example = "success")
    private String msg;

    /**
     * JSON数据
     */
    @ApiModelProperty(name = "data", value = "具体数据", position = 3)
    private T data;

    /**
     * 有数据构造函数
     *
     * @param code 状态码
     * @param msg  消息
     * @param data JSON数据
     */
    public ResultVO(Boolean success, Integer code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 无数据构造函数
     *
     * @param code 状态码
     * @param msg  消息
     */
    public ResultVO(Boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }


    /**
     * 失败时调用，并返回提示信息
     * @param promptMsg       提示信息
     * @return {@link ResultVO<String>}
     */
    public static ResultVO<String> fail(String promptMsg) {
        return new ResultVO<>(false,400, promptMsg);
    }

    /**
     * 失败时调用，自定义状态码并返回提示信息
     * @param code 状态码
     * @param promptMsg       提示信息
     * @return {@link ResultVO<String>}
     */
    public static ResultVO<String> fail(int code, String promptMsg) {
        return new ResultVO<>(false, code, promptMsg);
    }

    /**
     * 成功时无数据返回调用
     * @return {@link ResultVO}
     */
    public static ResultVO ok() {
        return new ResultVO<>(true, 200, "success");
    }

    /**
     * 成功时有数据返回调用
     * @return {@link ResultVO<T>}
     */
    public static <T> ResultVO<T> ok(T data) {
        return new ResultVO<>(true, 200, "success", data);
    }

}
