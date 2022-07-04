package com.example.spring_boot_memo.csv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsvService {



    private final CsvMapper mapper;
    private CsvSchema csvSchema;

    //DI
    @Autowired
    public CsvService(CsvMapper mapper, CsvSchema csvSchema) {
        this.csvSchema = csvSchema;
        this.mapper = mapper;
    }

    //CsvDataからCsvファイルのヘッダー情報を取得
    public CsvSchema getCsvHeader() {
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
