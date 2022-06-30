package com.example.spring_boot_memo.csv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.example.spring_boot_memo.csv.CsvData;
@Service
public class CsvService {

    /**
     * CsvMapperで、csvを作成する。
     * @return csv(String)
     * @throws JsonProcessingException
     */


    @Autowired
    CsvMapper mapper;

    public String getCsvText(List<CsvData> csvDataList) throws JsonProcessingException {
//        CsvMapper mapper = new CsvMapper();
        //文字列にダブルクオートをつける
        mapper.configure(CsvGenerator.Feature.ALWAYS_QUOTE_STRINGS, true);
        //ヘッダをつける
        CsvSchema schema = mapper.schemaFor(CsvData.class).withHeader();
        //本来はDBからデータを取得する。
        return mapper.writer(schema).writeValueAsString(csvDataList);

    }

    public CsvSchema ReadCsvText(List<CsvData> csvDataList) throws JsonProcessingException {
        //文字列にダブルクオートをつける
        mapper.configure(CsvGenerator.Feature.ALWAYS_QUOTE_STRINGS, true);
        CsvSchema schema = mapper.schemaFor(CsvData.class).withHeader();
        return schema;
    }

    public String WriteCsvText(List<CsvData> csvDataList, CsvSchema schema) throws JsonProcessingException {
        return mapper.writer(schema).writeValueAsString(csvDataList);
    }

}
