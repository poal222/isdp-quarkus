//package org.isdp.cloud.web.reactive.panache;
//
//import java.util.List;
//
//import javax.inject.Inject;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.WebApplicationException;
//
//import io.quarkus.hibernate.reactive.panache.Panache;
//import io.quarkus.hibernate.reactive.panache.PanacheQuery;
//import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
//import io.quarkus.panache.common.Page;
//import org.eclipse.microprofile.openapi.annotations.Operation;
//import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
//import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
//import org.hibernate.reactive.mutiny.Mutiny;
//import org.isdp.cloud.web.reactive.terms.PagerTerms;
//import org.isdp.cloud.web.reactive.web.IsdpPager;
//import org.isdp.cloud.web.reactive.web.IsdpResponse;
//
//import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
//import io.smallrye.mutiny.Uni;
//
//
//public abstract class PanacheReactiveCrudCmd <Entity extends PanacheEntityBase,Pk> {
//
//    @Inject
//    Mutiny.SessionFactory sf;
//
//
//    public abstract PanacheEntityBase getEntity();
//
//
//    /**
//     * 全查询
//     * 不带分页，建议数据量不大的时候使用
//     *
//     * @return
//     */
//    @POST
//    @Path("/_findAll")
//    @ReactiveTransactional
//    public Uni<IsdpResponse> queryAll() {
//        return
//               Panache.withTransaction(getEntity()::persist).map(panacheEntityBase -> IsdpResponse.OK(panacheEntityBase));
//    }
//
//    /**
//     * 分页查询
//     *
//     * @return
//     */
//    @POST
//    @Path("_queryPager")
//    @ReactiveTransactional
//    public Uni<IsdpResponse> queryPager(@RequestBody PagerTerms pagerTerms) {
//
//
//        int size = (int) pagerTerms.getSize();
//        int index = (int) pagerTerms.getIndex();
//        PanacheQuery<Entity> query = null;
//        //查询条件组合
//        StringBuilder termsBulider = new StringBuilder();
//        if(pagerTerms.getTermsList() !=null ){
//            pagerTerms.getTermsList().stream().forEach(isdpTerms -> {
//                termsBulider.append(isdpTerms.getColumn() + " " + isdpTerms.getType().getName() + " " + isdpTerms.getValue());
//            });
//            query= Entity.find(termsBulider.toString());
//        }else {
//            query= Entity.findAll();
//        }
//
//        Uni<List<Entity>> list = query.page(Page.of(index, size)).list();
//        Uni<Long> count = query.count();
//
//        return
//                Uni.combine()
//                        .all().unis(count, list).combinedWith((c, l) -> IsdpResponse.OK(IsdpPager.builder().list(l).total(c).pageSize(Long.valueOf(size)).current(Long.valueOf(index)).build()));
//    }
//
//    @GET
//    @Path("/{id}")
//    @ReactiveTransactional
//    @Operation(summary = "根据ID查找明细")
//    @APIResponse(
//            responseCode = "200",
//            description = "根据ID查找明细"
//    )
//    public Uni<IsdpResponse> getSingle(Pk id) {
//        return sf.withTransaction(
//            (s, t) -> Entity.findById(id)
//        .onItem().ifNotNull().transform(e -> IsdpResponse.OK(e))
//        );
//    }
//
//    @POST
//    @Path("/_inster")
//    public Uni<IsdpResponse> create(Entity entity) {
//        if (entity == null ) {
//            throw new WebApplicationException("Id was invalidly set on request.", 422);
//        }
//
//        return sf.withTransaction((s, t) -> s.persist(
//                entity))
//                .replaceWith(() -> IsdpResponse.OK(entity));
//    }
//
//    @PUT
//    @Path("{id}")
//    @Operation(summary = "修改数据，需要传入的Entity必须包含id")
//    public Uni<IsdpResponse> update(Entity entity) {
//
//        return sf.withTransaction((s, t) ->s.merge(entity)).replaceWith(IsdpResponse.OK(entity));
//    }
//
//    @DELETE
//    @Path("{id}")
//    @ReactiveTransactional
//    public Uni<IsdpResponse> delete(Pk id) {
//        return Entity.findById(id)
//                .onItem().ifNotNull().invoke(entity -> Entity.deleteById(id))
//                .onItem().ifNull().fail().replaceWith(() -> IsdpResponse.OK(id + " is not exist!"))
//                .replaceWith(() -> IsdpResponse.OK(""));
//    }
//
//}