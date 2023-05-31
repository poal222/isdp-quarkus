package org.isdp.orm.panache;

import org.isdp.orm.panache.criteria.QueryCriteria;
import org.isdp.orm.support.DynamicDialect;
import org.isdp.orm.support.MysqlDialect;
import org.junit.jupiter.api.Test;

public class DSLContextTest {
    @Test
    void testGetDeleter() {

    }

    @Test
    void testGetInserter() {

    }

    @Test
    void testGetInstance() {

    }

    @Test
    void testGetQueryer() {
        // 动态方言
        DynamicDialect dynamicDialect = new DynamicDialect();
        dynamicDialect.setDefaultDialect(new MysqlDialect());
        //查询组织
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.select("code","name");
        //初始化panache
        DSLContext.getInstance(dynamicDialect.getCurrentDialect()).getQueryer().Pager(queryCriteria);
    }

    @Test
    void testGetUpdater() {

    }
}
