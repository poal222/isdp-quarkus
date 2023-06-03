package org.isdp.orm.panache.criteria;

import org.isdp.orm.panache.builder.Condition;
import org.isdp.orm.panache.builder.Op;
import org.isdp.orm.support.Dialect;

public class UpdateCriteria implements Criteria{
    
    private Dialect dialect;

    private UpdateCriteriaBuilder criteriaBuilder;

    public UpdateCriteria(Dialect dialect) {
        this.dialect = dialect;
        criteriaBuilder = new UpdateCriteriaBuilder();
    }
      /**
     * 更改的列
     * @param co 别名
     * @return
     */
    public UpdateCriteria set(Condition... conditions){
        criteriaBuilder.set(conditions);
        return this;
    };

    /**
     * From 
     * @param tablename 表名
     * @return
     */
    public UpdateCriteria from(String tablename){
        getCriteriaBuilder().from(tablename);
        return this;
    };
    /**
     * 默认是 eq
     * @param columnname
     * @param value
     * @return
     */
    public UpdateCriteria where(String columnname,String value){
        getCriteriaBuilder().where(columnname,Op.EQ,value);
        return this;
    };
    /**
     * 默认是 eq
     * @param columnname
     * @param value
     * @return
     */
    public UpdateCriteria where(String columnname,Op op,Object value){
        getCriteriaBuilder().where(columnname,op,value);
        return this;
    };
    public UpdateCriteria or(String columnname,Op op,Object value) {
        getCriteriaBuilder().or(columnname,op,value);
        return this;
    }
    public UpdateCriteria and(String columnname,Op op,Object value) {
        getCriteriaBuilder().and(columnname,op,value);
        return this;
    }




    @Override
    public UpdateCriteriaBuilder getCriteriaBuilder() {
        if(criteriaBuilder == null){
            return new UpdateCriteriaBuilder();
        }
        return criteriaBuilder;
    }
    //todo 增加结果集影射操作
    @Override
    public ResultMapBuilder getResultMapBuilder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResultMapBuilder'");
    }


}
