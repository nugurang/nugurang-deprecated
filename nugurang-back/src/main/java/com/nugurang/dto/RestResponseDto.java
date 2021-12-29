package com.nugurang.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponseDto {
    private Optional<Object> data;
    private Optional<List<Error>> errors;
    private Optional<Object> extensions;

    @Data
    @AllArgsConstructor
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Error {
        private String message;
        private List<Location> locations;
        private List<String> path;
        private Optional<Object> extensions;

        @Data
        @AllArgsConstructor
        @Builder
        public static class Location {
            private Long line;
            private Long column;
        }

        @Data
        @AllArgsConstructor
        @Builder
        public static class ErrorExtension {
            private String type;
        }
    }
}
