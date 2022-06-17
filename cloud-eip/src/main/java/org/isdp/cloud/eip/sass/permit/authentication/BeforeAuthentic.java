package org.isdp.cloud.eip.sass.permit.authentication;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 认证前事件
 * 例如：验证码校验等
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD,ElementType.TYPE})
public @interface BeforeAuthentic {
}
