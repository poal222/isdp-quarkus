package org.isdp.cloud.eip.sass.PubLog;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

/**
 * @author : http://www.chiner.pro
 * @date : 2022-6-13
 * @desc : 系统日志表
 */
@Entity
@Table(name="pub_log")
@Schema(name = "系统日志表")
@Data
public class PubLogEntity {
    /** 系统日志id */
    @Id
    @Schema( description = "系统日志id" )
    @Column(name = "id")
    private String id ;
    /** 日志类型;1:新增2:删除3:更新4:查询5:上传文件6:下载文件7:用户导入8:用户导出9:登录10:登出11:其他 */
    @Schema( description = "日志类型" )
    @Column(name = "type")
    private Integer type ;
    /** 日志状态;1:失败,2:成功 */
    @Schema( description = "日志状态" )
    @Column(name = "state")
    private Integer state ;
    /** 用户名 */
    @Schema( description = "用户名" )
    @Column(name = "username")
    private String username ;
    /** 真实姓名 */
    @Schema( description = "真实姓名" )
    @Column(name = "real_name")
    private String realName ;
    /** 模块名 */
    @Schema( description = "模块名" )
    @Column(name = "module")
    private String module ;
    /** 操作 */
    @Schema( description = "操作" )
    @Column(name = "operation")
    private String operation ;
    /** 调用方法 */
    @Schema( description = "调用方法" )
    @Column(name = "method")
    private String method ;
    /** 客户端IP */
    @Schema( description = "客户端IP" )
    @Column(name = "client_ip")
    private String clientIp ;
    /** 设备名称 */
    @Schema( description = "设备名称" )
    @Column(name = "device_name")
    private String deviceName ;
    /** 浏览器名称 */
    @Schema( description = "浏览器名称" )
    @Column(name = "browser_name")
    private String browserName ;
    /** 用户代理 */
    @Schema( description = "用户代理" )
    @Column(name = "user_agent")
    private String userAgent ;
    /** 请求地址 */
    @Schema( description = "请求地址" )
    @Column(name = "request_uri")
    private String requestUri ;
    /** 请求方法 */
    @Schema( description = "请求方法" )
    @Column(name = "request_method")
    private String requestMethod ;
    /** 异常信息 */
    @Schema( description = "异常信息" )
    @Column(name = "exception")
    private String exception ;
    /** 查询条件 */
    @Schema( description = "查询条件" )
    @Column(name = "query_string")
    private String queryString ;
    /** 请求参数 */
    @Schema( description = "请求参数" )
    @Column(name = "params")
    private String params ;
    /** 耗时 */
    @Schema( description = "耗时" )
    @Column(name = "elapsed_time")
    private String elapsedTime ;
    /** 租户id */
    @Schema( description = "租户id" )
    @Column(name = "tenant_id")
    private String tenantId ;
    /** 机构ID */
    @Schema( description = "机构ID" )
    @Column(name = "org_id")
    private String orgId ;
    /** 创建者 */
    @Schema( description = "创建者" )
    @Column(name = "create_by")
    private String createBy ;
    /** 创建时间 */
    @Schema( description = "创建时间" )
    @Column(name = "create_date")
    @CreationTimestamp
    private Timestamp createDate ;

}