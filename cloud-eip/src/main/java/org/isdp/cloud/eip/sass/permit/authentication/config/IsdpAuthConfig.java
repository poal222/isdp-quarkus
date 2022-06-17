package org.isdp.cloud.eip.sass.permit.authentication.config;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;


@StaticInitSafe
@ConfigMapping(prefix = "isdp.authentication")
public interface IsdpAuthConfig {

//    验证码策略
    Captcha captcha();


    interface   Captcha{
        //类型
    String type();
        // 有效市场
    String ttl();
    // 开关
    Boolean enable();
    }



}
