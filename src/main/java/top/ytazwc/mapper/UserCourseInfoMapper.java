package top.ytazwc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.ytazwc.entity.UserCourseInfo;

import java.util.List;

/**
 * @author 花木凋零成兰
 * @title UserCourseInfoMapper
 * @date 2025-05-20 21:17
 * @package top.ytazwc.mapper
 * @description
 */
public interface UserCourseInfoMapper extends BaseMapper<UserCourseInfo> {

    @Select("select uci.* from user_course_info uci, user u where uci.user_id = u.user_id")
    List<UserCourseInfo> queryUserCourse();

}
