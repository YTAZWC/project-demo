package top.ytazwc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author 花木凋零成兰
 * @title Orders
 * @date 2025-04-15 21:48
 * @package top.ytazwc.entity
 * @description
 */
@Data
@ToString
@TableName("t_orders")
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("order_id")
    private Long orderId;

    @TableField("customer_id")
    private Integer customerId;

    @TableField("amount")
    private Double amount;

    @TableField("status")
    private Integer status;

    @TableField("create_date")
    private Date createDate;

}
