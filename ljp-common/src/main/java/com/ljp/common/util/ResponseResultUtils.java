package com.ljp.common.util;

import com.ljp.common.entity.ResponseResult;

public final class ResponseResultUtils {

	private ResponseResultUtils() throws IllegalAccessException {
		throw new IllegalAccessException("ResponseResultUtils can not be created...");
	}

	public static ResponseResult success() {
		return success("成功！");
	}

	public static ResponseResult success(String msg) {
		return success(msg, null);
	}

	public static ResponseResult success(Object data) {
		return success("成功！", data);
	}

	public static ResponseResult success(String msg, Object data) {
		return new ResponseResult(true, msg, data);
	}

	public static ResponseResult fail() {
		return fail("失败！");
	}

	public static ResponseResult fail(String msg) {
		return fail(msg, null);
	}

	public static ResponseResult fail(Object data) {
		return fail("失败！", data);
	}

	public static ResponseResult fail(String msg, Object data) {
		return new ResponseResult(false, msg, data);
	}

}
