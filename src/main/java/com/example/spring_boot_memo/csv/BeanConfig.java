package com.example.spring_boot_memo.csv;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import javax.xml.validation.Schema;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public CsvMapper getCsvMapper()
    {
        return new CsvMapper();
    }
    @Bean
    public CsvSchema getCsvSchema()
    {
        return CsvSchema.builder().
        build();
    }
}
