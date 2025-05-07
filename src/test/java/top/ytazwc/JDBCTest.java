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
 * @title JDBCTest
 * @date 2025-05-07 22:28
 * @package top.ytazwc
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JDBCTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void addCourse() {
        for (int i = 0; i < 10; i++) {
            Course c = new Course();
            c.setCname("Java");
            c.setCstatus("1");
            c.setUserId(1000L);
            courseMapper.insert(c);
        }
    }

    @Test
    public void queryList() {
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        List<Course> courses = courseMapper.selectList(wrapper);
        courses.forEach(System.out::println);
    }

}
