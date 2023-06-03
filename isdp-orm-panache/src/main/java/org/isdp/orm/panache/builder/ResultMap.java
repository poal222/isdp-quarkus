package org.isdp.orm.panache.builder;
/**
 * sql结果集组装
 * 例：
 *  <id property="id" column="id"></id>
 *  <result property="username" column="userName"></result>
 */
public class ResultMap {
    /**
     *  java-bean 属性
     */
    private String property;
    /**
     * 列名
     */
    private String column;
    /**
     * 字段类型
     */
    private String type;

}
