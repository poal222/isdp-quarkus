package org.isdp.cloud.eip.sass.area;

import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.isdp.cloud.web.reactive.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * 区域
 */
@Table(name = "PUB_AREA")
@Entity
@Schema(name = "区域")
@Data
public class SysAreaEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "name")
    @Schema(required = true, example = "区域名称")
    @NotBlank(message = "name may not be blank")
    private String name;


    @Column(name = "code")
    @Schema(required = true, example = "区域编码")
    @NotBlank(message = "code may not be blank")
    private String code;
    /**
     * 便于项目中做映射关系
     */

    @Column(name = "biz_code")
    @Schema(required = true, example = "区域业务编码")
    private String bizCode;


    @Column(name = "type")
    @Schema(required = true, example = "区域类型(国家、省份直辖市、地市、区县)")
    @NotBlank(message = "type may not be blank")
    private String type;


    @Schema(required = true, example = "上级区域ID")
    @NotBlank(message = "parentId may not be blank")
    private String parent_id;


    @Column(name = "ids")
    @Schema(required = true, example = "区域ID序列,多个之间使用分隔符隔开")
    private String ids;


    @Column(name = "names")
    @Schema(required = true, example = "区域名称序列,多个之间使用分隔符隔开")
    @NotBlank(message = "names may not be blank")
    private String names;



    @Column(name = "codes")
    @Schema(required = true, example = "区域编码序列,多个之间使用分隔符隔开")
    @NotBlank(message = "codes may not be blank")
    private String codes;



    @Column(name = "biz_codes")
    @Schema(required = true, example = "区域业务编码序列,多个之间使用分隔符隔开")
    private String bizCodes;



    @Column(name = "has_children")
    @Schema(required = true, example = "是否有子节点（0： 没有; 非零：有）")
    private Integer hasChildren;



    @Column(name = "order_num")
    @Schema(required = true, example = "排序号")
    private Integer orderNum = 999;



    @Column(name = "remark")
    @Schema(required = true, example = "备注")
    private String remark;

    /**
     * 用户所属租户id
     */
    @Column(name = "tenant_id")
    @Schema(required = true, example = "所属租户ID")
    private String tenantId;

    /**
     * 用户所属机构id
     */
    @Column(name = "org_id")
    @Schema(required = true, example = "所属机构ID")
    private String orgId;


    @Column(name = "create_by")
    @Schema(required = true, example = "创建用户ID")
    private String createBy;



    @Column(name = "update_by")
    @Schema(required = true, example = "更新用户ID")
    private String updateBy;



    @Column(name = "del_flag")
    @Schema(required = true, example = "删除标识(0：正常，1：删除)")
    private Integer delFlag = 0;

}
