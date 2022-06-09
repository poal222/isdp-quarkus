package org.isdp.cloud.eip.sass.organStru.pubStru;

import javax.persistence.*;
import java.util.Date;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import lombok.Data;
import org.isdp.cloud.web.reactive.base.BaseEntity;

/**
 * @author : http://www.chiner.pro
 * @date : 2022-6-9
 * @desc : 组织结构表
 */
@Entity
@Table(name="Pub_Stru")
@Schema(name = "组织结构表")
@Data
public class PubStrEntity extends BaseEntity {

    /** 组织机构id */
    @Schema( description = "组织机构id" )
    @Column(name = "org_id")
    private String orgId ;
    /** 机构视角id，默认是行政视角 */
    @Schema( description = "机构视角id，默认是行政视角" )
    @Column(name = "stru_view_id")
    private String struViewId ;
    /** 上级组织id，这个id和orgid没关系 */
    @Schema( description = "上级组织id，这个id和orgid没关系" )
    @Column(name = "parent_id")
    private String parentId ;
    /** 机构的路径 */
    @Schema( description = "机构的路径" )
    @Column(name = "stru_path")
    private String struPath ;
    /** 租户id */
    @Schema( description = "租户id" )
    @Column(name = "tenant_id")
    private String tenantId ;
    /** 显示排序 */
    @Schema( description = "显示排序" )
    @Column(name = "seq")
    private  Integer seq ;
    /** 创建者 */
    @Schema( description = "创建者" )
    @Column(name = "create_by")
    private String createBy ;

    /** 更新者 */
    @Schema( description = "更新者" )
    @Column(name = "update_by")
    private String updateBy ;

    /** 删除标记0:保留;1:删除 */
    @Schema( description = "删除标记0:保留" )
    @Column(name = "del_flag")
    private String delFlag ;

}