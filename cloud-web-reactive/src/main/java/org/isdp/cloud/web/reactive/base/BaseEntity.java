package org.isdp.cloud.web.reactive.base;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@MappedSuperclass
public class BaseEntity  {

    public BaseEntity() {
    }
    @Id
    public String id;
    /**
     * 创建时间
     */
    @Column(name = "create_date")
    @CreationTimestamp
    public LocalDateTime  CreateDate;

    /**
     * 修改时间
     */
    @Column(name = "update_date")
    @UpdateTimestamp
    public LocalDateTime UpdateDate;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "<" + id + ">";
    }
}
