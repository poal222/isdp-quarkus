package org.isdp.orm.panache.criteria;

import org.isdp.orm.panache.builder.Condition;
import org.isdp.orm.panache.builder.Op;

public class UpdateCriteriaBuilder  implements CriteriaBuilder{
    private StringBuilder FROM = new StringBuilder();
    private StringBuilder WHERE = new StringBuilder(" WHERE ");

    private StringBuilder AND = new StringBuilder();
    private StringBuilder OR = new StringBuilder();

    private static StringBuilder PARAMS = new StringBuilder();

    private static StringBuilder VALUES = new StringBuilder();

    private StringBuilder SQL = new StringBuilder("UPDATE ");
    // ORDER BY

    public void and(String columnname, Op eq, Object value) {
        AND.append(" AND ").append(columnname).append(" ").append(eq.sql()).append(" ").append(getRealValue(value));
    }

    public void or(String columnname, Op eq, Object value) {
        OR.append(" OR ").append(columnname).append(" ").append(eq.sql()).append(" ").append(getRealValue(value));
    }


    public void from(String tableNamse) {
        FROM.append(" SET ").append(tableNamse);
    }


    public String toSql() {
        if (FROM.length() != 0) {
            SQL.append(" ").append(FROM).append(" ");
        } else {
            throw new UnsupportedOperationException("SELECT is not null ,please check it!");
        }
        if(PARAMS.length() !=0){
            SQL.append(" ").append(PARAMS).append(" ");
        }

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

    public void set(Condition[] conditions) {

        for (int i = 0; i < conditions.length; i++) {
            if (i == conditions.length - 1){
                PARAMS.append(conditions[i].getParam()).append("=").append(conditions[i].getIndex()+"#?");
                VALUES.append(conditions[i].getIndex()+"#?");
            }
                
            if (i != conditions.length - 1){
                PARAMS.append(conditions[i].getParam()).append("=").append(conditions[i].getIndex()+"#?").append(",");
                VALUES.append(conditions[i].getIndex()+"#?").append(",");
            }
               
        }
    }
}
