package com.sohaib.dao.Services;

import com.sohaib.dto.CredentialsDto;
import com.sohaib.dto.UserDto;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    UserDto findByLogin(String login);

    UserDto createUser(UserDto userDto);

    UserDto login(CredentialsDto credentialsDto);

    }
