package org.isdp.cloud.web.reactive.exception;

import org.isdp.cloud.core.result.ResultBuilder;
import org.isdp.cloud.web.reactive.web.IsdpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.bind.JsonbException;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Optional;

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
public class JsonbExceptionHandler implements ExceptionMapper<JsonbException> {

    Logger logger = LoggerFactory.getLogger(JsonbExceptionHandler.class);


    @Override
    public Response toResponse(JsonbException exception) {
        String message = exception.getMessage();

        logger.error("param validate error {}", message);

//        return Optional.ofNullable(exception)
//                .filter(t -> t instanceof JsonbException)
//                .map(JsonbException.class::cast)
//                .map(e -> IsdpResponse.error("400",e.getMessage()))
//                .get();

        return Response.status(400).entity(ResultBuilder.aResult()
                .withData(message)
                        .withSuccess(true)
                .withErrorCode("500")
                .withTraceId("1")
                .withErrorMessage("error")
                .withShowType("4")
                .build()).build();
    }
}
