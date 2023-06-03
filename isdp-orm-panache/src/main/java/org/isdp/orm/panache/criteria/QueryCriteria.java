package org.isdp.orm.panache.criteria;

import org.isdp.orm.panache.builder.Op;
import org.isdp.orm.support.Dialect;

/**
 *  * 使用方式：
 *  1、对应至不同的操作，以查询为例，构建QueryCriteria
 */
public class QueryCriteria implements Criteria{

    

    private Dialect dialect;

    private QueryCriteriaBuilder criteriaBuilder;

    public QueryCriteria(Dialect dialect) {
        this.dialect = dialect;
        criteriaBuilder = new QueryCriteriaBuilder();
    }
    /**
     * 查询列
     * @param columns 列字段
     * @return
     */
    public QueryCriteria select(String... columns){
        getCriteriaBuilder().select(columns);
        return this;
    };
    /**
     * 设置别名
     * @param alis 别名
     * @return
     */
    public QueryCriteria alis(String alis){
        getCriteriaBuilder().alis(alis);
        return this;
    };
    /**
     * From 
     * @param tablename 表名
     * @return
     */
    public QueryCriteria from(String tablename){
        getCriteriaBuilder().from(tablename);
        return this;
    };
    /**
     * 默认是 eq
     * @param columnname
     * @param value
     * @return
     */
    public QueryCriteria where(String columnname,String value){
        getCriteriaBuilder().where(columnname,Op.EQ,value);
        return this;
    };
    /**
     * 默认是 eq
     * @param columnname
     * @param value
     * @return
     */
    public QueryCriteria where(String columnname,Op op,Object value){
        getCriteriaBuilder().where(columnname,op,value);
        return this;
    };
    public QueryCriteria or(String columnname,Op op,Object value) {
        getCriteriaBuilder().or(columnname,op,value);
        return this;
    }
    public QueryCriteria and(String columnname,Op op,Object value) {
        getCriteriaBuilder().and(columnname,op,value);
        return this;
    }
    public QueryCriteria groupBy(String... columnname) {
        getCriteriaBuilder().groupBy(columnname);
        return this;
    }
    public QueryCriteria having(String condtions) {
        getCriteriaBuilder().having(condtions);
        return this;
    }
    /**
     * orderBy
     * @param order 排序字段
     */
    public QueryCriteria orderBy(String order) {
        getCriteriaBuilder().orderBy(order);
        return this;
    }

    /**
     * 分页
     * @param index
     * @param offset
     * @return
     */
    public QueryCriteria limit(int index,int offset){
        getCriteriaBuilder().limit(dialect.getLimited(index,offset));
        return this;
    };


    @Override
    public QueryCriteriaBuilder getCriteriaBuilder() {
        if(criteriaBuilder == null){
            return new QueryCriteriaBuilder();
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
