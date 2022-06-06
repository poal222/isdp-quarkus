package org.isdp.cloud.web.reactive.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 
 * 定义了一套接口格式和错误处理的规范，当失败时会统一提示错误，代码只需要考虑成功即可
 * success: boolean; // if request is success
 * data?: any; // response data
 * errorCode?: string; // code for errorType
 * errorMessage?: string; // message display to user
 * showType?: number; // error display type： 0 silent; 1 message.warn; 2
 * message.error; 4 notification; 9 page
 * traceId?: string; // Convenient for back-end Troubleshooting: unique request
 * ID
 * host?: string; // onvenient for backend Troubleshooting: host of current
 * access server
 * 
 * eg:
 * {
 * "success": true,
 * "data": {},
 * "errorCode": "1001",
 * "errorMessage": "error message",
 * "showType": 2,
 * "traceId": "someid",
 * "host": "10.1.1.1"
 * }
 *
 */

@Data
@Builder
@AllArgsConstructor
public class IsdpResponse {

    private Boolean success;
    private Object data;
    private String errorCode;
    private String errorMessage;
    private int showType;
    private String traceId;
    private String host;
    /**
     * 成功
     * @param data
     * @return
     */
    public static IsdpResponse OK(Object data) {
        return  builder().success(true).data(data).host("001").showType(2).traceId("someid").build();

    }
    /**
     * 错误
     * @param errorCode
     * @param errorMessage
     * @return
     */
    public static IsdpResponse error(String errorCode,String errorMessage) {
        return  builder().success(false).errorCode(errorCode).errorMessage(errorMessage).host("001").showType(2).traceId("someid").build();

    }
}
