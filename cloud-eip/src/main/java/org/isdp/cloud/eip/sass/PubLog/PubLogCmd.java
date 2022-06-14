package org.isdp.cloud.eip.sass.PubLog;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseCmd;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/PubLog/")
@Produces("application/json")
@Consumes("application/json")
@Tag(name = "PubLog", description = "系统日志表")
//@Authenticated
public class PubLogCmd extends ReactiveCrudBaseCmd<PubLogEntity,String> {
    @Inject
    SecurityIdentity securityIdentity;
    @Inject
    PubLogService service;
    @Override
    public ReactiveCrudBaseService<PubLogEntity, String> getCrudBaseService() {
        return service;
    }
}