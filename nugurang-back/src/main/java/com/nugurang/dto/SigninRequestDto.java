package com.nugurang.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.Map;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
public class SigninRequestDto {

    @Data
    public static class AccessToken {
        private String tokenValue;
        private Instant issuedAt;
        private Instant expiresAt;
        private Set<String> scopes;

        @Builder
        @JsonCreator
        public AccessToken(
            @JsonProperty(required = true)
            String tokenValue,
            @JsonProperty(required = true)
            Instant issuedAt,
            @JsonProperty(required = true)
            Instant expiresAt,
            @JsonProperty(required = true)
            Set<String> scopes
        ) {
            this.tokenValue = tokenValue;
            this.issuedAt = issuedAt;
            this.expiresAt = expiresAt;
            this.scopes = scopes;
        }
    }

    @Data
    public static class RefreshToken {
        private String tokenValue;
        private Instant issuedAt;
        private Instant expiresAt;

        @Builder
        @JsonCreator
        public RefreshToken(
            @JsonProperty(required = true)
            String tokenValue,
            @JsonProperty(required = true)
            Instant issuedAt,
            @JsonProperty(required = true)
            Instant expiresAt
        ) {
            this.tokenValue = tokenValue;
            this.issuedAt = issuedAt;
            this.expiresAt = expiresAt;
        }
    }

    private String clientRegistrationId;
    private AccessToken accessToken;
    private RefreshToken refreshToken;
    private Map<String, Object> additionalParameters;

    @Builder
    @JsonCreator
    public SigninRequestDto(
        @JsonProperty(required = true)
        String clientRegistrationId,
        @JsonProperty(required = true)
        AccessToken accessToken,
        @JsonProperty(required = true)
        RefreshToken refreshToken,
        @JsonProperty(required = true)
        Map<String, Object> additionalParameters
    ) {
        this.clientRegistrationId = clientRegistrationId;
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
        this.additionalParameters = additionalParameters;
    }
}
