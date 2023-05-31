package org.isdp.orm.panache.criteria;

/**
 * 标准sql-对应类
 * 使用方式：
 *  1、对应至不同的操作，以查询为例，构建QueryCriteria
 * 
 */
public interface Criteria {
    //date-baen
    public CriteriaBuilder getCriteriaBuilder();
    //结果类
    public ResultMapBuilder getResultMapBuilder();
}
