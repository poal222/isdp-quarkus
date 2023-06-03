package org.isdp.orm.panache.criteria;

public class NativeUpdateCriteriaBuilder implements CriteriaBuilder{

    private static StringBuilder SQL = new StringBuilder();

    @Override
    public String toSql() {
        return SQL.toString();
    }

    public void updateSql(String sql) {
        SQL.append(sql);
    }

}
