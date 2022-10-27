package com.lijiawei.education.serviceedu.util;

public class PathUtil {

    public static String getPath() {
        return PathUtil.class.getResource("/").getPath();
    }
}
