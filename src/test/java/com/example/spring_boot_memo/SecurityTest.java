package com.example.spring_boot_memo;

import com.example.spring_boot_memo.SpringSecurity.HelloMessageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.WebApplicationContext;
import org.thymeleaf.model.IStandaloneElementTag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringBootMemoApplication.class)
@AutoConfigureMockMvc
public class SecurityTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser
    @DisplayName("ログイン成功後に不許可されていたページにアクセスできるか確認")
    public void whenGetCustomers_thenStatus200() throws Exception {
        mvc.perform(get("/check/OK"))   // ログイン前
                .andExpect(status().isOk());

        mvc.perform(get("/login"))
                .andExpect(status().isOk());
        mvc.perform(get("/check/not_access"))
        .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    @DisplayName("認証後にログアウトのエンドポイントへリクエストすると、/logoutへリダイレクトする")
    public void Logout() throws Exception {
       MvcResult result = mvc.perform(logout()).andReturn();
       String actual = result.getRequest().getRequestURI();
       String expected = "/logout";
       assertEquals(expected, actual);
       System.out.println(result);
    }

    @Test
    @DisplayName("未ログイン時のアクセスチェック")
    public void AccessCheckInNoAuth() throws Exception {
        mvc.perform(get("/check/OK"))
                .andExpect(status().is3xxRedirection());
        mvc.perform(get("/check/not_access"))
                .andExpect(status().is3xxRedirection());

        mvc.perform(get("/login"))
                .andExpect(status().isOk());          
    }

    @Test
    @WithMockUser
    @DisplayName("比較-エンコード後の生のパスワードがストレージからのエンコードされたパスワード）")
    public void passwordBCryptMatchCheck() throws NoSuchAlgorithmException{
        String  unexpected = "PASS"; 
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String actual = passwordEncoder.encode(unexpected);
        Boolean isActual = passwordEncoder.matches(unexpected,actual);
        assertEquals(true, isActual);
    }
}
