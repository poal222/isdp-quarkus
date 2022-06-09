package org.isdp.cloud.eip.sass.organStru.pubStru;

import org.isdp.cloud.web.reactive.ReactiveBaseDao;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PubStruService extends ReactiveCrudBaseService<PubStrEntity,String> {
    @Inject
    PubStruDao entityDao;
    @Override
    public ReactiveBaseDao<PubStrEntity, String> getRepository() {
        return entityDao;
    }
}