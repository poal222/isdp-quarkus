package org.isdp.cloud.core.result;

public final class ResultBuilder {
    private boolean success;
    private Object data;
    private String errorCode;
    private String errorMessage;
    private String showType;
    private String traceId;
    private String host;

    private ResultBuilder() {
    }

    public static ResultBuilder aResult() {
        return new ResultBuilder();
    }

    public ResultBuilder withSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public ResultBuilder withData(Object data) {
        this.data = data;
        return this;
    }

    public ResultBuilder withErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public ResultBuilder withErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public ResultBuilder withShowType(String showType) {
        this.showType = showType;
        return this;
    }

    public ResultBuilder withTraceId(String traceId) {
        this.traceId = traceId;
        return this;
    }

    public ResultBuilder withHost(String host) {
        this.host = host;
        return this;
    }

    public Result build() {
        Result result = new Result();
        result.setSuccess(success);
        result.setData(data);
        result.setErrorCode(errorCode);
        result.setErrorMessage(errorMessage);
        result.setShowType(showType);
        result.setTraceId(traceId);
        result.setHost(host);
        return result;
    }
}
