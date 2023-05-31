package org.isdp.orm.support;

public interface DynamicDialectKeyRemovable {

    ThreadLocal<String> THREAD_DIALECT = new ThreadLocal<>();
    default void removeDialectKey(){
        THREAD_DIALECT.remove();
    }
}