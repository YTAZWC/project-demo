package top.ytazwc;

import cn.hutool.core.util.IdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.ytazwc.entity.Orders;
import top.ytazwc.mapper.OrdersMapper;

import java.util.Date;

@SpringBootTest
class ProjectDemoApplicationTests {

    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testSharding() {
        for (int i = 0; i < 20; i++) {
            Orders orders = new Orders();
            orders.setOrderId(IdUtil.getSnowflakeNextId());
            orders.setCustomerId(i);
            orders.setStatus(1);
            orders.setCreateDate(new Date());
            orders.setAmount(1000.0 * i);
            ordersMapper.insert(orders);
        }
    }

}
