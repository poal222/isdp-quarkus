package org.isdp.orm.panache;

import org.isdp.orm.panache.builder.Condition;
import org.isdp.orm.panache.builder.Op;
import org.isdp.orm.panache.builder.Order;
import org.isdp.orm.support.DynamicDialect;
import org.isdp.orm.support.MysqlDialect;
import org.junit.jupiter.api.Test;

public class DSLContextTest {
    @Test
    void testGetCriteriaBuilder() {
        // 动态方言
        DynamicDialect dynamicDialect = new DynamicDialect();
        dynamicDialect.setDefaultDialect(new MysqlDialect());

        DMLContext.getInstance(dynamicDialect.getCurrentDialect())
        .createDeleteCriteria()
                .alis("t1")
                .from("pub_user")
                .where("code",Op.GTE,12)
                .and("code",Op.GTE,"codename")
                .or("code",Op.GTE,"codename")
                .build();
        
            }

    @Test
    void testGetInserter() {
   // 动态方言
   DynamicDialect dynamicDialect = new DynamicDialect();
   dynamicDialect.setDefaultDialect(new MysqlDialect());

   Condition condition = new Condition();
   condition.setIndex(0);
   condition.setParam("code");
   condition.setValues(123);
   Condition condition1 = new Condition();
   condition1.setIndex(1);
   condition1.setParam("name");
   condition1.setValues(123);

   DMLContext.getInstance(dynamicDialect.getCurrentDialect())
   .createInsertCriteria().insertTable("pub_users").insert(condition,condition1).build();
   
    }



    @Test
    void testGetQueryer() {
             // 动态方言
             DynamicDialect dynamicDialect = new DynamicDialect();
             dynamicDialect.setDefaultDialect(new MysqlDialect());

        // 创建查询
        DMLContext.getInstance(dynamicDialect.getCurrentDialect())
        .createQueryCriteria()
               .alis("t1")
               .select("code","name")
               .from("pub_user")
               .where("code",Op.GTE,12)
               .and("code",Op.GTE,"codename")
               .or("code",Op.GTE,"codename")
               .orderBy(Order.desc("occasion","occasion1"))
               .groupBy("occasion","occasion1")
               .having("count > 1 ")
               .limit(0, 10).build();
    }

    @Test
    void testGetUpdater() {
         // 动态方言
         DynamicDialect dynamicDialect = new DynamicDialect();
         dynamicDialect.setDefaultDialect(new MysqlDialect());
  
         Condition condition = new Condition();
         condition.setIndex(0);
         condition.setParam("code");
         condition.setValues(123);
         Condition condition1 = new Condition();
         condition1.setIndex(1);
         condition1.setParam("name");
         condition1.setValues(123);
 // 创建查询
    DMLContext.getInstance(dynamicDialect.getCurrentDialect())
    .createUpdateCriteria()
    .set(condition,condition1)
            .from("pub_user")
            .where("code",Op.GTE,12)
            .and("code",Op.GTE,"codename")
            .or("code",Op.GTE,"codename")
            .build();
    }
}
