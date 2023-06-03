package org.isdp.orm.panache.criteria;

import org.isdp.orm.panache.builder.Op;
import org.isdp.orm.panache.builder.Order;
import org.isdp.orm.support.DynamicDialect;
import org.isdp.orm.support.MysqlDialect;
import org.junit.jupiter.api.Test;

public class QueryCriteriaTest {
    @Test
    void testGetCriteriaBuilder() {
        //动态方言
        DynamicDialect dynamicDialect = new DynamicDialect();
        dynamicDialect.setDefaultDialect(new MysqlDialect());
        QueryCriteria queryCriteria = new QueryCriteria(dynamicDialect.getCurrentDialect());

        queryCriteria.alis("t1")
        .select("code","name")
        .from("pub_user")
        .where("code",Op.GTE,12)
        .and("code",Op.GTE,"codename")
        .or("code",Op.GTE,"codename")
        .orderBy(Order.desc("occasion","occasion1"))
        .groupBy("occasion","occasion1")
        .having("count > 1 ")
        .limit(0, 10);

       System.out.println(queryCriteria.build()); 
    }

    @Test
    void testGetResultMapBuilder() {

    }
}
