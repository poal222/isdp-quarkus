package org.isdp.orm.support;

import java.util.HashMap;
import java.util.Map;
/**
 * 对数据库方言的管理
 */
public class DynamicDialect {
    /**
     * 默认方言
     */
    private Dialect defaultDialect;
    /**
     * 方言支持pool
     */
    private Map<String,Dialect> map = new HashMap<>();
    
    public void setDefaultDialect(Dialect dialect) {
        this.defaultDialect = dialect;
        map.put(dialect.getKey(),dialect);
    }

    public void addDialect(Dialect dialect) {
        map.put(dialect.getKey(), dialect);
    }
    public String getKey(){
        String key = DynamicDialectHolder.getDialectKey();
        if (key == null){
            return defaultDialect.getKey();
        }
        Dialect currentDialect = map.get(key);
        return currentDialect.getKey();
    }

    public Dialect getCurrentDialect() {
        String key = DynamicDialectHolder.getDialectKey();
        if (key == null){
            return defaultDialect;
        }
        return map.get(key);
    }
}
