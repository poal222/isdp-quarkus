package org.isdp.orm.panache.criteria;

import org.isdp.orm.support.DynamicDialect;
import org.isdp.orm.support.MysqlDialect;
import org.junit.jupiter.api.Test;

public class NativeUpdateCriteriaTest {
    @Test
    void testUpdateSql() {
        //动态方言
        DynamicDialect dynamicDialect = new DynamicDialect();
        dynamicDialect.setDefaultDialect(new MysqlDialect());

        NativeUpdateCriteria queryCriteria = new NativeUpdateCriteria(dynamicDialect.getCurrentDialect());

        queryCriteria.updateSql("update T_REP_JXJH_YEAR AA set AA.dydj = BB.dyname,AA.state='已批准' from ("+
        "select aa.id,aa.name,bb.name as dyname from T_CIM_ACLINESEGMENT aa,T_CIM_BASEVOLTAGE bb where aa.bv_id = bb.id"+
        " union"+
        "  select t2.id,t2.name,t1.dyname as dyname from "+
        "    ("+
            "   select a.id,a.name,a.tr_id,b.name as dyname from T_CIM_TRANSFORMERWINDING a,T_CIM_BASEVOLTAGE b "+
            "    where a.bv_id = b.id and wind_type = '0'"+
            ") t1,T_CIM_POWERTRANSFORMER t2"+
            " where t1.tr_id = t2.id"+
            "union"+
            "select a.id,a.name,b.name as dyname from T_CIM_BUSBARSECTION a,T_CIM_BASEVOLTAGE b "+
            "where a.bv_id = b.id"+
            ") BB where AA.equid = BB.id").build();
    }
}
