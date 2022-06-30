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
    CsvMapper mapper;

    @Mock
    CsvSchema schema;
    @InjectMocks
    CsvService csvService;


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
