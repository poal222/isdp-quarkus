package org.isdp.cloud.eip.sass.dict.service;

import org.isdp.cloud.eip.sass.dict.dao.SysDictDao;
import org.isdp.cloud.eip.sass.dict.entity.SysDict;
import org.isdp.cloud.eip.sass.dict.entity.SysDictItem;
import org.isdp.cloud.web.reactive.ReactiveBaseDao;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @author 王岗
 */
@ApplicationScoped
public class SysDictService extends ReactiveCrudBaseService<SysDict, String> {

    @Inject
    SysDictDao sysDictDao;


    @Override
    public ReactiveBaseDao<SysDict, String> getRepository() {
        return sysDictDao;
    }
}
