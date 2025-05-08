package top.ytazwc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author 花木凋零成兰
 * @title Course
 * @date 2025-05-07 22:12
 * @package top.ytazwc.entity
 * @description
 */
@Data
@TableName("course")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Course {

//    @TableId
    private Long cid;

    private String cname;

    private Long userId;

    private String cstatus;

}
