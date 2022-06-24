package com.example.spring_boot_memo;

import com.example.spring_boot_memo.csv.CsvData;
import com.example.spring_boot_memo.csv.CsvService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    @DisplayName("csvファイルの内容が合っているか確認(ヘッダー除く)一行だけ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    void csvFileCheck2(int code,String name, int price) throws JsonProcessingException {
        List<CsvData> csvDataList = new ArrayList<>();
        CsvData csvData = new CsvData(1,"寿司",120);
        csvDataList.add(csvData);
        String actualtmp = csvService.getCsvText(csvDataList);
        int linestart = actualtmp.indexOf("\n");
        int lineend = actualtmp.indexOf("\n", linestart+1);
        String actual = actualtmp.substring(linestart+1,lineend);

        String expect = code + ",\"" + name +"\"," + price;
        System.out.println(actual + "\n");
        System.out.println(expect + "\n");
        assertEquals(expect,actual);
    }


}
