//package org.isdp.cloud.web.reactive.database;
//
//import io.quarkus.datasource.common.runtime.DatabaseKind;
//import io.quarkus.reactive.datasource.ReactiveDataSource;
//import io.vertx.mutiny.pgclient.PgPool;
//import io.vertx.sqlclient.Pool;
//
//import javax.enterprise.context.ApplicationScoped;
//import javax.inject.Inject;
//
//import org.eclipse.microprofile.config.ConfigProvider;
//
//@ApplicationScoped
//public class IsdpDbProvider {
//
//
//
//       @Inject
//       PgPool pool;
//
//
//    /**
//     * 统一处理 pool
//     */
//    public IsdpDbProvider() {
//
//    }
//
//
//    private Pool client;
//
//    public Pool getClient() {
////        String dbKind = ConfigProvider.getConfig().getValue("quarkus.datasource.db-kind",String.class);
////        if( DatabaseKind.isPostgreSQL(dbKind))
////            this.client = (Pool) pool.getDelegate();
//        return (Pool) pool.getDelegate();
//    }
//
//    private void setClient(Pool client) {
//        this.client = client;
//    }
//}
