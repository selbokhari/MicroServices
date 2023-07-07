package com.sohaib.mapper.service;

import com.sohaib.dto.UserDto;
import com.sohaib.entitires.UserEntity;

public interface UserMapper {

    UserDto toUserDto(UserEntity userEntity);

    UserEntity toUserEntity(UserDto userDto);

}
