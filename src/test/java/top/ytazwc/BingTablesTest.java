package top.ytazwc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.ytazwc.entity.User;
import top.ytazwc.entity.UserCourseInfo;
import top.ytazwc.mapper.UserCourseInfoMapper;
import top.ytazwc.mapper.UserMapper;

import java.util.List;

/**
 * @author 花木凋零成兰
 * @title BingTablesTest
 * @date 2025-05-20 21:28
 * @package top.ytazwc
 * @description 测试绑定表关系
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BingTablesTest {

    @Autowired
    private UserCourseInfoMapper mapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void addUserCourseInfo() {
        for (int i = 0; i < 10; i++) {

            User user = User.builder()
                    .username("yt" + i)
                    .password("huamulan")
                    .status("NORMAL")
                    .age(21 + i)
                    .sex(i % 2 == 0 ? "F" : "M")
                    .build();
            userMapper.insert(user);
            for (int j = 0; j < 5; j++) {
                UserCourseInfo info = UserCourseInfo.builder()
                        .userId(user.getUserId())
                        .courseId(10000L + j)
                        .build();
                mapper.insert(info);
            }
        }
    }

    /**
     * 测试绑定表查询
     * 没有启动绑定表配置时 全分片笛卡尔积 查询
     * 启动绑定表配置后 会根据统一分片规则进行查询
     */
    @Test
    public void queryUserCourseInfo() {
        List<UserCourseInfo> infos = mapper.queryUserCourse();
        infos.forEach(System.out::println);
    }

}
