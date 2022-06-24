package com.example.spring_boot_memo.csv;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    CsvService csvService;

    @Autowired
    DownloadHelper downloadHelper;
    @RequestMapping(value = "index",params = "OK",method = RequestMethod.GET)
    public String indexController()
    {
        return "index";
    }
    @RequestMapping(value = "download", method = RequestMethod.POST)
    public ResponseEntity<byte[]> download() throws IOException {

        HttpHeaders headers = new HttpHeaders();
        downloadHelper.addContentDisposition(headers, "日本語ファイル名.csv");
        return new ResponseEntity<>(csvService.getCsvText().getBytes("MS932"), headers, HttpStatus.OK);
    }

}
