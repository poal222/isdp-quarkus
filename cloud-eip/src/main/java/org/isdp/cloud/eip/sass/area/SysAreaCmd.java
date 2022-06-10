package org.isdp.cloud.eip.sass.area;

import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseCmd;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;
import org.isdp.cloud.web.reactive.database.IsdpDbProvider;
import org.jboss.resteasy.reactive.NoCache;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/area")
@Tag(name = "area", description = "区域管理")
//@Authenticated
public class SysAreaCmd extends ReactiveCrudBaseCmd<SysAreaEntity,String> {

    @Inject
    SecurityIdentity securityIdentity;

    @GET
    @Path("/me")
    @NoCache
    public Uni<User> me() {
        return  Uni.createFrom().item(new User(securityIdentity));

    }

    public static class User {

        private final String userName;

        User(SecurityIdentity securityIdentity) {
            this.userName = securityIdentity.getPrincipal().getName();
        }


        public String getUserName() {
            return userName;
        }
    }

    @Inject SysAreaService sysAreaService;

    @Override
    public ReactiveCrudBaseService<SysAreaEntity, String> getCrudBaseService() {
        return sysAreaService;
    }
}
