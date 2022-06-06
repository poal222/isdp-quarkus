package org.isdp.cloud.web.reactive.base;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@MappedSuperclass
public class BaseEntity  {

    public BaseEntity() {
    }
    @Id
    @GeneratedValue
    public String id;
    /**
     * 创建时间
     */
    @Column(name = "create_date",updatable = false)
    @CreationTimestamp
    public Timestamp CreateDate;

    /**
     * 修改时间
     */
    @Column(name = "update_date",updatable = true)
    @CreationTimestamp
    public Timestamp UpdateDate;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "<" + id + ">";
    }
}
