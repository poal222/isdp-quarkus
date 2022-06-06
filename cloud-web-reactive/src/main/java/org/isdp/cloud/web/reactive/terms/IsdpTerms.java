package org.isdp.cloud.web.reactive.terms;

import java.io.Serializable;

/**
 * 查询条件 封装
 *
 */
public class IsdpTerms implements Serializable {
    /**
     * 查询列名
     */
    private String column;
    /**
     * 查询类型
     */
    private TermsType type;
    /**
     * 值
     */
    private String value;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public TermsType getType() {
        return type;
    }

    public void setType(TermsType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IsdpTerms{" +
                "column='" + column + '\'' +
                ", type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
