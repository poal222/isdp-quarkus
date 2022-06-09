package org.isdp.cloud.eip.sass.organStru.pubStru;


import lombok.Data;
import org.isdp.cloud.eip.sass.organStru.pubOrg.PubOrgEntity;

import java.io.Serializable;

/**
 * 组织机构dto类
 */
@Data
public class OrgStruDto implements Serializable {

    private PubOrgEntity pubOrg;
    private PubStrEntity pubStr;



}
