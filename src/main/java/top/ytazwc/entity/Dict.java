package top.ytazwc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author 花木凋零成兰
 * @title Dict
 * @date 2025-05-20 19:49
 * @package top.ytazwc.entity
 * @description
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("dict")
public class Dict {

    private Long dictId;

    private String dictKey;

    private String dictVal;

}
