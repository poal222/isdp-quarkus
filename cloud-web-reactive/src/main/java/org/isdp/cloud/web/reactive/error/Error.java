package org.isdp.cloud.web.reactive.error;

import io.smallrye.common.constraint.NotNull;

/**
 * 错误信息bean
 */
public class Error {

    

    @NotNull private int code;
    @NotNull private String message;
    @NotNull private String description;
    
    public Error() {
    }
    public Error(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


}
