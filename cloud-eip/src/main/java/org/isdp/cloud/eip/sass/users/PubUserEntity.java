package org.isdp.cloud.eip.sass.users;

import javax.persistence.*;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import lombok.Data;

import java.sql.Timestamp;
import java.lang.Integer;

@Entity
@Table(name = "pub_user")
@Data
public class PubUserEntity {
    /** 主键 */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private String id;
    /** 密码过期时间 */
    @Column(name = "pwd_expire_date")
    private Timestamp pwdExpireDate;
    /** 工作单位 */
    @Column(name = "company")

    private String company;
    /** 工作职责 */
    @Column(name = "responsibility")
    private String responsibility;
    /** 地址 */
    @Column(name = "address")
    private String address;
    /** 工号 */
    @Column(name = "job_number")
    private String jobNumber;
    /** 账号 */
    @Column(name = "username")
    private String username;
    /** 密码 */
    @Column(name = "password")
    private String password;
    /** 真实姓名 */
    @Column(name = "real_name")
    private String realName;
    /** 身份证号 */
    @Column(name = "id_card")
    private String idCard;
    /** 昵称 */
    @Column(name = "nickname")
    private String nickname;
    /** 头像存储路径 */
    @Column(name = "avatar")
    private String avatar;
    /** 性别0:女性;1:男性 */
    @Column(name = "gender")
    private Integer gender;
    /** 邮箱 */
    @Column(name = "email")
    private String email;
    /** 联系手机/电话号 */
    @Column(name = "phone")
    private String phone;
    /** QQ号 */
    @Column(name = "qq")
    private String qq;
    /** 微信号 */
    @Column(name = "wx")
    private String wx;
    /** 状态;1:正常，0:禁用 */
    @Column(name = "status")
    private Integer status;
    /** 权重;权重值越大排名越靠前 */
    @Column(name = "weight")
    private Integer weight;
    /** 办公电话 */
    @Column(name = "office_tel")
    private String officeTel;
    /** 最后密码修改时间 */
    @Column(name = "last_pwd_update_date")
    private Timestamp lastPwdUpdateDate;
    /** 最后登录时间 */
    @Column(name = "last_login_date")
    private Timestamp lastLoginDate;
    /** 最后登录ip */
    @Column(name = "last_login_ip")
    private String lastLoginIp;
    /** 归属公司id */
    @Column(name = "company_id")
    private String companyId;
    /** 账号是否已修改;默认已修改，手机和邮箱注册时为未修改。1已修改，0未修改 */
    @Column(name = "username_updated")
    private Integer usernameUpdated;
    /** 机构id */
    @Column(name = "org_id")
    private String orgId;
    /** 租户id */
    @Column(name = "tenant_id")
    private String tenantId;
    /** 创建者 */
    @Column(name = "create_by")
    private String createBy;
    /** 创建时间 */
    @Column(name = "create_date")
    private Timestamp createDate;
    /** 更新者 */
    @Column(name = "update_by")
    private String updateBy;
    /** 更新时间 */
    @Column(name = "update_date")
    private Timestamp updateDate;
    /** 删除标记0:保留;1:删除 */
    @Column(name = "del_flag")
    private Integer delFlag;
    /** 预留字段1 */
    @Column(name = "extend_s1")
    private String extendS1;
    /** 预留字段2 */
    @Column(name = "extend_s2")
    private String extendS2;
    /** 预留字段3 */
    @Column(name = "extend_s3")
    private String extendS3;
    /** 预留字段;存入json格式 */
    @Column(name = "extend_obj")
    private String extendObj;

    // /** 主键 */
    // public String getId(){
    // return this.id;
    // }
    // /** 主键 */
    // public void setId(String id){
    // this.id=id;
    // }
    // /** 密码过期时间 */
    // public Timestamp getPwdExpireDate(){
    // return this.pwdExpireDate;
    // }
    // /** 密码过期时间 */
    // public void setPwdExpireDate(Timestamp pwdExpireDate){
    // this.pwdExpireDate=pwdExpireDate;
    // }
    // /** 工作单位 */
    // public String getCompany(){
    // return this.company;
    // }
    // /** 工作单位 */
    // public void setCompany(String company){
    // this.company=company;
    // }
    // /** 工作职责 */
    // public String getResponsibility(){
    // return this.responsibility;
    // }
    // /** 工作职责 */
    // public void setResponsibility(String responsibility){
    // this.responsibility=responsibility;
    // }
    // /** 地址 */
    // public String getAddress(){
    // return this.address;
    // }
    // /** 地址 */
    // public void setAddress(String address){
    // this.address=address;
    // }
    // /** 工号 */
    // public String getJobNumber(){
    // return this.jobNumber;
    // }
    // /** 工号 */
    // public void setJobNumber(String jobNumber){
    // this.jobNumber=jobNumber;
    // }
    // /** 账号 */
    // public String getUsername(){
    // return this.username;
    // }
    // /** 账号 */
    // public void setUsername(String username){
    // this.username=username;
    // }
    // /** 密码 */
    // public String getPassword(){
    // return this.password;
    // }
    // /** 密码 */
    // public void setPassword(String password){
    // this.password=password;
    // }
    // /** 真实姓名 */
    // public String getRealName(){
    // return this.realName;
    // }
    // /** 真实姓名 */
    // public void setRealName(String realName){
    // this.realName=realName;
    // }
    // /** 身份证号 */
    // public String getIdCard(){
    // return this.idCard;
    // }
    // /** 身份证号 */
    // public void setIdCard(String idCard){
    // this.idCard=idCard;
    // }
    // /** 昵称 */
    // public String getNickname(){
    // return this.nickname;
    // }
    // /** 昵称 */
    // public void setNickname(String nickname){
    // this.nickname=nickname;
    // }
    // /** 头像存储路径 */
    // public String getAvatar(){
    // return this.avatar;
    // }
    // /** 头像存储路径 */
    // public void setAvatar(String avatar){
    // this.avatar=avatar;
    // }
    // /** 性别0:女性;1:男性 */
    // public Integer getGender(){
    // return this.gender;
    // }
    // /** 性别0:女性;1:男性 */
    // public void setGender(Integer gender){
    // this.gender=gender;
    // }
    // /** 邮箱 */
    // public String getEmail(){
    // return this.email;
    // }
    // /** 邮箱 */
    // public void setEmail(String email){
    // this.email=email;
    // }
    // /** 联系手机/电话号 */
    // public String getPhone(){
    // return this.phone;
    // }
    // /** 联系手机/电话号 */
    // public void setPhone(String phone){
    // this.phone=phone;
    // }
    // /** QQ号 */
    // public String getQq(){
    // return this.qq;
    // }
    // /** QQ号 */
    // public void setQq(String qq){
    // this.qq=qq;
    // }
    // /** 微信号 */
    // public String getWx(){
    // return this.wx;
    // }
    // /** 微信号 */
    // public void setWx(String wx){
    // this.wx=wx;
    // }
    // /** 状态;1:正常，0:禁用 */
    // public Integer getStatus(){
    // return this.status;
    // }
    // /** 状态;1:正常，0:禁用 */
    // public void setStatus(Integer status){
    // this.status=status;
    // }
    // /** 权重;权重值越大排名越靠前 */
    // public Integer getWeight(){
    // return this.weight;
    // }
    // /** 权重;权重值越大排名越靠前 */
    // public void setWeight(Integer weight){
    // this.weight=weight;
    // }
    // /** 办公电话 */
    // public String getOfficeTel(){
    // return this.officeTel;
    // }
    // /** 办公电话 */
    // public void setOfficeTel(String officeTel){
    // this.officeTel=officeTel;
    // }
    // /** 最后密码修改时间 */
    // public Timestamp getLastPwdUpdateDate(){
    // return this.lastPwdUpdateDate;
    // }
    // /** 最后密码修改时间 */
    // public void setLastPwdUpdateDate(Timestamp lastPwdUpdateDate){
    // this.lastPwdUpdateDate=lastPwdUpdateDate;
    // }
    // /** 最后登录时间 */
    // public Timestamp getLastLoginDate(){
    // return this.lastLoginDate;
    // }
    // /** 最后登录时间 */
    // public void setLastLoginDate(Timestamp lastLoginDate){
    // this.lastLoginDate=lastLoginDate;
    // }
    // /** 最后登录ip */
    // public String getLastLoginIp(){
    // return this.lastLoginIp;
    // }
    // /** 最后登录ip */
    // public void setLastLoginIp(String lastLoginIp){
    // this.lastLoginIp=lastLoginIp;
    // }
    // /** 归属公司id */
    // public String getCompanyId(){
    // return this.companyId;
    // }
    // /** 归属公司id */
    // public void setCompanyId(String companyId){
    // this.companyId=companyId;
    // }
    // /** 账号是否已修改;默认已修改，手机和邮箱注册时为未修改。1已修改，0未修改 */
    // public Integer getUsernameUpdated(){
    // return this.usernameUpdated;
    // }
    // /** 账号是否已修改;默认已修改，手机和邮箱注册时为未修改。1已修改，0未修改 */
    // public void setUsernameUpdated(Integer usernameUpdated){
    // this.usernameUpdated=usernameUpdated;
    // }
    // /** 机构id */
    // public String getOrgId(){
    // return this.orgId;
    // }
    // /** 机构id */
    // public void setOrgId(String orgId){
    // this.orgId=orgId;
    // }
    // /** 租户id */
    // public String getTenantId(){
    // return this.tenantId;
    // }
    // /** 租户id */
    // public void setTenantId(String tenantId){
    // this.tenantId=tenantId;
    // }
    // /** 创建者 */
    // public String getCreateBy(){
    // return this.createBy;
    // }
    // /** 创建者 */
    // public void setCreateBy(String createBy){
    // this.createBy=createBy;
    // }
    // /** 创建时间 */
    // public Timestamp getCreateDate(){
    // return this.createDate;
    // }
    // /** 创建时间 */
    // public void setCreateDate(Timestamp createDate){
    // this.createDate=createDate;
    // }
    // /** 更新者 */
    // public String getUpdateBy(){
    // return this.updateBy;
    // }
    // /** 更新者 */
    // public void setUpdateBy(String updateBy){
    // this.updateBy=updateBy;
    // }
    // /** 更新时间 */
    // public Timestamp getUpdateDate(){
    // return this.updateDate;
    // }
    // /** 更新时间 */
    // public void setUpdateDate(Timestamp updateDate){
    // this.updateDate=updateDate;
    // }
    // /** 删除标记0:保留;1:删除 */
    // public Integer getDelFlag(){
    // return this.delFlag;
    // }
    // /** 删除标记0:保留;1:删除 */
    // public void setDelFlag(Integer delFlag){
    // this.delFlag=delFlag;
    // }
    // /** 预留字段1 */
    // public String getExtendS1(){
    // return this.extendS1;
    // }
    // /** 预留字段1 */
    // public void setExtendS1(String extendS1){
    // this.extendS1=extendS1;
    // }
    // /** 预留字段2 */
    // public String getExtendS2(){
    // return this.extendS2;
    // }
    // /** 预留字段2 */
    // public void setExtendS2(String extendS2){
    // this.extendS2=extendS2;
    // }
    // /** 预留字段3 */
    // public String getExtendS3(){
    // return this.extendS3;
    // }
    // /** 预留字段3 */
    // public void setExtendS3(String extendS3){
    // this.extendS3=extendS3;
    // }
    // /** 预留字段;存入json格式 */
    // public String getExtendObj(){
    // return this.extendObj;
    // }
    // /** 预留字段;存入json格式 */
    // public void setExtendObj(String extendObj){
    // this.extendObj=extendObj;
    // }
}