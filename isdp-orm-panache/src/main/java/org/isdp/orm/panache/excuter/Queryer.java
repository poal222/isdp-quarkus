package org.isdp.orm.panache.excuter;

import org.isdp.orm.panache.criteria.QueryCriteria;
import org.isdp.orm.support.Dialect;

/**
 * 查询器
 */
public  class Queryer {
    /**
     * 方言
     */
    private Dialect dialect;
    
    public Queryer(Dialect dialect2) {
    }
    /**
     * 分页查询
     */
    public String Pager(QueryCriteria queryCriteria){
        return queryCriteria.build();
        
    };
    // list(Object)
    // find(Criteria)
    // list(Criteria)
    // get(Id)
    // getOne(Object)

    // /**
    //  *  sql组装器
    //  * @return
    //  */
    // public CriteriaBuilder getCriteriaBuilder();

    //  /**
    //  * 原生sql
    //  * @return
    //  */
    // public String getNativeQuerySql();
    
}
