package org.isdp.cloud.eip.sass.organStru.pubStru;

import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.quarkus.logging.Log;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.isdp.cloud.eip.sass.organStru.pubOrg.PubOrgService;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseCmd;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;
import org.isdp.cloud.web.reactive.web.IsdpResponse;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/PubStru/")
@Produces("application/json")
@Consumes("application/json")
@Tag(name = "PubStru", description = "组织结构表")
//@Authenticated
public class PubStruCmd extends ReactiveCrudBaseCmd<PubStrEntity,String> {
    @Inject
    SecurityIdentity securityIdentity;
    @Inject
    PubStruService service;


    @Inject
    io.vertx.mutiny.pgclient.PgPool client;

    @Inject
    PubOrgService pubOrgService;




    @Override
    public ReactiveCrudBaseService<PubStrEntity, String> getCrudBaseService() {
        return service;
    }


    /**
     * 新增
     */
    @POST
    @Path("_insertOrgStru")
    @Operation(summary = "新增一个组织机构，在某个机构视角下，默认是行政视角",
            description = "新增操作，不判断是否已存在！")
    @APIResponse(
            responseCode = "200",
            description = "新增操作，不判断是否已存在！",
            content = @Content(mediaType = APPLICATION_JSON)
    )
    @ReactiveTransactional
    public Uni<IsdpResponse> insertOrgStru(@Valid OrgStruDto orgStruDto) {
        Uni orgUin = pubOrgService.insert(orgStruDto.getPubOrg());
        Uni struUin = service.insert(orgStruDto.getPubStr());
        return Uni.combine().all()
                .unis(orgUin, struUin)
                .combinedWith((org, stru) -> IsdpResponse.OK("orgStruDto"));
    }


    @GET
    @Path("_queryTopStru/{struViewId}")
    @Operation(summary = "查询顶级组织结构", description = "查询顶级组织结构！")
    @APIResponse(responseCode = "200", description = "查询顶级组织结构", content = @Content(mediaType = APPLICATION_JSON))
    @ReactiveTransactional
    public Uni<IsdpResponse> queryTopStru(@PathParam("struViewId") String struViewId) {
        return client.query("SELECT  org_id, stru_view_id, stru_path, name,po.full_name \n" +
                "FROM public.pub_stru ps, public.pub_org po \n" +
                "\n" +
                "where ps.org_id = po.id\n" +
                "and ps.stru_view_id='6'\n" +
                "\n" +
                "and ps.parent_id ='root'").execute()
                .onItem().ifNotNull().transform(rows -> {
            List list = new ArrayList();
            rows.forEach(row -> {
                Map map = new HashMap<>();
                Log.info(row.toJson());
                map.put("org_id", row.getValue("org_id"));
                map.put("stru_view_id", row.getValue("stru_view_id"));
                map.put("stru_path", row.getValue("stru_path"));
                map.put("name", row.getValue("name"));
                map.put("full_name", row.getValue("full_name"));
                list.add(map);
            });
            return list;
        }).onItem().transform(list -> IsdpResponse.OK(list));

    }
}