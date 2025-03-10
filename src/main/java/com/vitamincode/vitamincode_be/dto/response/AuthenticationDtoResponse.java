package com.vitamincode.vitamincode_be.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationDtoResponse {
    private String accessToken;
    private Boolean authenticated;
}
