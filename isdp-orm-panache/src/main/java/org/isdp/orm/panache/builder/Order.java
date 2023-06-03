package org.isdp.orm.panache.builder;

import java.util.Arrays;

public class Order {
   private static StringBuilder sb = new StringBuilder(" ORDER BY  ");
    /**
     * 升序
     * @param col
     * @return
     */
    public static String asc(String... cols ) {
        Arrays.asList(cols).stream().forEach((String s) -> {
          sb.append(s + ",");
        });
        
        return sb.toString().substring(0,sb.toString().length() - 1)+" ASC ";
    }
     /**
     * 降序
     * @param col
     * @return
     */
    public static String desc(String... cols ) {
        Arrays.asList(cols).stream().forEach((String s) -> {
            sb.append(s + ",");
          });
          return sb.toString().substring(0,sb.toString().length() - 1)+" DESC ";
    }

}
