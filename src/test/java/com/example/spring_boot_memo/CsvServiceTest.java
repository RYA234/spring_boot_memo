package com.example.spring_boot_memo;

import com.example.spring_boot_memo.csv.CsvData;
import com.example.spring_boot_memo.csv.CsvService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.Csv;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CsvServiceTest
{



    @Mock
    CsvSchema schema;

    @Mock
     CsvMapper mapper;

    @InjectMocks
    CsvService csvService;

//     @Autowired
//     CsvSchema testSchema;

    @Test
    @DisplayName("1.getCsvHeaderでヘッダー内容の確認")
    void getCsvHeaderTest() throws JsonProcessingException
    {
       CsvSchema testSchema = csvService.getCsvHeader();
        
        String expect1 = "\"CODE\"";
        //    String expect2 = "\"名前\"";
        //    String expect3 = "\"値段\"";

        //    String actual1 = testSchema.column(0).getName();
        //    String actual2 = testSchema.column(1).getName();
        //    String actual3 = testSchema.column(2).getName();

        //    assertEquals(expect1,actual1);
        //    assertEquals(expect2,actual2);
        //    assertEquals(expect3,actual3);



        }

//    @Test
//    @DisplayName("テストコード")
//    void shouldGetCsvText() throws JsonProcessingException {
//        List<CsvData> csvDataList = new ArrayList<>() {
//            {
//                add(new CsvData(2, "高級焼肉", 1200));
//            }
//        };
//        String expect = "\"CODE\",\"名前\",\"値段\"\n2,\"高級焼肉\",1200\n";
//        String actual = csvService.getCsvText(csvDataList);
//        assertEquals(expect, actual);
//    }
}
