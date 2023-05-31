package org.isdp.orm.panache;

import org.isdp.orm.panache.excuter.Deleter;
import org.isdp.orm.panache.excuter.Inserter;
import org.isdp.orm.panache.excuter.Queryer;
import org.isdp.orm.panache.excuter.Updater;
import org.isdp.orm.support.Dialect;
import org.isdp.orm.support.DynamicDialect;
import org.isdp.orm.support.MysqlDialect;

/**
 * dsl操作上下文总入口
 *  目的：
 *  1、用来加载操作执行器
 *  2、用来获得数据源
 */
public class DSLContext{
    // 数据库方言
    private Dialect dialect;

    private Queryer queryer;

    private Updater updater;

    private Deleter deleter;

    private Inserter Inserter;

    /* 操作区域 */

    public Queryer getQueryer() {
        return queryer;
    }
    public Deleter getDeleter() {
        return deleter;
    }
    public Inserter getInserter() {
        return Inserter;
    }
    public Updater getUpdater() {
        return updater;
    }

    /**
     * 构造函数
     */
    private DSLContext( Dialect dialect){
        this.dialect = dialect;
        queryer = new Queryer(dialect);
    } 


    /**
     * 单态 使用
     * @param dialect 数据库方言
     */
    public static DSLContext getInstance(Dialect dialect){
        return new DSLContext(dialect);
    }


}