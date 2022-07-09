package com.example.spring_boot_memo;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.security.NoSuchAlgorithmException;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringBootMemoApplication.class)
@AutoConfigureMockMvc
public class SecurityTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    @WithMockUser
    @DisplayName("認証成功後にアクセスページにログインアクセスできるか確認")
    public void whenGetCustomers_thenStatus200() throws Exception {
        mvc.perform(get("/menu/menu"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    @DisplayName("認証後にログアウトのエンドポイントへリクエストすると、/logoutへリダイレクトする")
    public void Logout() throws Exception {
        mvc.perform(logout())
        .andExpect(header().string("Location", "/login?logout"));
    }

    @Test
    @DisplayName("認証成功前のアクセス状況のチェック")
    public void AccessCheckInNoAuth() throws Exception {
        mvc.perform(get("/check/OK"))
                .andExpect(header().string("Location","http://localhost/login"));        // アクセスできないviewはloginへリダイレクト
        mvc.perform(get("/check/OK"))
                .andExpect(header().string("Location","http://localhost/login"));        // アクセスできないviewはloginへリダイレクト
        mvc.perform(get("/check/not_access"))
                .andExpect(header().string("Location","http://localhost/login"));        // アクセスできないviewはloginへリダイレクト
        mvc.perform(get("/menu/menu"))
                .andExpect(header().string("Location","http://localhost/login"));        // アクセスできないviewはloginへリダイレクト
        mvc.perform(get("/login"))
                .andExpect(status().isOk());         
    }

    @Test
    @DisplayName("比較-エンコード後の生のパスワードとストレージからのエンコードされたパスワード")
    public void passwordBCryptMatchCheck() throws NoSuchAlgorithmException{
        String expected = "PASS"; 
        String actual = passwordEncoder.encode(expected);
        Boolean isActual = passwordEncoder.matches(expected,actual);
        assertEquals(true, isActual);
    }
}
