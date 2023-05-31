package org.isdp.orm.panache.builder;
/**
 * 条件枚举
 */
public enum  Op {
    EQ ("="),
    NE( "<>"),
    GT(">"),
    LT ("<"),
    GTE (">="),
    LTE ("<="),
    LIKE("LIKE"),
    NOT_LIKE("NOT LIKE"),
    IN("IN"),
    NOT_IN("NOT IN"),
    IS_NOT_NULL("IS NOT NULL"),
    IS_NULL("IS NULL"),
    X(""),
    LIMIT("LIMIT"),
    OFFSET("OFFSET"),
    SUB("SUB"),

    NONE(""),
    AND(" AND "),
    OR(" OR "),
    ORDER_BY(" ORDER BY "),
    GROUP_BY(" GROUP BY "),
    HAVING(" HAVING "),
    WHERE(" WHERE "),
    X_AGGR("");

    private String op;
    Op(String str){
        op = str;
    }
    public String sql(){
        return op;
    }

    public static Op valueOfSql(String str) {
        String t = str.trim();
        for (Op op : values()) {
            if (op.sql().equals(t))
                return op;
        }
        return NONE;
    }
}