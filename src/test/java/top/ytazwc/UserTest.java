package top.ytazwc;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.ytazwc.entity.User;
import top.ytazwc.mapper.UserMapper;

import java.util.List;

/**
 * @author 花木凋零成兰
 * @title UserTest
 * @date 2025-05-19 21:47
 * @package top.ytazwc
 * @description user 表相关测试
 * 测试ShardingJDBC数据加密
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    UserMapper mapper;

    /**
     * 测试新增 数据加密
     */
    @Test
    public void addUser() {
        for (int i = 0; i < 10; i++) {
            User user = User.builder()
                    .username("huamulan" + i)
                    .password("yang")
                    .status("NORMAL")
                    .age(21 + i)
                    .sex(i % 2 == 0 ? "F" : "M")
                    .build();
            mapper.insert(user);
        }
    }

    /**
     * 查询用户测试：
     * 对password，会转化为按照加密后的password_cipher字段进行查询
     */
    @Test
    public void queryUser() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getPassword, "yang");
        List<User> users = mapper.selectList(wrapper);
        users.forEach(System.out::println);
    }


}
