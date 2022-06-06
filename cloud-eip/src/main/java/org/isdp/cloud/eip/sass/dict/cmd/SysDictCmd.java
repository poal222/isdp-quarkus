package org.isdp.cloud.eip.sass.dict.cmd;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.isdp.cloud.eip.sass.dict.entity.SysDict;
import org.isdp.cloud.eip.sass.dict.service.SysDictService;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseCmd;
import org.isdp.cloud.web.reactive.ReactiveCrudBaseService;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sysdict")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "sysdict", description = "系统字典")
public class SysDictCmd extends ReactiveCrudBaseCmd<SysDict, Long> {

    @Inject
    SysDictService sysDictService;

    @Override
    public ReactiveCrudBaseService<SysDict, Long> getCrudBaseService() {
        return sysDictService;
    }




}
