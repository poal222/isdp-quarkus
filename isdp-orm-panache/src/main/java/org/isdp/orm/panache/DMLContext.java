package org.isdp.orm.panache;

import org.isdp.orm.panache.criteria.DeleteCriteria;
import org.isdp.orm.panache.criteria.InsertCriteria;
import org.isdp.orm.panache.criteria.NativeQueryCriteria;
import org.isdp.orm.panache.criteria.NativeUpdateCriteria;
import org.isdp.orm.panache.criteria.QueryCriteria;
import org.isdp.orm.panache.criteria.UpdateCriteria;
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
public class DMLContext{
    // 数据库方言
    private Dialect dialect;

    private QueryCriteria queryCriteria;

    private UpdateCriteria updateCriteria;

    private InsertCriteria insertCriteria;

    private DeleteCriteria deleteCriteria;

    // 原生sql区域
    private NativeQueryCriteria nativeQueryCriteria;
    private NativeUpdateCriteria NativeUpdateCriteria;

    /* 操作区域 */

    public QueryCriteria createQueryCriteria() {
        queryCriteria = new QueryCriteria(dialect);
        return queryCriteria;    
    }
    public UpdateCriteria createUpdateCriteria() {
        updateCriteria = new UpdateCriteria(dialect);
        return updateCriteria;    
    }
    public InsertCriteria createInsertCriteria() {
        insertCriteria = new InsertCriteria(dialect);
        return insertCriteria;    
    }
    public DeleteCriteria createDeleteCriteria() {
        deleteCriteria = new DeleteCriteria(dialect);
        return deleteCriteria;    
    }
    public NativeQueryCriteria createNativeQueryCriteria() {
        nativeQueryCriteria = new NativeQueryCriteria(dialect);
        return nativeQueryCriteria;    
    }
    public NativeUpdateCriteria createNativeUpdateCriteria() {
        NativeUpdateCriteria = new NativeUpdateCriteria(dialect);
        return NativeUpdateCriteria;    
    }

    /**
     * 构造函数
     */
    private DMLContext( Dialect dialect){
        this.dialect = dialect;
     
    } 


    /**
     * 单态 使用
     * @param dialect 数据库方言
     */
    public static DMLContext getInstance(Dialect dialect){
        return new DMLContext(dialect);
    }


}