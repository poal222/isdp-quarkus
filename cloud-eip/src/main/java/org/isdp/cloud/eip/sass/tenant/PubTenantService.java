package org.isdp.cloud.eip.sass.tenant;


import org.isdp.cloud.web.reactive.ReactiveBaseDao;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PubTenantService extends ReactiveCrudBaseService<PubTenantEntity,String> {

    @Inject
    PubTenantDao pubTenantDaoaDao;

    @Override
    public ReactiveBaseDao<PubTenantEntity, String> getRepository() {
        return pubTenantDaoaDao;
    }
}
