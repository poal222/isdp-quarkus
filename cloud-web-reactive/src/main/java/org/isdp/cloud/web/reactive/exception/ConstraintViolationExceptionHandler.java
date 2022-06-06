package org.isdp.cloud.web.reactive.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.isdp.cloud.core.result.ResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {

    Logger logger = LoggerFactory.getLogger(ConstraintViolationExceptionHandler.class);


    @Override
    public Response toResponse(ConstraintViolationException exception) {
        String message = exception.getMessage();

        logger.error("param validate error {}", message);

        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("errorCode", 400);
        result.put("errorMessage", "参数校验失败");
        result.put("data", message);


        return Response.status(400).entity(ResultBuilder.aResult()
                .withData(message)
                        .withSuccess(true)
                .withErrorCode("400")
                .withTraceId("1")
                .withErrorMessage("参数校验失败")
                .withShowType("4")
                .build()).build();
    }
}
