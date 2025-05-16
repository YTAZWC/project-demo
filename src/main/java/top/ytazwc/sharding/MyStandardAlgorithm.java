package top.ytazwc.sharding;

import com.google.common.collect.Range;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.apache.shardingsphere.sharding.exception.syntax.UnsupportedShardingOperationException;

import java.util.*;

/**
 * @author 花木凋零成兰
 * @title MyStandardAlgorithm
 * @date 2025-05-16 20:50
 * @package top.ytazwc.sharding
 * @description
 */
public class MyStandardAlgorithm implements StandardShardingAlgorithm<Long> {

    private Properties properties;

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        Long value = preciseShardingValue.getValue();
        String tableName = preciseShardingValue.getLogicTableName();
        String actualName = tableName + "_" + (value % 2 + 1);
        if (collection.contains(actualName)) {
            return actualName;
        }
        return "";
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        Range<Long> valueRange = rangeShardingValue.getValueRange();
        // 范围查询 下限
        Long lowerEndpoint = valueRange.lowerEndpoint();
        // 范围查询 上限
        Long upperEndpoint = valueRange.upperEndpoint();
        // 表名
        String tableName = rangeShardingValue.getLogicTableName();
        // 记录真实表名
        Set<String> tables = new HashSet<>();

        if (upperEndpoint < lowerEndpoint) {
            // 下限 >= 上限 不查数据库
            throw new UnsupportedShardingOperationException("empty record query", tableName);
        } else if (upperEndpoint < 0) {
            // 错误值
            throw new UnsupportedShardingOperationException("error range query param", tableName);
        } else {
            for (long i = lowerEndpoint; i <= upperEndpoint; ++ i) {
                String actualName = tableName + "_" + (lowerEndpoint % 2 + 1);
                if (collection.contains(actualName)) {
                    tables.add(actualName);
                }
            }
        }

        return tables;
    }

    @Override
    public Properties getProps() {
        return this.properties;
    }

    @Override
    public void init(Properties properties) {
        this.properties = properties;
    }

}
