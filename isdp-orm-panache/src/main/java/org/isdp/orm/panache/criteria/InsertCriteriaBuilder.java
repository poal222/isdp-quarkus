package org.isdp.orm.panache.criteria;

import org.isdp.orm.panache.builder.Condition;

/**
 * Insert 组装器
 * 例如：insert into lecture(user_id,title,orderby) select '1','kjfajf' ,(select max(orderby) from lecture)+1;
 */
public class InsertCriteriaBuilder implements CriteriaBuilder{
    private static StringBuilder INSERT = new StringBuilder("INSERT INTO");
    //插入的表数据
    private static StringBuilder FROM = new StringBuilder();

    private static StringBuilder PARAMS = new StringBuilder();

    private static StringBuilder VALUES = new StringBuilder();

    private static StringBuilder SQL = new StringBuilder();

    @Override
    public String toSql() {
        if(FROM.length() !=0){
            SQL.append(INSERT).append(" ").append(FROM);
        }
        if(PARAMS.length() !=0){
            SQL.append("(").append(PARAMS).append(")");
        }
        
        if(VALUES.length() !=0){
            SQL.append(" VALUES(").append(VALUES).append(")");
        }
        
        return SQL.toString();
    }

    // CriteriaBuilder // 返回Criteria, 查出对象形式记录
    // CriteriaBuilder.ResultMapBuilder //返回ResultMapCriteria, 查出Map形式记录，支持连表查询
  

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

    public void insertTable(String tableName) {
        FROM.append(tableName);
    }

    public void insertColumn(Condition... conditions) {
        for (int i = 0; i < conditions.length; i++) {
            if (i == conditions.length - 1){
                PARAMS.append(conditions[i].getParam());
                VALUES.append(conditions[i].getIndex()+"#?");
            }
                
            if (i != conditions.length - 1){
                PARAMS.append(conditions[i].getParam()).append(",");
                VALUES.append(conditions[i].getIndex()+"#?").append(",");
            }
               
        }
    }



}
