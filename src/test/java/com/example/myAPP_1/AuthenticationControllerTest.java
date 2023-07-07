package com.example.myAPP_1;

import com.sohaib.controllers.AuthenticationController;
import com.sohaib.dao.ServiceImpl.UserServiceImpl;
import com.sohaib.dao.Services.UserService;
import com.sohaib.dao.daos.Impl.UserDaoImpl;
import com.sohaib.dao.daos.UserDao;
import com.sohaib.dto.CredentialsDto;
import com.sohaib.dto.UserDto;
import com.sohaib.entitires.UserEntity;
import com.sohaib.main.mainClass.DemoApplication;
import com.sohaib.security.conf.UserAuthProvider;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith({MockitoExtension.class, SpringExtension.class})
@SpringBootTest(classes = DemoApplication.class)
public class AuthenticationControllerTest {
    
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean("testuserDao")
        public UserDao employeeService() {
            return new UserDaoImpl();
        }
    }


    @Mock
    UserDao userDao;

    @Autowired
    @Qualifier("testuserDao")
    private UserDao userDao2;

    @Mock
    UserService userService;

    @Mock
    UserAuthProvider userAuthProvider;


    @InjectMocks
    AuthenticationController authenticationController;

//    @RegisterExtension
//    public MockitoRule rule = MockitoJUnit.rule();


    @Test
    public void testAuthentificationService() {
        UserDto userTest = UserDto.builder()
                .id(1)
                .login("selbokhari")
                .lastName("EL BOKHARI")
                .firstName("SOHAIB").build();

        UserEntity userEntity = UserEntity.builder()
                .login("selbokhari")
                .lastName("EL BOKHARI")
                .password("$2a$10$nMHmXO3.Q1AUPGgJfSojrO3dF4c2gSRPr.f07fubfX/F6POyNpcIy")
                .build();
        // creating

        CredentialsDto crd = CredentialsDto.builder()
                .login("selbokhari")
                .password("test".toCharArray())
                .build();

//        when(userDao.recupererUtilisateurParLogin(crd.getLogin())).thenReturn(Optional.ofNullable(userEntity));
        when(userService.login(crd)).thenReturn(userTest);
        System.out.println(userDao.recupererUtilisateurParLogin("selbokhari"));
        System.out.println(userDao2.recupererUtilisateurParLogin("selbokhari"));

        assertEquals(ResponseEntity.ok(userTest),authenticationController.login(crd));
    }

}
