package org.isdp.orm.panache.criteria;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.isdp.orm.panache.builder.Op;
import org.isdp.orm.util.SqlHelper;

/**
 * 动态sql组装类
 */
public class QueryCriteriaBuilder implements CriteriaBuilder{
    private static StringBuilder SELECT = new StringBuilder();
    private static StringBuilder ALIS = new StringBuilder();
    private static StringBuilder FROM = new StringBuilder();
    private static StringBuilder WHERE = new StringBuilder(" WHERE ");

    private static StringBuilder AND = new StringBuilder();
    private static StringBuilder OR = new StringBuilder();
    private static StringBuilder ORDERBY = new StringBuilder();

    private static StringBuilder GROUPBY = new StringBuilder(" GROUP BY ");
    private static StringBuilder HAVING = new StringBuilder(" HAVING ");

    private static StringBuilder LIMIT = new StringBuilder();

    private static StringBuilder SQL = new StringBuilder();
    // ORDER BY

    public QueryCriteriaBuilder select(String... columns) {
        return select(Arrays.stream(columns).collect(Collectors.toList()));
    }

    private QueryCriteriaBuilder select(List<String> cloumns) {
        SELECT.append(SqlHelper.selectColumns(cloumns));
        return this;
    }

    public void and(String columnname, Op eq, Object value) {
        AND.append(" AND ").append(columnname).append(" ").append(eq.sql()).append(" ").append(getRealValue(value))
                ;
    }

    public void or(String columnname, Op eq, Object value) {
        OR.append(" OR ").append(columnname).append(" ").append(eq.sql()).append(" ").append(getRealValue(value))
                ;
    }

    public void alis(String alis) {
        ALIS.append(alis);
    }

    public void from(String tableNamse) {
        FROM.append(" FROM ").append(tableNamse);
    }

    public void limit(String limited) {
        LIMIT.append(limited);
    };
    @Override
    public String toSql() {
        // 带别名
        if (SELECT.length() != 0) {
            SQL.append(SELECT);
        } else {
            throw new UnsupportedOperationException("SELECT is not null ,please check it!");
        }
        if (FROM.length() != 0) {
            SQL.append(" ").append(FROM).append(" ");
        } else {
            throw new UnsupportedOperationException("SELECT is not null ,please check it!");
        }

        SQL.append(" ").append(ALIS).append(" ");

        SQL.append(" ").append(WHERE).append(" ");

        SQL.append(" ").append(AND).append(" ");
        SQL.append(" ").append(OR).append(" ");

        SQL.append(" ").append(GROUPBY).append(" ");

        SQL.append(" ").append(HAVING).append(" ");

        if (ORDERBY.length() != 0) {
            SQL.append(" ").append(ORDERBY);
        } else {
            throw new UnsupportedOperationException("SELECT is not null ,please check it!");
        }
        if (LIMIT.length() != 0) {
            SQL.append(LIMIT);
        } else {
            throw new UnsupportedOperationException("SELECT is not null ,please check it!");
        }

        return SQL.toString();
    }

    // CriteriaBuilder // 返回Criteria, 查出对象形式记录
    // CriteriaBuilder.ResultMapBuilder //返回ResultMapCriteria, 查出Map形式记录，支持连表查询
    /**
     * where 条件
     */
    public void where(String columnname, Op eq, Object value) {
        WHERE.append(columnname).append(" ").append(eq.sql()).append(" ").append(getRealValue(value));
    }

    public void orderBy(String order) {
        ORDERBY.append(order);
    }

    public void groupBy(String... cols) {
        for (int i = 0; i < cols.length; i++) {
            if (i == cols.length - 1){
                GROUPBY.append(cols[i]);
            }
                
            if (i != cols.length - 1){
                GROUPBY.append(cols[i] + ",");
            }
               
        }

    }

    public void having(String condtions) {
        HAVING.append(condtions);
    }

    /**
     * 参数值映射对应
     */
    private Object getRealValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof Integer) {
            return value;
        }
        return value;
    }


}
