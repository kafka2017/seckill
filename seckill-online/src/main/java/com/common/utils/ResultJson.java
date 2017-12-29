package com.common.utils;

import java.io.Serializable;
import com.common.enumUtil.CodeEnum;

/**
 * @description: 统一返回json工具类
 * @author: 番茄很忙
 * @date:2017/11/6 13:37
 */
public class ResultJson<T> implements Serializable {

	private static final long serialVersionUID = -5460134129938461241L;

	private static final String STATUS_SUCCESS="ok";
	
	private static final String STATUS_ERROR="error";
	
	
	/**
	 * 状态码
	 */
	private Integer code;
	/**
	 * 状态字符串
	 */
	private String status;

	/**
	 * 对象
	 */
	private T obj;

	/**
	 * 信息描述
	 */
	private String error;
	
	private String msg;

	/**
	 * 
	 * @param status
	 * @param obj
	 * @param msg
	 */
	private ResultJson(Integer code, String status, String msg, T obj) {
		this.status = status;
		this.code = code;		
		this.msg = msg;
		this.error = msg;
		this.obj = obj;
		
	}

	public static <T> ResultJson<T> success() {
		return new ResultJson<T>(CodeEnum.success.code(), STATUS_SUCCESS, CodeEnum.success.msg(), null);
	}
	
	public static <T> ResultJson<T> success(Integer code, String msg) {
		return new ResultJson<T>(code, STATUS_SUCCESS, msg, null);
	}
	
	public static <T> ResultJson<T> success(Integer code, String msg, T obj) {
		return new ResultJson<T>(code, STATUS_SUCCESS, msg, obj);
	}
	
	public static <T> ResultJson<T> success(T obj) {
		return new ResultJson<T>(CodeEnum.success.code(), STATUS_SUCCESS, CodeEnum.success.msg(), obj);
	}
	

	public static <T> ResultJson<T> failed() {
		return new ResultJson<T>(CodeEnum.error.code(),STATUS_ERROR, CodeEnum.error.msg(), null);
	}
	
	public static <T> ResultJson<T> failed(Integer code, String msg) {
		return new ResultJson<T>(code, STATUS_ERROR, msg, null);
	}
	
	public static <T> ResultJson<T> failed(Integer code, String msg, T obj) {
		return new ResultJson<T>(code, STATUS_ERROR, msg, obj);
	}

	public String getStatus() {
		return status;
	}

	public T getObj() {
		return obj;
	}

	public String getMsg() {
		return msg;
	}
	
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public boolean isSuccess() {
		return STATUS_SUCCESS.equals(this.getStatus());
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
}
