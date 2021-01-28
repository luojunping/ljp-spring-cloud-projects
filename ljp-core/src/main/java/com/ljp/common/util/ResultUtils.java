package com.ljp.common.util;

import com.ljp.common.entity.Result;

public final class ResultUtils {

    private ResultUtils() throws IllegalAccessException {
        throw new IllegalAccessException("ResultUtils can not be created...");
    }

    public static Result success() {
        return success("成功！");
    }

    public static Result success(String msg) {
        return success(msg, null);
    }

    public static Result success(Object data) {
        return success("成功！", data);
    }

    public static Result success(String msg, Object data) {
        return new Result(true, msg, data);
    }

    public static Result fail() {
        return fail("失败！");
    }

    public static Result fail(String msg) {
        return fail(msg, null);
    }

    public static Result fail(Object data) {
        return fail("失败！", data);
    }

    public static Result fail(String msg, Object data) {
        return new Result(false, msg, data);
    }

}
