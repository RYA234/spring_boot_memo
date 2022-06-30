package com.example.spring_boot_memo.ImageUpload;


import com.example.spring_boot_memo.storage.FileSystemStorageService;
import com.example.spring_boot_memo.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

@org.springframework.stereotype.Controller
public class ImageController {


    private final StorageService storageService;
    @Autowired
    public ImageController(StorageService storageService) {
        this.storageService = storageService;
    }



    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexController()
    {
        return "index";
    }


    @RequestMapping(value = "image/image_add", method = RequestMethod.GET)
    public String addImageController(Model model, @ModelAttribute Product product) throws IOException {


        return "image/image_add";
    }

    @RequestMapping(value = "image/image_check", method = RequestMethod.POST)
    public String checkImageController(Model model, Product product) throws IOException {

        Random random = new Random();
        Path goal = storageService.load(product.getFile().getResource().getFilename());
        storageService.store(product.getFile());
        String newPath = "tmp" + String.valueOf(random.nextInt(10000)) +".png";
        Path oldPath = Paths.get("upload-dir/"+product.getFile().getResource().getFilename());
        File oldFile = new File(goal.toString());
        Files.move(oldPath,oldPath.resolveSibling(newPath));

        product.setFilePath(newPath);
        model.addAttribute(product);
        product.setFilePath(newPath);

        return "image/image_check";
    }

    @RequestMapping(value = "image/image_done", method = RequestMethod.POST)
    public String doneImageController()
    {
        return "image/image_done";
    }

}
