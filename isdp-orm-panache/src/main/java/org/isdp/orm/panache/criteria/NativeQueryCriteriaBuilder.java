package org.isdp.orm.panache.criteria;

public class NativeQueryCriteriaBuilder implements CriteriaBuilder{

    private static StringBuilder SQL = new StringBuilder();

    @Override
    public String toSql() {
        return SQL.toString();
    }

    public void querySql(String sql) {
        SQL.append(sql);
    }

}
