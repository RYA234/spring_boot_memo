package com.example.spring_boot_memo;

import com.example.spring_boot_memo.csv.CsvData;
import com.example.spring_boot_memo.csv.CsvService;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
    CsvMapper mapper;

     @Mock
    CsvSchema csvSchema;

  

   @InjectMocks
    CsvService csvService;

    // @JsonPropertyOrder()
    // CsvData csvData;
//     @Autowired
//     CsvSchema testSchema;



    @Test
    @DisplayName("1.getCsvHeaderでヘッダー内容の確認")
    void getCsvHeaderTest() throws JsonProcessingException
    {
     // CsvSchema testSchema = csvService.getCsvHeader();
     // mapper.configure(CsvGenerator.Feature.ALWAYS_QUOTE_STRINGS, true);
     CsvMapper mapper = new CsvMapper();
     CsvSchema testSchema = mapper.schemaFor(CsvData.class).withHeader();
        String expect1 = "CODE";
           String expect2 = "名前";
           String expect3 = "値段";

           String actual1 = testSchema.column(0).getName();
           String actual2 = testSchema.column(1).getName();
           String actual3 = testSchema.column(2).getName();
           assertEquals(expect1,actual1);
           assertEquals(expect2,actual2);
           assertEquals(expect3,actual3);
       }

       @Test
       @DisplayName("ヘッダーと内容を確認")
       void getWriteCsvTextTest() throws JsonProcessingException
       {
          List<CsvData> csvDataList = new ArrayList<>() {
              {
                  add(new CsvData(2, "高級焼肉", 1200));
              }
          };
          CsvMapper mapper = new CsvMapper();
          CsvSchema schema = mapper.schemaFor(CsvData.class).withHeader();
          String actual = mapper.writer(schema).writeValueAsString(csvDataList);
         // String actual = csvService.WriteCsvText(csvDataList, schema);
          String expect = "CODE,名前,値段\n2,高級焼肉,1200\n";
          assertEquals(expect, actual);

       }

       @Test
       @DisplayName("ヘッダーと内容を確認Autowired_NGになる。")
       void getWriteCsvTextTestAutowired() throws JsonProcessingException
       {
        CsvSchema testSchema = csvService.getCsvHeader();
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
