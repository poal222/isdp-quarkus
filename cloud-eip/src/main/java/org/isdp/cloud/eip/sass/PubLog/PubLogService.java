package org.isdp.cloud.eip.sass.PubLog;

import org.isdp.cloud.web.reactive.ReactiveBaseDao;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PubLogService extends ReactiveCrudBaseService<PubLogEntity,String> {
    @Inject
    PubLogDao entityDao;
    @Override
    public ReactiveBaseDao<PubLogEntity, String> getRepository() {
        return entityDao;
    }
}