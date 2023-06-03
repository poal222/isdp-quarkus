package org.isdp.orm.panache.criteria;


import org.isdp.orm.panache.builder.Op;

/**
 * delete 组装器
 */
public class DeleteCriteriaBuilder implements CriteriaBuilder{
    private StringBuilder ALIS = new StringBuilder();
    private StringBuilder FROM = new StringBuilder();
    private StringBuilder WHERE = new StringBuilder(" WHERE ");

    private StringBuilder AND = new StringBuilder();
    private StringBuilder OR = new StringBuilder();


    private StringBuilder SQL = new StringBuilder("DELETE ");
    // ORDER BY

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


    public String toSql() {
      
        if (FROM.length() != 0) {
            SQL.append(" ").append(FROM).append(" ");
        } else {
            throw new UnsupportedOperationException("SELECT is not null ,please check it!");
        }

        SQL.append(" ").append(ALIS).append(" ");

        SQL.append(" ").append(WHERE).append(" ");

        SQL.append(" ").append(AND).append(" ");
        SQL.append(" ").append(OR).append(" ");

       

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
