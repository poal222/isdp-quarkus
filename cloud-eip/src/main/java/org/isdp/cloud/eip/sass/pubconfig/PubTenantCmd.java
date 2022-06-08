package org.isdp.cloud.eip.sass.pubconfig;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseCmd;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/PubConfig/")
@Produces("application/json")
@Consumes("application/json")
@Tag(name = "PubConfig", description = "参数配置表")
//@Authenticated
public class PubTenantCmd extends ReactiveCrudBaseCmd<PubConfig,String> {
    @Inject
    SecurityIdentity securityIdentity;
    @Inject
    PubConfigService service;
    @Override
    public ReactiveCrudBaseService<PubConfig, String> getCrudBaseService() {
            return service;
}
}