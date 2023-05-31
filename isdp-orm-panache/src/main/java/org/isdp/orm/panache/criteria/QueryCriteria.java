package org.isdp.orm.panache.criteria;
/**
 *  * 使用方式：
 *  1、对应至不同的操作，以查询为例，构建QueryCriteria
 */
public class QueryCriteria implements Criteria{

    public QueryCriteria select(String... columns){
        return this;
    };

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCriteriaBuilder'");
    }

    @Override
    public ResultMapBuilder getResultMapBuilder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResultMapBuilder'");
    }
    /**
     * 转成标准sql
     */
    public String build() {
        return "select ";
    }
    
    
}
