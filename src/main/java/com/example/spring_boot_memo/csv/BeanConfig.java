package com.example.spring_boot_memo.csv;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public CsvMapper getCsvMapper()
    {
        return new CsvMapper();
    }
}
