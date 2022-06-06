package org.isdp.cloud.web.reactive.terms;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询 请求包装器
 */
@Schema(name = "区域")
public class PagerTerms implements Serializable {

    @Schema(required = true, example = "每页数量，默认是10",defaultValue = "10")
    private int size = 10;
    @Schema(required = true, example = "页码索引，默认是1",defaultValue = "1")
    private int index = 1;

    //查询条件
    @Schema(required = false, example = "动态查询条件")
    private List<IsdpTerms> termsList;

    public List<IsdpTerms> getTermsList() {
        return termsList;
    }

    public void setTermsList(List<IsdpTerms> termsList) {
        this.termsList = termsList;
    }
    //    public  IsdpSort sort ;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }



//    public IsdpSort getSort() {
//        return sort;
//    }
//
//    public void setSort(IsdpSort sort) {
//        this.sort = sort;
//    }
}
