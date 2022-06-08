package org.isdp.cloud.eip.sass.tenant;




import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="pub_tenant")
@Schema(name = "租户表")
public class PubTenantEntity {
    /** 主键 */
    @Id
    @GeneratedValue
    @Column(name = "id")
    @Schema(description = "id")
    private String id ;
    /** 是否默认租户1:是;0:否 */
    @Column(name = "default_tenant")
    private Boolean defaultTenant ;
    /** 租户名称 */
    @Column(name = "name")
    private String name ;
    /** 备注 */
    @Column(name = "remark")
    private String remark ;
    /** 创建者 */
    @Column(name = "create_by")
    private String createBy ;
    /** 创建时间 */
    @Column(name = "create_date")
    private Date createDate ;
    /** 更新者 */
    @Column(name = "update_by")
    private String updateBy ;
    /** 更新时间 */
    @Column(name = "update_date")
    private Date updateDate ;
    /** 删除标记0:保留;1:删除 */
    @Column(name = "del_flag")
    private int delFlag ;
    /** 租户编码 */
    @Column(name = "code")
    private String code ;
    /** 状态（0：禁用;1：正常） */
    @Column(name = "status")
    private int status ;

    /** 主键 */
    public String getId(){
        return this.id;
    }
    /** 主键 */
    public void setId(String id){
        this.id=id;
    }
    /** 是否默认租户1:是;0:否 */
    public boolean getDefaultTenant(){
        return this.defaultTenant;
    }
    /** 是否默认租户1:是;0:否 */
    public void setDefaultTenant(boolean defaultTenant){
        this.defaultTenant=defaultTenant;
    }
    /** 租户名称 */
    public String getName(){
        return this.name;
    }
    /** 租户名称 */
    public void setName(String name){
        this.name=name;
    }
    /** 备注 */
    public String getRemark(){
        return this.remark;
    }
    /** 备注 */
    public void setRemark(String remark){
        this.remark=remark;
    }
    /** 创建者 */
    public String getCreateBy(){
        return this.createBy;
    }
    /** 创建者 */
    public void setCreateBy(String createBy){
        this.createBy=createBy;
    }
    /** 创建时间 */
    public Date getCreateDate(){
        return this.createDate;
    }
    /** 创建时间 */
    public void setCreateDate(Date createDate){
        this.createDate=createDate;
    }
    /** 更新者 */
    public String getUpdateBy(){
        return this.updateBy;
    }
    /** 更新者 */
    public void setUpdateBy(String updateBy){
        this.updateBy=updateBy;
    }
    /** 更新时间 */
    public Date getUpdateDate(){
        return this.updateDate;
    }
    /** 更新时间 */
    public void setUpdateDate(Date updateDate){
        this.updateDate=updateDate;
    }
    /** 删除标记0:保留;1:删除 */
    public int getDelFlag(){
        return this.delFlag;
    }
    /** 删除标记0:保留;1:删除 */
    public void setDelFlag(int delFlag){
        this.delFlag=delFlag;
    }
    /** 租户编码 */
    public String getCode(){
        return this.code;
    }
    /** 租户编码 */
    public void setCode(String code){
        this.code=code;
    }
    /** 状态（0：禁用;1：正常） */
    public int getStatus(){
        return this.status;
    }
    /** 状态（0：禁用;1：正常） */
    public void setStatus(int status){
        this.status=status;
    }
}