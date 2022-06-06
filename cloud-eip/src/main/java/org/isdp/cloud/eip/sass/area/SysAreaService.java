package org.isdp.cloud.eip.sass.area;


import org.isdp.cloud.web.reactive.ReactiveBaseDao;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SysAreaService extends ReactiveCrudBaseService<SysAreaEntity,String> {

    @Inject
    SysAreaDao sysAreaDao;

    @Override
    public ReactiveBaseDao<SysAreaEntity, String> getRepository() {
        return sysAreaDao;
    }
}
