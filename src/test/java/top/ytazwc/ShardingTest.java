package top.ytazwc;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.shardingsphere.infra.hint.HintManager;
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
 * @title ShardingTest
 * @date 2025-05-08 21:40
 * @package top.ytazwc
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ShardingTest {

    @Autowired
    private CourseMapper courseMapper;

    // 针对分片键进行精确查询 可以使用表达式控制
    // SELECT cid,cname,user_id,cstatus FROM course WHERE (cid = ?)
    @Test
    public void queryCourse() {
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(Course::getCid, 1127341091696148481L);
        // in 当判断出查询的数据不在同一个分片时，放弃计算分片，进行全分片查询
        wrapper.in(Course::getCid, 1127341091696148481L, 1127340884854046720L, 1127341092283351040L);
        List<Course> courses = courseMapper.selectList(wrapper);
        courses.forEach(System.out::println);
    }

    // 范围查询 测试分片效果
    @Test
    public void queryCourseRange() {
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        wrapper.between(Course::getCid, 1127341091926835200L, 1127341092253990912L);
        // 依旧对全分片进行查询
        List<Course> courses = courseMapper.selectList(wrapper);
        courses.forEach(System.out::println);
    }

    /**
     * 使用 COMPLEX_INLINE 复杂分片策略，使用多个分片键进行组合路由
     * cid、user_id 组合分片
     */
    @Test
    public void queryCourseComplexSimple() {
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Course::getCid, 1127341091561930752L, 1127341092077830144L);
        wrapper.eq(Course::getUserId, 1002L);
        List<Course> courses = courseMapper.selectList(wrapper);
        courses.forEach(System.out::println);
    }

    /**
     * 复杂分片：
     * cid 精确查询、user_id 范围查询
     * 此刻allow-range-query-with-inline-sharding虽然可以解决问题，但是会导致 全分片查询
     * 需要定制复杂逻辑：使用 Class_BASED 自定义分片
     *      1、user_id < 1000L 一定没数据，不查数据库
     *      2、user_id 支持范围查询
     */
    @Test
    public void queryCourseComplexTwo() {
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Course::getCid, 1127341091561930752L, 1127341092077830144L);
        wrapper.between(Course::getUserId, 1000L, 1005L);
//        wrapper.between(Course::getUserId, 1000L, 1003L);
        List<Course> courses = courseMapper.selectList(wrapper);
        courses.forEach(System.out::println);
    }

    /**
     * 查询 cid 为奇数的课程信息
     * 示例中的Course记录是按照cid的奇偶分片的 现在只希望查询cid为奇数的课程信息
     * 直接通过MOD函数计算cid的奇偶， ShardingJDBC 无法识别虚拟列，因此无法进行分片计算，只能全分片路由
     * <br>
     * <p style="color:red">可测试SQL审计功能</p>
     */
    @Test
    public void unSupportTest() {
        // select * from course where mod(cid, 2) = 1
        // 即当分片键上使用函数时 没办法进行识别
        List<Course> res = courseMapper.unSupportSql();
        res.forEach(System.out::println);
    }

    /**
     * 测试强制分片
     */
    @Test
    public void queryCourseByHint() {
        // 强制只查 course_1 表
        HintManager hintManager = HintManager.getInstance();
        // 属性：tableSHardingValue 强制查表
        hintManager.addTableShardingValue("course", 1);
        List<Course> courses = courseMapper.selectList(null);
        courses.forEach(System.out::println);
        // 非线程安全的 用完需要关闭资源
        hintManager.close();
    }





































}
