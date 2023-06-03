package org.isdp.orm.panache.criteria;

import org.isdp.orm.panache.builder.Op;
import org.isdp.orm.support.Dialect;

public class DeleteCriteria implements Criteria{


    private Dialect dialect;

    private DeleteCriteriaBuilder criteriaBuilder;

    public DeleteCriteria(Dialect dialect) {
        this.dialect = dialect;
        criteriaBuilder = new DeleteCriteriaBuilder();
    }
  /**
     * 设置别名
     * @param alis 别名
     * @return
     */
    public DeleteCriteria alis(String alis){
        getCriteriaBuilder().alis(alis);
        return this;
    };
    /**
     * From 
     * @param tablename 表名
     * @return
     */
    public DeleteCriteria from(String tablename){
        getCriteriaBuilder().from(tablename);
        return this;
    };
    /**
     * 默认是 eq
     * @param columnname
     * @param value
     * @return
     */
    public DeleteCriteria where(String columnname,String value){
        getCriteriaBuilder().where(columnname,Op.EQ,value);
        return this;
    };
    /**
     * 默认是 eq
     * @param columnname
     * @param value
     * @return
     */
    public DeleteCriteria where(String columnname,Op op,Object value){
        getCriteriaBuilder().where(columnname,op,value);
        return this;
    };
    public DeleteCriteria or(String columnname,Op op,Object value) {
        getCriteriaBuilder().or(columnname,op,value);
        return this;
    }
    public DeleteCriteria and(String columnname,Op op,Object value) {
        getCriteriaBuilder().and(columnname,op,value);
        return this;
    }
  


    @Override
    public DeleteCriteriaBuilder getCriteriaBuilder() {
        if(criteriaBuilder == null){
            return new DeleteCriteriaBuilder();
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
