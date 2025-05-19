package top.ytazwc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.ytazwc.entity.Course;

import java.util.List;

/**
 * @author 花木凋零成兰
 * @title CourseMapper
 * @date 2025-05-07 22:17
 * @package top.ytazwc.mapper
 * @description
 */
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 用于测试在当前分片策略的情况下 不支持的SQL查询语句
     * @return 查询结果
     */
    @Select("select * from course where MOD(cid, 2) = 1")
    List<Course> unSupportSql();

}
