package com.sohaib.dao.ServiceImpl;

import com.sohaib.dao.daos.UserDao;
import com.sohaib.dto.CredentialsDto;
import com.sohaib.dto.UserDto;
import com.sohaib.dao.Services.UserService;
import com.sohaib.entitires.UserEntity;
import com.sohaib.exceptions.exception.BusinessException;
import com.sohaib.mapper.service.UserMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.nio.CharBuffer;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public UserDto findByLogin(String login) {
        return userDao.recupererUtilisateurParLogin(login)
                .map(userMapper::toUserDto)
                .orElseThrow(() -> new BusinessException(BusinessException.Cause.UTILISATEUR_NON_TROUVE));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserDto createUser(UserDto userDto) {
        Optional<UserEntity> userEntity = userDao.recupererUtilisateurParLogin(userDto.getLogin());

        if (userEntity.isPresent()) {
            throw new BusinessException(BusinessException.Cause.UTILISATEUR_EXISTE_DEJA);
        }

        UserEntity userToBeCreated = userMapper.toUserEntity(userDto);
        userToBeCreated.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));
        UserEntity createdUser = userDao.createUser(userToBeCreated);

        return userMapper.toUserDto(createdUser);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserDto login(CredentialsDto credentialsDto) {

        UserEntity userEntity = userDao.recupererUtilisateurParLogin(credentialsDto.getLogin())
                .orElseThrow(() -> new BusinessException(BusinessException.Cause.UTILISATEUR_NON_TROUVE));

         if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), userEntity.getPassword())) {
            return userMapper.toUserDto(userEntity);
        }

        throw new BusinessException(BusinessException.Cause.MOT_DE_PASSE_NON_VALIDE);
    }

}
