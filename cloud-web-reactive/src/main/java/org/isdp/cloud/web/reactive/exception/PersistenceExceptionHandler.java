package org.isdp.cloud.web.reactive.exception;

import org.isdp.cloud.core.result.ResultBuilder;
import org.isdp.cloud.web.reactive.web.IsdpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.PersistenceException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;

/**
 * 参数校验异常 统一封装
 * {
 * "success": true,
 * "data": {},
 * "errorCode": "1001",
 * "errorMessage": "error message",
 * "showType": 2,
 * "traceId": "someid",
 * "host": "10.1.1.1"
 * }
 */
@Provider
public class PersistenceExceptionHandler implements ExceptionMapper<PersistenceException> {

    Logger logger = LoggerFactory.getLogger(PersistenceExceptionHandler.class);


    @Override
    public Response toResponse(PersistenceException exception) {
        String message = exception.getMessage();

        logger.error("param validate error {}", message);

//        HashMap<String, Object> result = new HashMap<>();
//        result.put("success", true);
//        result.put("errorCode", 500);
//        result.put("errorMessage", "参数校验失败");
//        result.put("data", message);


        return Response.status(400).entity(IsdpResponse.error("400",message)).build();
    }
}
