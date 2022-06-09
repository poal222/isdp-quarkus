package org.isdp.cloud.eip.sass.users;

import javax.persistence.*;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.sql.Timestamp;
import java.lang.Integer;

@Entity
@Table(name = "pub_user")
@Data
@Schema(name = "用户表")
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
}