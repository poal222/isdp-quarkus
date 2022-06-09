package org.isdp.cloud.eip.sass.organStru.pubOrg;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseCmd;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/PubOrg/")
@Produces("application/json")
@Consumes("application/json")
@Tag(name = "PubOrg", description = "机构表")
@Authenticated
public class PubOrgCmd extends ReactiveCrudBaseCmd<PubOrgEntity,String> {
    @Inject
    SecurityIdentity securityIdentity;
    @Inject
    PubOrgService service;
    @Override
    public ReactiveCrudBaseService<PubOrgEntity, String> getCrudBaseService() {
        return service;
    }
}