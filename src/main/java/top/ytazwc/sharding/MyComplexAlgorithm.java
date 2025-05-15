package top.ytazwc.sharding;

import com.google.common.collect.Range;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.sharding.exception.syntax.UnsupportedShardingOperationException;

import java.util.*;

/**
 * @author 花木凋零成兰
 * @title MyComplexAlgorithm
 * @date 2025-05-15 21:41
 * @package top.ytazwc.sharding
 * @description 自定义复杂分片逻辑
 */
public class MyComplexAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

    private static final String SHARDING_COLUMNS_KEY = "sharding-columns";

    private Properties props;

    /**
     * 实现自定义分片算法
     * @param collection 在actual-nodes中配置了的所有数据分片
     * @param complexKeys 组合分片键
     * @return 目标分片
     */
    @Override
    public Collection<String> doSharding(Collection<String> collection, ComplexKeysShardingValue<Long> complexKeys) {
        // 获取分片字段值
        Map<String, Collection<Long>> shardingValuesMap = complexKeys.getColumnNameAndShardingValuesMap();
        Collection<Long> cidCol = shardingValuesMap.get("cid");
        // 获取范围分片字段
        Map<String, Range<Long>> rangeValuesMap = complexKeys.getColumnNameAndRangeValuesMap();
        Range<Long> userIdRange = rangeValuesMap.get("user_id");
        // 拿到user_id的查询范围
        Long lowerEndpoint = userIdRange.lowerEndpoint();
        Long upperEndpoint = userIdRange.upperEndpoint();

        if (lowerEndpoint >= upperEndpoint) {
            // 下限 >= 上限 不查数据库
            throw new UnsupportedShardingOperationException("empty record query", "course");
        } else if (upperEndpoint < 1001L || lowerEndpoint > 1001L) {
            // 查询范围 明显不包含1001
            throw new UnsupportedShardingOperationException("error range query param", "course");
        } else {
            List<String> result = new ArrayList<>();
            // user_id 包含1001后 按照cid的奇偶进行分片
            // 获取操作的逻辑表
            String logicTableName = complexKeys.getLogicTableName();
            for (Long cid : cidCol) {
                String targetTable = logicTableName + "_" + (cid % 2 + 1);
                if (collection.contains(targetTable)) {
                    result.add(targetTable);
                }
            }
            return result;
        }
    }

    @Override
    public Properties getProps() {
        return this.props;
    }

    @Override
    public void init(Properties properties) {
        this.props = properties;
    }

}
