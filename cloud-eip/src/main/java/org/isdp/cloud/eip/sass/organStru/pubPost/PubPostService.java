package org.isdp.cloud.eip.sass.organStru.pubPost;

import org.isdp.cloud.web.reactive.ReactiveBaseDao;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PubPostService extends ReactiveCrudBaseService<PubPostEntity,String> {
    @Inject
    PubPostDao entityDao;
    @Override
    public ReactiveBaseDao<PubPostEntity, String> getRepository() {
        return entityDao;
    }
}