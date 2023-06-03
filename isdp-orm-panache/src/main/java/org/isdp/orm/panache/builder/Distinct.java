package org.isdp.orm.panache.builder;

import java.util.Arrays;

/**
 * sql Distinct
 */
public class Distinct {
  /**
   * 单字段 Distinct
   * 
   * @param columnname
   * @return
   */
  public static String select(String columnname) {
    return " DISTINCT " + columnname + " ";
  };

  /**
   * 多字段 Distinct
   * 
   * @param columnnames
   * @return
   */
  public static String select(String... columnnames) {

    StringBuilder sb = new StringBuilder(" DISTINCT ");

    Arrays.asList(columnnames).stream().forEach((String s) -> {
      sb.append(s + ",");
    });
    return sb.toString();
  };
}
