package org.isdp.cloud.eip.sass.organStru.pubStruView;

import org.isdp.cloud.web.reactive.ReactiveBaseDao;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PubStruViewService extends ReactiveCrudBaseService<PubStruViewEntity,String> {
    @Inject
    PubStruViewDao entityDao;
    @Override
    public ReactiveBaseDao<PubStruViewEntity, String> getRepository() {
        return entityDao;
    }
}