package org.isdp.cloud.eip.sass.organStru.pubPost;
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseCmd;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/PubPost/")
@Produces("application/json")
@Consumes("application/json")
@Tag(name = "PubPost", description = "岗位管理表")
//@Authenticated
public class PubPostCmd extends ReactiveCrudBaseCmd<PubPostEntity,String> {
    @Inject
    SecurityIdentity securityIdentity;
    @Inject
    PubPostService service;
    @Override
    public ReactiveCrudBaseService<PubPostEntity, String> getCrudBaseService() {
        return service;
    }
}