package com.mtvs.mtvs3rdbe.user.service;

import com.mtvs.mtvs3rdbe.user.domain.User;
import com.mtvs.mtvs3rdbe.user.dto.UserCreateRequestDTO;
import com.mtvs.mtvs3rdbe.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserAuthServiceTest {

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {
        UserCreateRequestDTO userDTO = new UserCreateRequestDTO("test", "1234", "goodman");

        userAuthService.save(userDTO);

        User findUser = userRepository.findByLoginId("test").orElseThrow();

        assertNotNull(findUser);
        assertEquals("goodman", findUser.getNickname());
    }

    @Test
    void signUp() {
        UserCreateRequestDTO userDTO = new UserCreateRequestDTO("test", "1234", "goodman");

        userAuthService.signUp(userDTO);

        User findUser = userRepository.findByLoginId("test").orElseThrow();

        assertNotNull(findUser);
        assertEquals("goodman", findUser.getNickname());
    }
}