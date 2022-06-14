package org.isdp.cloud.eip.sass.logging;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 元注释用于为过滤器和拦截器创建名称绑定注释。
 * 通过@NameBinding修饰的复合注解，只能在服务端代码中使用
 *
 * 日志注解，实现对操作日志的动态记录
 */
  @Target({ ElementType.TYPE, ElementType.METHOD })
  @Retention(value = RetentionPolicy.RUNTIME)
@NameBinding
public @interface Logged {
}
