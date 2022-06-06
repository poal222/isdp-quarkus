package org.isdp.cloud.eip.sass.users;

import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.isdp.cloud.eip.sass.tenant.PubTenantEntity;
import org.isdp.cloud.eip.sass.tenant.PubTenantService;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseCmd;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;
import org.jboss.resteasy.reactive.NoCache;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/users")
@Tag(name = "users", description = "用户管理")
//@Authenticated
public class PubUserCmd extends ReactiveCrudBaseCmd<PubUserEntity,String> {

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

    @Inject
    PubUserService pubUserService;

    @Override
    public ReactiveCrudBaseService<PubUserEntity, String> getCrudBaseService() {
        return pubUserService;
    }
}
