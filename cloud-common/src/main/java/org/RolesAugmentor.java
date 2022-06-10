package org.isdp.cloud.auth;


import io.quarkus.security.identity.AuthenticationRequestContext;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.identity.SecurityIdentityAugmentor;
import io.quarkus.security.runtime.QuarkusSecurityIdentity;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/**
 * 重写认证信息
 */
@ApplicationScoped
public class RolesAugmentor  implements SecurityIdentityAugmentor, Supplier<SecurityIdentity> {

    SecurityIdentity identity;


    @Override
    public Uni<SecurityIdentity> augment(SecurityIdentity securityIdentity, AuthenticationRequestContext authenticationRequestContext) {
        return null;
    }

    @Override
    public SecurityIdentity get() {
        if (!identity.isAnonymous()) {
            // role-name
            Set<String> roles = identity.getRoles();
            // permission-name
            Set<String> perSet = new HashSet<>();
            // 查库找permission where role-name in(roles),addAll...
            Map<String, Object> map = ((JsonWebToken) identity.getPrincipal()).getClaim("client-id");

            return QuarkusSecurityIdentity.builder()
                    .setPrincipal(identity.getPrincipal())
                    .addAttributes(map == null ? Collections.emptyMap() : map)
                    .addCredentials(identity.getCredentials())
                    .addRoles(perSet)
                    .build();

        }

        return identity;
    }
}
