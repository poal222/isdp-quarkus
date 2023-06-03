package org.isdp.orm.panache.criteria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 标准sql-对应类
 * 使用方式：
 *  1、对应至不同的操作，以查询为例，构建QueryCriteria
 * 
 */
public interface Criteria {
     Logger logger = LoggerFactory.getLogger(Criteria.class);

    //date-baen
    public CriteriaBuilder getCriteriaBuilder();
    //结果类
    public ResultMapBuilder getResultMapBuilder();

        /**
     * 转成标准sql
     */
    default String build() {
        String sql = getCriteriaBuilder().toSql();
        logger.info("panache excute sql is: =======> {}",sql);
        return sql;
    }
}
