package top.ytazwc.sharding;

import org.apache.shardingsphere.shadow.api.shadow.hint.HintShadowAlgorithm;
import org.apache.shardingsphere.shadow.api.shadow.hint.PreciseHintShadowValue;

import java.util.Collection;
import java.util.Properties;

/**
 * @author 花木凋零成兰
 * @title MyHintAlgorithm
 * @date 2025-05-19 20:39
 * @package top.ytazwc.sharding
 * @description
 */
public class MyHintAlgorithm implements HintShadowAlgorithm<Long> {

    @Override
    public boolean isShadow(Collection<String> collection, PreciseHintShadowValue<Long> preciseHintShadowValue) {
        return false;
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void init(Properties properties) {

    }
}
