package org.isdp.cloud.eip.sass.pubconfig;

import javax.persistence.*;

import io.smallrye.mutiny.Uni;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.sql.Timestamp;

import lombok.Data;
import org.isdp.cloud.web.reactive.base.BaseEntity;

/**
 * @author : http://www.chiner.pro
 * @date : 2022-6-7
 * @desc : 参数配置表
 */
import java.util.List;

/**
 * @author : http://www.chiner.pro
 * @date : 2022-6-8
 * @desc : 参数配置表
 */
@Entity
@Table(name="pub_config")
@Schema(name = "参数配置表")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PubConfig extends BaseEntity {

    /** 参数建名 */
    @Schema( description = "参数建名" )
    @Column(name = "config_key")
    private String configKey ;
    /** 参数键值 */
    @Schema( description = "参数键值" )
    @Column(name = "config_value")
    private String configValue ;
    /** 是否系统内置0:是;1:否 */
    @Schema( description = "是否系统内置0:是" )
    @Column(name = "is_sys")
    private Boolean isSys ;
    /** 备注 */
    @Schema( description = "备注" )
    @Column(name = "remark")
    private String remark ;
    /** 租户id */
    @Schema( description = "租户id" )
    @Column(name = "tenant_id")
    private String tenantId ;
    /** 机构id */
    @Schema( description = "机构id" )
    @Column(name = "org_id")
    private String orgId ;
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