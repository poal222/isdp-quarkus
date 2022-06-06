package org.isdp.cloud.core.result;

import java.io.Serializable;

/**
 * isdp框架包装结果集
 * success: boolean; // if request is success
 *   data?: any; // response data
 *   errorCode?: string; // code for errorType
 *   errorMessage?: string; // message display to user
 *   showType?: number; // error display type： 0 silent; 1 message.warn; 2 message.error; 4 notification; 9 page
 *   traceId?: string; // Convenient for back-end Troubleshooting: unique request ID
 *   host?: string; // onvenient for backend Troubleshooting: host of current access server
 */
public  class Result implements Serializable {
//
//    HashMap<String, Object> result = new HashMap<>();
//        result.put("success", true);
//        result.put("errorCode", 400);
//        result.put("errorMessage", "参数校验失败");
//        result.put("data", message);
    private boolean success;
    private Object data;
    private String errorCode;
    private String errorMessage;
    private String showType;
    private String traceId;
    private String host;






    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }


}
