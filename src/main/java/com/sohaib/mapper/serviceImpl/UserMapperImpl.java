package com.sohaib.mapper.serviceImpl;

import com.sohaib.dto.UserDto;
import com.sohaib.entitires.UserEntity;
import com.sohaib.mapper.service.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .login(userEntity.getLogin())
                .build();
    }

    @Override
    public UserEntity toUserEntity(UserDto userDto) {
        return UserEntity.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getFirstName())
                .login(userDto.getLogin())
                .build();
    }

}
