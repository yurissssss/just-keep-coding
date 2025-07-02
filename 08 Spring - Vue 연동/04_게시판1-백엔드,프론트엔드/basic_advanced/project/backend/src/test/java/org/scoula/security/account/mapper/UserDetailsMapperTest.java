package org.scoula.security.account.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Member;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@Log4j2
class UserDetailsMapperTest {

    @Autowired
    UserDetailsMapper userDetailsMapper;

    @Test
    void get() {
        MemberVO memberVO = userDetailsMapper.get("admin");
        log.info(memberVO);

        // List<AuthVO> 확인
        List<AuthVO> authList = memberVO.getAuthList();
        log.info(authList.size());  // 3개
        System.out.println("=====================");

        for (AuthVO authVO : authList) {
            log.info(authVO);
        }
    }
}