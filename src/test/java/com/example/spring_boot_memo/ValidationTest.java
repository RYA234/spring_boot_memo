package com.example.spring_boot_memo;


import com.example.spring_boot_memo.validation.MainController;
import com.example.spring_boot_memo.validation.ValiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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
    void setup()
    {
        MockitoAnnotations.initMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    @DisplayName("1.name=ASBA id=11　結果：OK")
     public void Case1() throws Exception{
       this.mockMvc.perform(post("/validation/check")
                .param("OK","OK")
                    //   .param("name","dsada"))
                       .param("name","ASBA")
                       .param("id","11")
               )
               .andDo(print())
               .andExpect(model().hasNoErrors()
                       );
    }

    @Test
    @DisplayName("2.name=ASBA id=101 結果：NG")
    public void Case2() throws Exception{
        this.mockMvc.perform(post("/validation/check")
                        .param("OK","OK")
                        //   .param("name","dsada"))
                        .param("name","ASBA")
                        .param("id","101")
                )
                .andDo(print())
                .andExpect(model().hasErrors()
                );
    }

    @Test
    @DisplayName("3.name=ASBA id=100 結果：OK")
    public void Case3() throws Exception{
        this.mockMvc.perform(post("/validation/check")
                        .param("OK","OK")
                        //   .param("name","dsada"))
                        .param("name","ASBA")
                        .param("id","100")
                )
                .andDo(print())
                .andExpect(model().hasNoErrors()
                );
    }

    @Test
    @DisplayName("4.name=ASBA id=100 結果：OK")
    public void Case4() throws Exception{
        this.mockMvc.perform(post("/validation/check")
                        .param("OK","OK")
                        //   .param("name","dsada"))
                        .param("name","ASBA")
                        .param("id","100")
                )
                .andDo(print())
                .andExpect(model().hasNoErrors()
                );
    }

    @Test
    @DisplayName("5.name=ASBA id=0 結果：OK")
    public void Case5() throws Exception{
        this.mockMvc.perform(post("/validation/check")
                        .param("OK","OK")
                        //   .param("name","dsada"))
                        .param("name","ASBA")
                        .param("id","0")
                )
                .andDo(print())
                .andExpect(model().hasNoErrors()
                );
    }

    @Test
    @DisplayName("6.name=null id=50 結果：NG")
    public void Case6() throws Exception{
        this.mockMvc.perform(post("/validation/check")
                        .param("OK","OK")
                        //   .param("name","dsada"))
                        .param("name","")
                        .param("id","50")
                )
                .andDo(print())
                .andExpect(model().hasErrors()
                );
    }

    @Test
    @DisplayName("7.name=ASBA id=-1 結果：NG")
    public void Case7() throws Exception{
        this.mockMvc.perform(post("/validation/check")
                        .param("OK","OK")
                        //   .param("name","dsada"))
                        .param("name","ASBA")
                        .param("id","-1")
                )
                .andDo(print())
                .andExpect(model().hasErrors()
                );
    }

}
