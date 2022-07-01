package com.example.spring_boot_memo;

import com.example.spring_boot_memo.validation.MainController;
import com.example.spring_boot_memo.validation.ValiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@AutoConfigureMockMvc
@SpringBootTest
public class ValidationTest {
    @Autowired
    MockMvc mockMvc;

    @Mock
    ValiService valiService;

    @InjectMocks
    MainController mainController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    @DisplayName("1.name=ASBA id=11　結果：OK")
    public void Case1_name_ASBA_OK_id_11_OK() throws Exception {
        this.mockMvc.perform(post("/validation/check")
                        .param("OK", "OK")
                        .param("name", "ASBA")
                        .param("id", "11")
                )
                .andDo(print())
                .andExpect(model().hasNoErrors()
                );
    }

    @Test
    @DisplayName("2.name=ASBA id=101 結果：NG")
    public void Case2_name_ASBA_OK_id_101_NG() throws Exception {
        this.mockMvc.perform(post("/validation/check")
                        .param("OK", "OK")
                        .param("name", "ASBA")
                        .param("id", "101")
                )
                .andDo(print())
                .andExpect(model().hasErrors()
                );
    }

    @Test
    @DisplayName("3.name=ASBA id=100 結果：OK")
    public void Case3_name_ASBA_NG_id_100_OK() throws Exception {
        this.mockMvc.perform(post("/validation/check")
                        .param("OK", "OK")
                        .param("name", "ASBA")
                        .param("id", "100")
                )
                .andDo(print())
                .andExpect(model().hasNoErrors()
                );
    }

    @Test
    @DisplayName("4.name=ASBA id=0 結果：OK")
    public void Case4_name_ASBA_OK_id_0_OK() throws Exception {
        this.mockMvc.perform(post("/validation/check")
                        .param("OK", "OK")
                        .param("name", "ASBA")
                        .param("id", "0")
                )
                .andDo(print())
                .andExpect(model().hasNoErrors()
                );
    }

    @Test
    @DisplayName("5.name=null id=50 結果：NG")
    public void Case5_name_empty_NG_id_50_OK() throws Exception {
        this.mockMvc.perform(post("/validation/check")
                        .param("OK", "OK")
                        .param("name", "")
                        .param("id", "50")
                )
                .andDo(print())
                .andExpect(model().hasErrors()
                );
    }

    @Test
    @DisplayName("6.name=ASBA id=-1 結果：NG")
    public void Case6_name_ASBA_OK_id_minus1_NG() throws Exception {
        this.mockMvc.perform(post("/validation/check")
                        .param("OK", "OK")
                        .param("name", "ASBA")
                        .param("id", "-1")
                )
                .andDo(print())
                .andExpect(model().hasErrors()
                );
    }
}
