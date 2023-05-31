package org.isdp.orm.panache.criteria;

import org.junit.jupiter.api.Test;

public class QueryCriteriaTest {
    @Test
    void testGetCriteriaBuilder() {
        QueryCriteria queryCriteria = new QueryCriteria();
        queryCriteria.select("code","name");
       System.out.println(queryCriteria.build()); 
    }

    @Test
    void testGetResultMapBuilder() {

    }
}
