package org.isdp.cloud.eip.sass.dict.entity;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author : http://www.chiner.pro
 * @date : 2022-1-24
 * @desc : 数据字典表
 */
@Table(name = "SYS_DICT")
@Entity
@Schema(name = "系统字典")
public class SysDict implements Serializable, Cloneable {
    /**
     * 字典key
     */
    @Id
    @Column(name = "KEY_")
    @Schema(required = true, example = "32126319")
    @NotBlank(message = "key may not be blank")
    private String key_;
    /**
     * 字典名称
     */
    @Column(name = "LABEL")
    @Schema(required = true, example = "年龄")
    @NotBlank(message = "label may not be blank")
    private String label;
    /**
     * 字典描述
     */
    @Column(name = "INTRO")
    @Schema(required = true, example = "字典描述")
    private String intro;
    /**
     * 是否启用
     */
    @Column(name = "REVISION", columnDefinition = "1")
    @Schema(required = true, example = "1")
    @NotBlank(message = "revision may not be blank")
    private String revision;

    /**
     * 字典key
     */
    public String getKey_() {
        return this.key_;
    }

    /**
     * 字典key
     */
    public void setKey_(String key_) {
        this.key_ = key_;
    }

    /**
     * 字典名称
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * 字典名称
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 字典描述
     */
    public String getIntro() {
        return this.intro;
    }

    /**
     * 字典描述
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * 是否启用
     */
    public String getRevision() {
        return this.revision;
    }

    /**
     * 是否启用
     */
    public void setRevision(String revision) {
        this.revision = revision;
    }
}