package org.isdp.cloud.eip.sass.organStru.pubOrg;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import lombok.Data;
import org.isdp.cloud.web.reactive.base.BaseEntity;

/**
 * @author : http://www.chiner.pro
 * @date : 2022-6-9
 * @desc : 机构表
 */
@Entity
@Table(name="pub_org")
@Schema(name = "机构表")
@Data
public class PubOrgEntity extends BaseEntity {
    /** 机构名称 */
    @Schema( description = "机构名称" )
    @Column(name = "name")
    private String name ;
//    /** 父机构id */
//    @Schema( description = "父机构id" )
//    @Column(name = "parent_id")
//    private String parentId ;
    /** 排序编码 */
    @Schema( description = "排序编码" )
    @Column(name = "order_num")
    private Integer orderNum ;
    /** 备注 */
    @Schema( description = "备注" )
    @Column(name = "remark")
    private String remark ;
    /** 邮箱号码 */
    @Schema( description = "邮箱号码" )
    @Column(name = "email")
    private String email ;
    /** 租户ID */
    @Schema( description = "租户ID" )
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
    /** 机构全名 */
    @Schema( description = "机构全名" )
    @Column(name = "full_name")
    private String fullName ;
    /** 机构编码 */
    @Schema( description = "机构编码" )
    @Column(name = "code")
    private String code ;
    /** 机构类型（如：上市公司、省级公司、部门等） */
    @Schema( description = "机构类型（如：上市公司、省级公司、部门等）" )
    @Column(name = "type")
    private String type ;
    /** 机构名称集合;多个之间使用点隔开 */
    @Schema( description = "机构名称集合" )
    @Column(name = "names")
    private String names ;
//    /** 是否有子节点;0:没有，1:有 */
//    @Schema( description = "是否有子节点" )
//    @Column(name = "has_children")
//    private Boolean hasChildren ;
    /** 负责人 */
    @Schema( description = "负责人" )
    @Column(name = "principal")
    private String principal ;
    /** 联系方式 */
    @Schema( description = "联系方式" )
    @Column(name = "contact")
    private String contact ;
    /** 联系地址 */
    @Schema( description = "联系地址" )
    @Column(name = "address")
    private String address ;
    /** 邮政编码 */
    @Schema( description = "邮政编码" )
    @Column(name = "zip_code")
    private String zipCode ;

}