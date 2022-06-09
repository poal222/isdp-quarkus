package org.isdp.cloud.eip.sass.organStru.pubStruView;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseCmd;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/PubStruView/")
@Produces("application/json")
@Consumes("application/json")
@Tag(name = "PubStruView", description = "机构视角")
@Authenticated
public class PubStruViewCmd extends ReactiveCrudBaseCmd<PubStruViewEntity,String> {
    @Inject
    SecurityIdentity securityIdentity;
    @Inject
    PubStruViewService service;
    @Override
    public ReactiveCrudBaseService<PubStruViewEntity, String> getCrudBaseService() {
        return service;
    }
}