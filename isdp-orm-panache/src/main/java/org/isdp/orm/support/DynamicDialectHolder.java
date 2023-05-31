package org.isdp.orm.support;
/**
 * 动态方言管理器
 */
public final class DynamicDialectHolder implements DynamicDialectKeyRemovable {

    protected static String getDialectKey(){
        return THREAD_DIALECT.get();
    }

    public static void dialetKey(String dialetKey) {
        THREAD_DIALECT.set(dialetKey);
    }

}