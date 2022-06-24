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
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CsvServiceTest
{
    @Mock
    CsvMapper mapper;

    @Mock
    CsvSchema schema;
    @InjectMocks
    CsvService csvService;


//    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    @DisplayName("返り値の確認")
//    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @Test
    void sumcheck() throws JsonProcessingException {
//    void sumcheck(int code,String name, int price) throws JsonProcessingException {
        // given
        List<CsvData> csvDataList = new ArrayList<>();
        CsvData csvData = new CsvData(1,"寿司",120);
        csvDataList.add(csvData);
        String tmp ="test";
       assertEquals(csvService.getCsvText(csvDataList),"1");
       System.out.print( csvService.getCsvText(csvDataList));
       // System.out.println(code + " = " + name + ":" + price);
      //  System.out.print(tmp);
    }


    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    @DisplayName("返り値の確認2")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @Test
//    void sumcheck2() throws JsonProcessingException {
    void sumcheck2(int code,String name, int price) throws JsonProcessingException {

        //todo @csvSoucrce の日本語化
        // given
        List<CsvData> csvDataList = new ArrayList<>();
        CsvData csvData = new CsvData(1,"寿司",120);
        csvDataList.add(csvData);
        String tmp ="test";
        assertEquals(csvService.getCsvText(csvDataList),"1");
        System.out.print( csvService.getCsvText(csvDataList));
        // System.out.println(code + " = " + name + ":" + price);
        //  System.out.print(tmp);
    }


    @DisplayName("CSV From File Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }
}
