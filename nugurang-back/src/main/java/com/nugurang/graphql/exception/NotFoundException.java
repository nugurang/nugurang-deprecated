package com.nugurang.graphql.exception;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.NonNull;

public class NotFoundException extends RuntimeException implements GraphQLError {

    @NonNull
    private String objectName;

    @Builder
    public NotFoundException(@NonNull String message, String objectName) {
        super(message);
        this.objectName = objectName;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("object", objectName);
    }
}
