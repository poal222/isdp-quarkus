package org.isdp.cloud.core.result;

import java.io.Serializable;
import java.util.List;

/**
 * isdp-rest服务的分页结果统一封装
 */
public class PagerResult implements Serializable {
    /***
     * 分页结果集
     */
    private List list;
    /**
     * 当前页码，等同于index，记得要从0开始
     */
    private Integer current;
    /**
     * 每页大小
     */
    private Integer pageSize;
    /**
     * 总数
     */
    private Integer total;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public static final class PagerResultBuilder {
        private List list;
        private int current;
        private int pageSize;
        private int total;

        private PagerResultBuilder() {
        }

        public static PagerResultBuilder aPagerResult() {
            return new PagerResultBuilder();
        }

        public PagerResultBuilder withList(List list) {
            this.list = list;
            return this;
        }

        public PagerResultBuilder withCurrent(Integer current) {
            this.current = current;
            return this;
        }

        public PagerResultBuilder withPageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public PagerResultBuilder withTotal(Integer total) {
            this.total = total;
            return this;
        }

        public PagerResult build() {
            PagerResult pagerResult = new PagerResult();
            pagerResult.current = this.current;
            pagerResult.list = this.list;
            pagerResult.pageSize = this.pageSize;
            pagerResult.total = this.total;
            return pagerResult;
        }
    }
}
