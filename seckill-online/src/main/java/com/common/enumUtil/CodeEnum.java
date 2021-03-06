package com.common.enumUtil;

/**
 * @description:
 * @author:番茄很忙
 * @date:2017/11/6 13:36
 */
public enum CodeEnum {
	
	success(0,"操作成功"),
	error(1,"操作失败"),
	
	illegal_para(1000, "非法参数"),
	not_exist(1001, "数据不存在"),
	often(1002,"请求过于频繁，请稍候重试"),
	black_user(1003,"黑名单用户,拒绝请求"),
	snatched_out(1004,"已抢完"),
	login_timeout(-100,"登录超时");
	
	
	private int code;
	private String msg;

	private CodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int code() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String msg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
