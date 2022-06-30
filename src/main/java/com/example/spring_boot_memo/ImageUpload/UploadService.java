package com.example.spring_boot_memo.ImageUpload;

import com.example.spring_boot_memo.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

@Service
public class UploadService {

    private final StorageService storageService;
    @Autowired
    public UploadService(StorageService storageService) {
        this.storageService = storageService;
    }

    public String imageAddTmp(Product product) throws IOException {
        Random random = new Random();
        Path goal = storageService.load(product.getFile().getResource().getFilename());
        storageService.store(product.getFile());
        String newPath = "tmp" + String.valueOf(random.nextInt(10000)) +".png";
        Path oldPath = Paths.get("upload-dir/"+product.getFile().getResource().getFilename());
        File oldFile = new File(goal.toString());
        Files.move(oldPath,oldPath.resolveSibling(newPath));

        return newPath;
    }

    public void imageAddDone(String imagePath) throws IOException {
        Random random = new Random();
        String newPath = String.valueOf(random.nextInt(10000000)) +".png";
        Path oldPath = Paths.get("upload-dir",imagePath);
        Files.move (oldPath,oldPath.resolveSibling(newPath));

    }




}
