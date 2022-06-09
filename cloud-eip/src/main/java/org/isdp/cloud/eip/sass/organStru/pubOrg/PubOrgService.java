package org.isdp.cloud.eip.sass.organStru.pubOrg;

import org.isdp.cloud.web.reactive.ReactiveBaseDao;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PubOrgService extends ReactiveCrudBaseService<PubOrgEntity,String> {
    @Inject
    PubOrgDao entityDao;
    @Override
    public ReactiveBaseDao<PubOrgEntity, String> getRepository() {
        return entityDao;
    }
}