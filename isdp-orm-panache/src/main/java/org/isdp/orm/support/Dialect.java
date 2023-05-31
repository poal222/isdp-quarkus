package org.isdp.orm.support;
/**
 * 数据库方言，定义需要动态sql的个性化内容
 * 为了保障框架的简单性，只做简单sql的动态拼接
 */
public interface Dialect {
    /**
     * 方言注册id
     */
    public String getKey();
         /**
     * 数据库方言名称
     *  */ 
    public String getDbType();
        /**
     * 主键
     *  */ 
    public String getPk();
    /**
     * 分页参数
     *  */ 
    public String getLimited(int index,int offset);

}
