package org.isdp.cloud.eip.sass.pubconfig;


import org.isdp.cloud.web.reactive.ReactiveBaseDao;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PubConfigService extends ReactiveCrudBaseService<PubConfig,String> {
    @Inject
    PubConfigDao entityDao;
    @Override
    public ReactiveBaseDao<PubConfig, String> getRepository() {
        return entityDao;
    }
}