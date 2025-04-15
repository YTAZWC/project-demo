package top.ytazwc.utils;

import cn.hutool.core.lang.Snowflake;

/**
 * @author 花木凋零成兰
 * @title SnowFlakeUtil
 * @date 2025-04-15 22:07
 * @package top.ytazwc.utils
 * @description 雪花算法工具类
 */
public class SnowFlakeUtil {

    private static final Snowflake SNOWFLAKE = new Snowflake(0, 0);

    public static Long getDefaultShowFlakeId() {
        return SNOWFLAKE.nextId();
    }

}