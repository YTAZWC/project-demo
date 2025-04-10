package top.ytazwc.entity;

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

    private Long id;
    private String name;
    private String password;
    private String email;
    private String phone;

}
