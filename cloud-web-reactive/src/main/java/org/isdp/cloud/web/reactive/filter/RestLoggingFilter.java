package org.isdp.cloud.web.reactive.filter;

import io.vertx.core.http.HttpServerRequest;
import org.jboss.logging.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

/**
 * 统一日志记录
 */
@Provider
public class RestLoggingFilter implements ContainerRequestFilter {

    private static final Logger LOG = Logger.getLogger(RestLoggingFilter.class);

    @Context
    UriInfo info;

    @Context
    HttpServerRequest request;

    @Override
    public void filter(ContainerRequestContext context) {

        final String method = context.getMethod();
        final String path = info.getPath();
        final String address = request.remoteAddress().toString();
        LOG.debugf("Request %s %s from IP %s", method, path, address);
        LOG.infof("Request %s %s from IP %s", method, path, address);
    }
}