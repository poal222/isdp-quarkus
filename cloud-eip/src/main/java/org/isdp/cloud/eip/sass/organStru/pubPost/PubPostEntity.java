package org.isdp.cloud.eip.sass.organStru.pubPost;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import lombok.Data;
import org.isdp.cloud.web.reactive.base.BaseEntity;

/**
 * @author : http://www.chiner.pro
 * @date : 2022-6-9
 * @desc : 岗位管理表
 */
@Entity
@Table(name="pub_post")
@Schema(name = "岗位管理表")
@Data
public class PubPostEntity extends BaseEntity {

    /** 岗位名称 */
    @Schema( description = "岗位名称" )
    @Column(name = "name")
    private String name ;
    /** 岗位编码 */
    @Schema( description = "岗位编码" )
    @Column(name = "code")
    private String code ;
    /** 岗位类型 */
    @Schema( description = "岗位类型" )
    @Column(name = "type")
    private String type ;
    /** 岗位排序 */
    @Schema( description = "岗位排序" )
    @Column(name = "order_num")
    private Integer orderNum ;
    /** 备注 */
    @Schema( description = "备注" )
    @Column(name = "remark")
    private String remark ;
    /** 0为禁用;1为有效 */
    @Schema( description = "0为禁用" )
    @Column(name = "status")
    private Integer status ;
    /** 租户id */
    @Schema( description = "租户id" )
    @Column(name = "tenant_id")
    private String tenantId ;
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
    private Integer delFlag ;

}