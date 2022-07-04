package com.example.spring_boot_memo.csv;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
// データモデルです。

@Data
@JsonPropertyOrder({"CODE", "名前", "値段"})
public class CsvData {
    @JsonProperty("CODE")
    int code;
    @JsonProperty("名前")
    String name;
    @JsonProperty("値段")
    int price;

    public CsvData() {
    }

    public CsvData(int code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
}
