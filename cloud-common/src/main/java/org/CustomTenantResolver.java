package org;

import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;

/**
 * 获取租户信息
 */
@ApplicationScoped
public class CustomTenantResolver implements io.quarkus.oidc.TenantResolver {

    @Override
    public String resolve(RoutingContext context) {
        String path = context.request().path();
        String[] parts = path.split("/");

        if (parts.length == 0) {
            // resolve to default tenant configuration
            return "defult";
        }

        return parts[1];
    }
}
