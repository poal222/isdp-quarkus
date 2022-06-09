package org.isdp.cloud.eip.sass.organStru.pubStruView;

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
 * @desc : 机构视角
 */
 @Entity
 @Table(name="pub_stru_view")
 @Schema(name = "机构视角")
 @Data
 public class PubStruViewEntity extends BaseEntity {

     /** 视角编码 */
     @Schema( description = "视角编码" )
     @Column(name = "code")
     private String code ;
     /** 视角名称 */
     @Schema( description = "视角名称" )
     @Column(name = "name")
     private String name ;
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
     private String delFlag ;

 }