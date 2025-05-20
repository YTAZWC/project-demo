package top.ytazwc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author 花木凋零成兰
 * @title UserCourseInfo
 * @date 2025-05-20 21:15
 * @package top.ytazwc.entity
 * @description
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_course_info")
public class UserCourseInfo {

    private Long infoId;

    private String userId;

    private Long courseId;

}
