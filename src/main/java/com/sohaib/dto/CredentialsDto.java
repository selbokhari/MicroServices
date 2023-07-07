package com.sohaib.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CredentialsDto {
    String token;
    private String login;
    private char[] password;
}
