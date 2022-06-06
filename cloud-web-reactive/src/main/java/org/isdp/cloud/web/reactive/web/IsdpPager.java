package org.isdp.cloud.web.reactive.web;

import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * 统一接口规范
 */
@Data
@Builder
public class IsdpPager{

    private List list;

    private Long current;

    private Long pageSize;

    private Long total;


}