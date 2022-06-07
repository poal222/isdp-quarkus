package org.isdp.cloud.web.reactive;

import io.quarkus.hibernate.reactive.panache.PanacheQuery;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.hibernate.reactive.mutiny.Mutiny;
import org.isdp.cloud.web.reactive.terms.PagerTerms;
import org.isdp.cloud.web.reactive.web.IsdpPager;
import org.isdp.cloud.web.reactive.web.IsdpResponse;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public abstract class ReactiveCrudBaseCmd<Entity, Id> {

    public abstract ReactiveCrudBaseService<Entity, Id> getCrudBaseService();

    @Inject
    Mutiny.SessionFactory sf;


    /**
     * 新增
     */
    @POST
    @Path("_insert")
    @Operation(summary = "新增",
            description = "新增操作，不判断是否已存在！")
    @ReactiveTransactional
    public Uni<IsdpResponse> insert(@Valid Entity entity) {
        return getCrudBaseService().insert(entity)
                .onItem().ifNotNull().transform(entity1-> IsdpResponse.OK(entity))
                .onFailure().invoke(throwable -> IsdpResponse.error("1000", throwable.getMessage()));

    }

    /**
     * 分页查询
     *
     * @return
     */
    @POST
    @Path("_queryPager")
    @ReactiveTransactional
    public Uni<IsdpResponse> queryPager(@RequestBody PagerTerms pagerTerms) {

        int size = (int) pagerTerms.getSize();
        int index = (int) pagerTerms.getIndex();
        PanacheQuery<Entity> query = null;
                //查询条件组合
        StringBuilder termsBulider = new StringBuilder();
        if(pagerTerms.getTermsList() !=null ){
            pagerTerms.getTermsList().stream().forEach(isdpTerms -> {
                termsBulider.append(isdpTerms.getColumn() + " " + isdpTerms.getType().getName() + " " + isdpTerms.getValue());
            });
            query= getCrudBaseService().find(termsBulider.toString());
        }else {
            query= getCrudBaseService().findAll();
        }

        Uni<List<Entity>> list = query.page(Page.of(index, size)).list();
        Uni<Long> count = query.count();

        return
                Uni.combine()
                .all().unis(count, list).combinedWith((c, l) -> IsdpResponse.OK(IsdpPager.builder().list(l).total(c).pageSize(Long.valueOf(size)).current(Long.valueOf(index)).build()));
    }

    /**
     * 全查询
     * 不带分页，建议数据量不大的时候使用
     *
     * @return
     */
    @POST
    @Path("findAll")
    @ReactiveTransactional
    public Uni<IsdpResponse> findAll() {
//        List<Entity> list = getCrudBaseService().findAll().list();
        return getCrudBaseService().findAll().list().onItem()
                .ifNotNull().transform(entities -> IsdpResponse.OK(entities));
    }

    @GET
    @Path("{id}")
    @Operation(summary = "根据ID查找明细")
    @APIResponse(
            responseCode = "200",
            description = "根据ID查找明细"
    )
    public Uni<IsdpResponse> getSingle(@Parameter(name = "id", required = true) @PathParam("id") Id id) {
        return getCrudBaseService().findById(id)
                .onItem().ifNotNull().transform(entity -> IsdpResponse.OK(entity));
    }

    @PUT
    @Operation(summary = "修改数据，需要传入的Entity必须包含id")
    @ReactiveTransactional
    public Uni<IsdpResponse> update(@RequestBody  Entity e) {
        if (e == null) throw new WebApplicationException("Entity must be not null", 422);
        return sf.withTransaction((session,tx) -> session.merge(e))
                .onItem().transform(entity -> IsdpResponse.OK(entity));
    }
//    @PUT
//    @Path("{id}")
//    @Operation(summary = "根据ID修改数据,传入需要修改的值，该方法只支持具体字段的修改，前台需要传入修改参数及修改值")
//    @ReactiveTransactional
//    public Uni<Entity> update(@PathParam("id")Id id, @RequestBody Parameters) {
//        return getCrudBaseService().update()
//    }
    @DELETE
    @Operation(summary = "根据ID删除数据")
    @APIResponse(
            responseCode = "204",
            description = "根据ID删除数据"
    )
    @Path("/{id}")
    public Uni<Object> delete(@Parameter(name = "id", required = true) @PathParam("id") Id id) {

        return getCrudBaseService().findById(id)
                .onItem().ifNotNull().invoke(entity -> getCrudBaseService().delete(entity))
                .onItem().ifNull().fail().replaceWith(() -> IsdpResponse.OK(id + " is not exist!"))
                .replaceWith(() -> IsdpResponse.OK(""));
    }

}
