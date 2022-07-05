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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    @DisplayName("ログイン後に認証できるか確認")
    public void whenGetCustomers_thenStatus200() throws Exception {
        mvc.perform(get("/check/OK"))
                .andExpect(status().isOk());

        mvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    @DisplayName("ログアウトができるか確認")
    public void Logout() throws Exception {
        mvc.perform(logout());
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
    @DisplayName("パスワードがBcryptCheckされているか確認")
    public void passwordBCryptCheck(){
         String  unexpected = "PASS"; 
        PasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String actual = bcrypt.encode(unexpected);
        assertNotEquals(unexpected, actual);

    }
}