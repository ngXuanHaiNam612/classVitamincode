package com.vitamincode.vitamincode_be.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationDtoRequest {
    private String token;
    private Boolean authenticated;
}
