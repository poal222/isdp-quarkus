package org.isdp.orm.panache.criteria;

import org.isdp.orm.panache.builder.Op;
import org.isdp.orm.panache.builder.Order;
import org.isdp.orm.support.DynamicDialect;
import org.isdp.orm.support.MysqlDialect;
import org.junit.jupiter.api.Test;

public class NativeQueryCriteriaTest {
    @Test
    void testQuerySql() {
        //动态方言
        DynamicDialect dynamicDialect = new DynamicDialect();
        dynamicDialect.setDefaultDialect(new MysqlDialect());

        NativeQueryCriteria queryCriteria = new NativeQueryCriteria(dynamicDialect.getCurrentDialect());

        queryCriteria.querySql("select *  from sc a, sc b where a.sno=b.sno and a.cno='c001' and b.cno='c002' and a.score>b.score; ").build();
    }
}
