package org.isdp.cloud.eip.sass.permit.authentication;

import io.quarkus.logging.Log;
import org.isdp.cloud.eip.sass.permit.authentication.config.IsdpAuthConfig;
import org.isdp.cloud.eip.sass.permit.authentication.constant.CaptchaMnum;
import org.isdp.cloud.eip.sass.permit.authentication.event.BeforeAuthenticEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * 验证码消费者
 */
@ApplicationScoped
public class DigitalCodeCounsumer {

    @Inject
    IsdpAuthConfig isdpAuthConfig;

    public void consumer(@Observes @BeforeAuthentic BeforeAuthenticEvent beforeAuthenticEvent){
        if (isdpAuthConfig.captcha().enable()){
            // 数字验证码
            if(CaptchaMnum.Digtail.name().equals(isdpAuthConfig.captcha().type())){
                Log.infov("beforeAuthenticEvent Digtail consumer is {0}",beforeAuthenticEvent.getXcode());
            }
            // 手机验证码
            if(CaptchaMnum.Mobile.name().equals(isdpAuthConfig.captcha().type())){
                Log.infov("beforeAuthenticEvent Mobile consumer is {0}",beforeAuthenticEvent.getXcode());
            }

        }else{
            Log.infov("not excute beforeAuthenticEvent consumer ");
        }

    }

}
