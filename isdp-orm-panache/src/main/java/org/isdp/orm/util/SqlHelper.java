package org.isdp.orm.util;

import java.util.List;

public class SqlHelper {
    //    /**
    //  * select xxx,xxx...
    //  *
    //  * @param entityClass
    //  * @return
    //  */
    // public static String selectAllColumns(Class<?> entityClass) {
    //     StringBuilder sql = new StringBuilder();
    //     sql.append("SELECT ");
    //     sql.append(getAllColumns(entityClass));
    //     sql.append(" ");
    //     return sql.toString();
    // }

    /**
     * select 指定列名，需要注意，此时，不校验列名正确性，需要格外小心
     *
     * @param cloumns 列名集合
     * @return
     */
    public static String selectColumns(List<String> cloumns) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        for (String sqlTableColumn : cloumns) {
            sql.append(sqlTableColumn).append(",");
        }
        return sql.substring(0, sql.length() - 1);
    }
}
