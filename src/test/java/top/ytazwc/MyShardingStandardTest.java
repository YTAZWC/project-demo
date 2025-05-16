package top.ytazwc;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.ytazwc.entity.Course;
import top.ytazwc.mapper.CourseMapper;

import java.util.List;

/**
 * @author 花木凋零成兰
 * @title MyShardingStandardTest
 * @date 2025-05-16 21:09
 * @package top.ytazwc
 * @description 测试自定义的分片算法
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyShardingStandardTest {

    @Autowired
    private CourseMapper mapper;

    /**
     * standard 简单分片：
     * cid 分片键
     * 执行插入
     */
    @Test
    public void insertTest() {
        for (int i = 0; i < 10; i++) {
            Course c = new Course();
            c.setCname("Java");
            c.setCstatus("1");
            c.setUserId(1005L);
            mapper.insert(c);
        }
    }

    /**
     * 自定义简单分片
     * 测试精确查询
     */
    @Test
    public void queryValueTest() {
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Course::getCid, 1127341091482238976L, 1127341091926835200L);
        List<Course> courses = mapper.selectList(wrapper);
        courses.forEach(System.out::println);
    }

    /**
     * 范围查询测试
     */
    @Test
    public void queryRangeTest() {
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        wrapper.between(Course::getCid, 1127341091482238976L, 1127341091926835200L);
        List<Course> courses = mapper.selectList(wrapper);
        courses.forEach(System.out::println);
    }

}
