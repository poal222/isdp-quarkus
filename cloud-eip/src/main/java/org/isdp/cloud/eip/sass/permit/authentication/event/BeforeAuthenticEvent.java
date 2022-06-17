package org.isdp.cloud.eip.sass.permit.authentication.event;

public class BeforeAuthenticEvent {
    /**
     * 校验类型
     * 默认是验证码码校验
     * Digital：验证码
     */
    private String xcode;

    public String getXcode() {
        return xcode;
    }

    public BeforeAuthenticEvent(String xcode) {
        this.xcode = xcode;
    }

    public void checkXcode(String xcodeinfo){
        System.out.println(xcodeinfo);
    }
}
