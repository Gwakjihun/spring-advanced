package org.example.expert.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class PasswordEncoderTest {

    @InjectMocks
    private PasswordEncoder passwordEncoder;

    @Test
    void matches_메서드가_정상적으로_동작한다() {
        // given: "testPassword"라는 원본 비밀번호를 암호화
        String rawPassword = "testPassword";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // when: 원본 비밀번호와 암호화된 비밀번호가 일치하는지 확인
        // 순서를 (원본, 암호화된 것)으로 바로잡음
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);

        // then: 결과가 true
        assertTrue(matches);
    }
}