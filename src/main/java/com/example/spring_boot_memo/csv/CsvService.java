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

import javax.xml.validation.Schema;

import com.example.spring_boot_memo.csv.CsvData;
@Service
public class CsvService {

    /**
     * CsvMapperで、csvを作成する。
     * @return csv(String)
     * @throws JsonProcessingException
     */
 
    private final CsvMapper mapper;
    private   CsvSchema csvSchema;

     @Autowired
     public CsvService(CsvMapper mapper, CsvSchema csvSchema)
     {
        this.csvSchema = csvSchema;
        this.mapper = mapper;
     }




    public String getCsvText(List<CsvData> csvDataList) throws JsonProcessingException {
//        CsvMapper mapper = new CsvMapper();
        //文字列にダブルクオートをつける
       // mapper.configure(CsvGenerator.Feature.ALWAYS_QUOTE_STRINGS, true);
        //ヘッダをつける
        CsvSchema schema = mapper.schemaFor(CsvData.class).withHeader();
        //本来はDBからデータを取得する。
        return mapper.writer(schema).writeValueAsString(csvDataList);

    }

    //CsvDataからCsvファイルのヘッダー情報を取得
    public CsvSchema getCsvHeader() throws JsonProcessingException {
        //文字列にダブルクオートをつける
        // CsvDataの@Jsonpropertyの文字列をヘッダーとして書き込む
        csvSchema = mapper.schemaFor(CsvData.class).withHeader();
        return csvSchema;
    }

    // csvファイルの内容をString型で作成します。
    // 引数のcsvDataListはデータ部分、schemaはヘッダー部分
    public String WriteCsvText(List<CsvData> csvDataList, CsvSchema csvSchema) throws JsonProcessingException {
        return mapper.writer(csvSchema).writeValueAsString(csvDataList);
    }

}
