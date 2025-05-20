package top.ytazwc;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.ytazwc.entity.Dict;
import top.ytazwc.mapper.DictMapper;

import java.util.List;

/**
 * @author 花木凋零成兰
 * @title DictTest
 * @date 2025-05-20 19:58
 * @package top.ytazwc
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DictTest {

    @Autowired
    private DictMapper mapper;

    /**
     * 广播表
     * 添加测试
     */
    @Test
    public void addDict() {
        Dict dict = Dict.builder()
                .dictKey("F")
                .dictVal("女")
                .build();
        mapper.insert(dict);

        dict = Dict.builder()
                .dictKey("M")
                .dictVal("男")
                .build();
        mapper.insert(dict);
    }

    /**
     * 广播表
     * 查询测试
     */
    @Test
    public void queryDict() {
        LambdaQueryWrapper<Dict> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dict::getDictKey, "F");
        List<Dict> dictList = mapper.selectList(wrapper);
        dictList.forEach(System.out::println);
    }

}
