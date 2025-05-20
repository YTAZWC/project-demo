package top.ytazwc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 00103943
 * @date 2025-04-09 17:07
 * @package top.ytazwc.entity
 * @description
 */
@Data
@Builder
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // 配置插入数据时 mybatis-plus 自动将主键填充到实例中
    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private String userId;

    private String username;

    private String password;

    private String status;

    private int age;

    private String sex;

}
