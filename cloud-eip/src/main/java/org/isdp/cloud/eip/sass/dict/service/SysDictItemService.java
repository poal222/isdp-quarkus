package org.isdp.cloud.eip.sass.dict.service;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.isdp.cloud.eip.sass.dict.dao.SysDictItemDao;
import org.isdp.cloud.eip.sass.dict.entity.SysDictItem;
import org.isdp.cloud.web.reactive.ReactiveBaseDao;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SysDictItemService extends ReactiveCrudBaseService<SysDictItem, Long> {

    @Inject
    SysDictItemDao sysDictItemDao;


    @Override
    public ReactiveBaseDao<SysDictItem, Long> getRepository() {
        return sysDictItemDao;
    }
}
