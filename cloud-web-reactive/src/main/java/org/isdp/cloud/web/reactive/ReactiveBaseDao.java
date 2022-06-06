package org.isdp.cloud.web.reactive;


import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

/**
 * 反应式方式
 * Pk:主键类型
 */
public class ReactiveBaseDao<Entity,Pk> implements PanacheRepositoryBase<Entity, Pk> {
}
