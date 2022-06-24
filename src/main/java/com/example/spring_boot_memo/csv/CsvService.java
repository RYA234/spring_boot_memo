package com.example.spring_boot_memo.csv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
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
    public String getCsvText() throws JsonProcessingException {
        CsvMapper mapper = new CsvMapper();
        //文字列にダブルクオートをつける
        mapper.configure(CsvGenerator.Feature.ALWAYS_QUOTE_STRINGS, true);
        //ヘッダをつける
        CsvSchema schema = mapper.schemaFor(CsvData.class).withHeader();
        //本来はDBからデータを取得する。
        List<CsvData> csvDatas = new ArrayList<CsvData>();
        csvDatas.add(new CsvData(1, "柿", 100));
        csvDatas.add(new CsvData(2, "米", 200));
        csvDatas.add(new CsvData(3, "エビ", 300));
        return mapper.writer(schema).writeValueAsString(csvDatas);
    }


}
