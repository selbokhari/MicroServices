package com.sohaib.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String login;
    private String token;
    private char[] password;
}
