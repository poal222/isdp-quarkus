package org.isdp.cloud.eip.sass.users;


import org.isdp.cloud.web.reactive.ReactiveBaseDao;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PubUserService extends ReactiveCrudBaseService<PubUserEntity,String> {

    @Inject
    PubUserDao pubUserDao;

    @Override
    public ReactiveBaseDao<PubUserEntity, String> getRepository() {
        return pubUserDao;
    }
}
