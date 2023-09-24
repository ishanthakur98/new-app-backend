package com.news.feed.Domain;

public class NewsFeedException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String errorCode;

    private String errorDescription;

    private String errorSource = "News feed ";

    private String requestUrl;

    private Object requestObject;

    private String method;

    public NewsFeedException(String errorCode, String errorDescription, String errorSource, String requestUrl, Object requestObject, String method) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.errorSource = errorSource;
        this.requestUrl = requestUrl;
        this.requestObject = requestObject;
        this.method = method;
    }

    public NewsFeedException(String message, String errorCode, String errorDescription, String errorSource, String requestUrl, Object requestObject, String method) {
        super(message);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.errorSource = errorSource;
        this.requestUrl = requestUrl;
        this.requestObject = requestObject;
        this.method = method;
    }

    public NewsFeedException(String message, Throwable cause, String errorCode, String errorDescription, String errorSource, String requestUrl, Object requestObject, String method) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.errorSource = errorSource;
        this.requestUrl = requestUrl;
        this.requestObject = requestObject;
        this.method = method;
    }

    public NewsFeedException(Throwable cause, String errorCode, String errorDescription, String errorSource, String requestUrl, Object requestObject, String method) {
        super(cause);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.errorSource = errorSource;
        this.requestUrl = requestUrl;
        this.requestObject = requestObject;
        this.method = method;
    }

    public NewsFeedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode, String errorDescription, String errorSource, String requestUrl, Object requestObject, String method) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.errorSource = errorSource;
        this.requestUrl = requestUrl;
        this.requestObject = requestObject;
        this.method = method;
    }
    public NewsFeedException(String errorCode ,String errorDescription) {
        super();
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;

    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorSource() {
        return errorSource;
    }

    public void setErrorSource(String errorSource) {
        this.errorSource = errorSource;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Object getRequestObject() {
        return requestObject;
    }

    public void setRequestObject(Object requestObject) {
        this.requestObject = requestObject;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
