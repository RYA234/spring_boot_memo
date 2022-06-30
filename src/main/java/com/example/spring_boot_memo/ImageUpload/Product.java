package com.example.spring_boot_memo.ImageUpload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Product {

    private String filePath;
    private String name;
    private MultipartFile file;
}
