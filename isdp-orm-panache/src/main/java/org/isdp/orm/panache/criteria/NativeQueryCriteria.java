package org.isdp.orm.panache.criteria;

import org.isdp.orm.support.Dialect;

/**
 * 原生sql查询
 */
public class NativeQueryCriteria implements Criteria{


    private Dialect dialect;

    private NativeQueryCriteriaBuilder criteriaBuilder;

    public NativeQueryCriteria(Dialect dialect) {
        this.dialect = dialect;
        criteriaBuilder = new NativeQueryCriteriaBuilder();
    }

    @Override
    public NativeQueryCriteriaBuilder getCriteriaBuilder() {
        if(criteriaBuilder == null){
            return new NativeQueryCriteriaBuilder();
        }
        return criteriaBuilder;
    }
    /**
     * 原生查询 sql
     * @param sql 完整的查询sql语句
     */
    public NativeQueryCriteria querySql(String sql){
        getCriteriaBuilder().querySql(sql);
        return this;
    }

    @Override
    public ResultMapBuilder getResultMapBuilder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResultMapBuilder'");
    }
    
}
