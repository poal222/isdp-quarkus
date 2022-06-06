package org.isdp.cloud.eip.sass.dict.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author : http://www.chiner.pro
 * @date : 2022-1-24
 * @desc : 数据字典表-字典项
 */
@Table(name = "SYS_DICT_ITEM")
@Entity
public class SysDictItem implements Serializable, Cloneable {
    /**
     * 字典key
     */
    @Id
    @Column(name = "DICT_KEY")
    private String dictKey;
    /**
     * 字典项key
     */
    @Column(name = "KEY_")
    private String key_;
    /**
     * 字典名称
     */
    @Column(name = "LABEL")
    private String label;
    /**
     * 排序
     */
    @Column(name = "SORT_")
    private Integer sort_;
    /**
     * 字典描述
     */
    @Column(name = "INTRO")
    private String intro;
    /**
     * 是否启用
     */
    @Column(name = "REVISION")
    private String revision;

    /**
     * 字典key
     */
    public String getDictKey() {
        return this.dictKey;
    }

    /**
     * 字典key
     */
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    /**
     * 字典项key
     */
    public String getKey_() {
        return this.key_;
    }

    /**
     * 字典项key
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
     * 排序
     */
    public Integer getSort_() {
        return this.sort_;
    }

    /**
     * 排序
     */
    public void setSort_(Integer sort_) {
        this.sort_ = sort_;
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