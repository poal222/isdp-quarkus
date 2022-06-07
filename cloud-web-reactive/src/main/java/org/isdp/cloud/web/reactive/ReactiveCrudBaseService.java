package org.isdp.cloud.web.reactive;

import io.quarkus.hibernate.reactive.panache.PanacheQuery;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


/**
 * curd service默认服务接口
 */
public abstract class ReactiveCrudBaseService<Entity, Id> {
    //dao层
    public abstract ReactiveBaseDao<Entity, Id> getRepository();

    @ReactiveTransactional
    public Uni<Object> createQuery(final String qlsql) {
        return getRepository().getSession().flatMap(session -> {
            return session.createQuery(qlsql).getResultList();
        });
    }

    @ReactiveTransactional
    public Uni<Entity> insert(Entity entity) {
    
       return getRepository().persist(entity);

    }
    @ReactiveTransactional
    public Uni<Void> insert(Stream<Entity> entityStream) {
        return getRepository().persist(entityStream);

    }

    @ReactiveTransactional
    public void delete(Entity entity) {
        getRepository().delete(entity);
    }

    @ReactiveTransactional
    public Uni<Boolean> deleteById(Id id) {
        return getRepository().deleteById(id);
    }

    @ReactiveTransactional
    public Uni<Long> delete(String query, Object... params) {
        return getRepository().delete(query, params);
    }


    @ReactiveTransactional
    public Uni<Long> delete(String query, Map<String, Object> params) {
        return getRepository().delete(query, params);
    }

    @ReactiveTransactional
    public Uni<Long> delete(String query, Parameters params) {
        return getRepository().delete(query, params);
    }


    @ReactiveTransactional
    public Uni<Integer> update(String query, Object... params) {
        return getRepository().update(query, params);
    }

    @ReactiveTransactional
    public Uni<Integer> update(String query, Map<String, Object> params) {
        return getRepository().update(query, params);
    }

    @ReactiveTransactional
    public Uni<Integer> update(String query, Parameters params) {
        return getRepository().update(query, params);
    }

    @ReactiveTransactional
    public Uni<Long> count() {
        return getRepository().count();
    }

    /**
     * Counts the number of this type of entity matching the given query, with optional indexed parameters.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param params optional sequence of indexed parameters
     * @return the number of entities counted.
     * @see #count()
     * @see #count(String, Map)
     * @see #count(String, Parameters)
     */
    @ReactiveTransactional
    public Uni<Long> count(String query, Object... params) {
        return getRepository().count(query, params);
    }

    /**
     * Counts the number of this type of entity matching the given query, with named parameters.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param params {@link Map} of named parameters
     * @return the number of entities counted.
     * @see #count()
     * @see #count(String, Object...)
     * @see #count(String, Parameters)
     */
    @ReactiveTransactional
    public Uni<Long> count(String query, Map<String, Object> params) {
        return getRepository().count(query, params);
    }

    /**
     * Counts the number of this type of entity matching the given query, with named parameters.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param params {@link Parameters} of named parameters
     * @return the number of entities counted.
     * @see #count()
     * @see #count(String, Object...)
     * @see #count(String, Map)
     */
    @ReactiveTransactional
    public Uni<Long> count(String query, Parameters params) {
        return getRepository().count(query, params);
    }

    // Queries

    /**
     * Find an entity of this type by ID.
     *
     * @param id the ID of the entity to find.
     * @return the entity found, or <code>null</code> if not found.
     */
    @ReactiveTransactional
    public Uni<Entity> findById(Id id) {
        return getRepository().findById(id);
    }

    /**
     * Find an entity of this type by ID and lock it.
     *
     * @param id           the ID of the entity to find.
     * @param lockModeType the locking strategy to be used when retrieving the entity.
     * @return the entity found, or <code>null</code> if not found.
     */
    @ReactiveTransactional
    public Uni<Entity> findById(Id id, LockModeType lockModeType) {
        return getRepository().findById(id, lockModeType);
    }


    /**
     * Find entities using a query, with optional indexed parameters.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param params optional sequence of indexed parameters
     * @return a new {@link PanacheQuery} instance for the given query
     * @see #find(String, Sort, Object...)
     * @see #find(String, Map)
     * @see #find(String, Parameters)
     * @see #list(String, Object...)
     */
    public PanacheQuery<Entity> find(String query, Object... params) {
        return getRepository().find(query, params);
    }

    /**
     * Find entities using a query and the given sort options, with optional indexed parameters.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param sort   the sort strategy to use
     * @param params optional sequence of indexed parameters
     * @return a new {@link PanacheQuery} instance for the given query
     * @see #find(String, Object...)
     * @see #find(String, Sort, Map)
     * @see #find(String, Sort, Parameters)
     * @see #list(String, Sort, Object...)
     */
    public PanacheQuery<Entity> find(String query, Sort sort, Object... params) {
        return getRepository().find(query, sort, params);
    }

    /**
     * Find entities using a query, with named parameters.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param params {@link Map} of named parameters
     * @return a new {@link PanacheQuery} instance for the given query
     * @see #find(String, Sort, Map)
     * @see #find(String, Object...)
     * @see #find(String, Parameters)
     * @see #list(String, Map)
     */
    public PanacheQuery<Entity> find(String query, Map<String, Object> params) {
        return getRepository().find(query, params);
    }

    /**
     * Find entities using a query and the given sort options, with named parameters.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param sort   the sort strategy to use
     * @param params {@link Map} of indexed parameters
     * @return a new {@link PanacheQuery} instance for the given query
     * @see #find(String, Map)
     * @see #find(String, Sort, Object...)
     * @see #find(String, Sort, Parameters)
     * @see #list(String, Sort, Map)
     */
    public PanacheQuery<Entity> find(String query, Sort sort, Map<String, Object> params) {
        return getRepository().find(query, sort, params);
    }

    /**
     * Find entities using a query, with named parameters.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param params {@link Parameters} of named parameters
     * @return a new {@link PanacheQuery} instance for the given query
     * @see #find(String, Sort, Parameters)
     * @see #find(String, Map)
     * @see #find(String, Parameters)
     * @see #list(String, Parameters)
     */
    public PanacheQuery<Entity> find(String query, Parameters params) {
        return getRepository().find(query, params);
    }

    /**
     * Find entities using a query and the given sort options, with named parameters.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param sort   the sort strategy to use
     * @param params {@link Parameters} of indexed parameters
     * @return a new {@link PanacheQuery} instance for the given query
     * @see #find(String, Parameters)
     * @see #find(String, Sort, Map)
     * @see #find(String, Sort, Parameters)
     * @see #list(String, Sort, Parameters)
     */
    public PanacheQuery<Entity> find(String query, Sort sort, Parameters params) {
        return getRepository().find(query, sort, params);
    }

    /**
     * Find all entities of this type.
     *
     * @return a new {@link PanacheQuery} instance to find all entities of this type.
     * @see #findAll(Sort)
     * @see #listAll()
     */
    public PanacheQuery<Entity> findAll() {
        return getRepository().findAll();
    }

    /**
     * Find all entities of this type, in the given order.
     *
     * @param sort the sort order to use
     * @return a new {@link PanacheQuery} instance to find all entities of this type.
     * @see #findAll()
     * @see #listAll(Sort)
     */
    public PanacheQuery<Entity> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    /**
     * Find entities matching a query, with optional indexed parameters.
     * This method is a shortcut for <code>find(query, params).list()</code>.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param params optional sequence of indexed parameters
     * @return a {@link List} containing all results, without paging
     * @see #list(String, Sort, Object...)
     * @see #list(String, Map)
     * @see #list(String, Parameters)
     * @see #find(String, Object...)
     */
    @ReactiveTransactional
    public Uni<List<Entity>> list(String query, Object... params) {
        return getRepository().list(query, params);
    }

    /**
     * Find entities matching a query and the given sort options, with optional indexed parameters.
     * This method is a shortcut for <code>find(query, sort, params).list()</code>.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param sort   the sort strategy to use
     * @param params optional sequence of indexed parameters
     * @return a {@link List} containing all results, without paging
     * @see #list(String, Object...)
     * @see #list(String, Sort, Map)
     * @see #list(String, Sort, Parameters)
     * @see #find(String, Sort, Object...)
     */
    @ReactiveTransactional
    public Uni<List<Entity>> list(String query, Sort sort, Object... params) {
        return getRepository().list(query, sort, params);
    }

    /**
     * Find entities matching a query, with named parameters.
     * This method is a shortcut for <code>find(query, params).list()</code>.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param params {@link Map} of named parameters
     * @return a {@link List} containing all results, without paging
     * @see #list(String, Sort, Map)
     * @see #list(String, Object...)
     * @see #list(String, Parameters)
     * @see #find(String, Map)
     */
    @ReactiveTransactional
    public Uni<List<Entity>> list(String query, Map<String, Object> params) {
        return getRepository().list(query, params);
    }

    /**
     * Find entities matching a query and the given sort options, with named parameters.
     * This method is a shortcut for <code>find(query, sort, params).list()</code>.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param sort   the sort strategy to use
     * @param params {@link Map} of indexed parameters
     * @return a {@link List} containing all results, without paging
     * @see #list(String, Map)
     * @see #list(String, Sort, Object...)
     * @see #list(String, Sort, Parameters)
     * @see #find(String, Sort, Map)
     */
    @ReactiveTransactional
    public Uni<List<Entity>> list(String query, Sort sort, Map<String, Object> params) {
        return getRepository().list(query, sort, params);
    }

    /**
     * Find entities matching a query, with named parameters.
     * This method is a shortcut for <code>find(query, params).list()</code>.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param params {@link Parameters} of named parameters
     * @return a {@link List} containing all results, without paging
     * @see #list(String, Sort, Parameters)
     * @see #list(String, Object...)
     * @see #list(String, Map)
     * @see #find(String, Parameters)
     */
    @ReactiveTransactional
    public Uni<List<Entity>> list(String query, Parameters params) {
        return getRepository().list(query, params);
    }

    /**
     * Find entities matching a query and the given sort options, with named parameters.
     * This method is a shortcut for <code>find(query, sort, params).list()</code>.
     *
     * @param query  a {@link io.quarkus.hibernate.orm.panache query string}
     * @param sort   the sort strategy to use
     * @param params {@link Parameters} of indexed parameters
     * @return a {@link List} containing all results, without paging
     * @see #list(String, Parameters)
     * @see #list(String, Sort, Object...)
     * @see #list(String, Sort, Map)
     * @see #find(String, Sort, Parameters)
     */
    @ReactiveTransactional
    public Uni<List<Entity>> list(String query, Sort sort, Parameters params) {
        return getRepository().list(query, sort, params);
    }

    /**
     * Find all entities of this type.
     * This method is a shortcut for <code>findAll().list()</code>.
     *
     * @return a {@link List} containing all results, without paging
     * @see #listAll(Sort)
     * @see #findAll()
     */
    @ReactiveTransactional
    public Uni<List<Entity>> listAll() {
        return getRepository().listAll();
    }

    /**
     * Find all entities of this type, in the given order.
     * This method is a shortcut for <code>findAll(sort).list()</code>.
     *
     * @param sort the sort order to use
     * @return a {@link List} containing all results, without paging
     * @see #listAll()
     * @see #findAll(Sort)
     */
    @ReactiveTransactional
    public Uni<List<Entity>> listAll(Sort sort) {
        return getRepository().listAll(sort);
    }

}
