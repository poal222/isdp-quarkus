package org.isdp.cloud.eip.sass.logging;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.logging.Log;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Tuple;
import lombok.SneakyThrows;
import org.isdp.cloud.eip.sass.PubLog.PubLogEntity;
import org.isdp.cloud.eip.sass.PubLog.PubLogService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.container.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.UUID;

/**
 * 统一日志记录
 * 实现类必须使用@Provider注解修饰，这样才会被JAX-Rs执行。(javax.ws.rs.ext.Provider)
 * 如果没有使用注解（javax.ws.rs.NameBinding），对于该实现类的实例，作用域是全局的。
 * 如果实现类不使用@PreMatching注解，将在请求到资源（该处资源指的是被@Get、@Post、@Put…修饰的方法）之后执行。
 * 如果实现类使用@PreMatching注解，将在请求到资源之前执行。
 */
@Provider
@Logged
public class RestLoggingFilter implements ContainerRequestFilter , ContainerResponseFilter {

    private static final Logger LOG = Logger.getLogger(RestLoggingFilter.class);


    @Inject
    PubLogService pubLogService;

    @Context
    UriInfo info;

    @Context
    HttpServerRequest request;

    @Inject
    PgPool pgPool;

    @SneakyThrows
    @Override
    public void filter(ContainerRequestContext context) {

        final String method = context.getMethod();
        final String path = info.getPath();
        final String address = request.remoteAddress().toString();
        LOG.debugf("Request %s %s from IP %s", method, path, address);
        LOG.infof("Request %s %s from IP %s", method, path, address);
//        Log.infof("after excute  time is s%",context.getDate().toString());

        PubLogEntity pubLogEntity = new PubLogEntity();
        pubLogEntity.setId(UUID.randomUUID().toString());
// 2: 操作日志
        pubLogEntity.setType(2);
/** 日志状态;1:失败,2:成功 */
        pubLogEntity.setState(2);
/** 用户名，操作用户 */
        pubLogEntity.setUsername("admin");
/** 操作 */
        pubLogEntity.setOperation(info.toString());
/** 调用方法 */
        pubLogEntity.setMethod(path);
/** 调用方法 */
        pubLogEntity.setClientIp(request.remoteAddress().hostAddress());
/** 设备名称 */
        pubLogEntity.setDeviceName("");
        pubLogEntity.setRealName("admin");
        pubLogEntity.setModule("eip");
        pubLogEntity.setOrgId("eip");
        pubLogEntity.setCreateBy("eip");
/** 浏览器名称 */
        pubLogEntity.setBrowserName("");
/** 用户代理 */
        pubLogEntity.setUserAgent("");
/** 请求地址 */
        pubLogEntity.setRequestUri(path);
/** 请求方法 */
        pubLogEntity.setRequestMethod(path);
/** 异常信息 */
        pubLogEntity.setException(path);
/** 查询条件 */
        pubLogEntity.setQueryString(path);
/** 请求参数 */
        pubLogEntity.setParams(path);
/** 耗时 */
        pubLogEntity.setElapsedTime("");
/** 租户id */
        pubLogEntity.setTenantId("6");


        // todo 异步日志操作
        Panache.withTransaction(()->pubLogService.insert(pubLogEntity))
                .onFailure().invoke(throwable -> System.out.println(throwable))
                .subscribe().with(rows -> System.out.println(rows));
//        pgPool.withTransaction(client -> client
//                        .preparedQuery("SELECT  org_id, stru_view_id, stru_path, name,po.full_name \n" +
//                                "FROM public.pub_stru ps, public.pub_org po \n" +
//                                "\n" +
//                                "where ps.org_id = po.id\n" +
//                                "and ps.stru_view_id='6'\n" +
//                                "\n" +
//                                "and ps.parent_id ='root'")
//                        .execute()).subscribe().with(rows -> System.out.println(rows));
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        Log.infof("after excute  time is d%",responseContext.getDate());
    }
}