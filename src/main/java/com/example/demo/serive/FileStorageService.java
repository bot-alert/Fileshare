package com.example.demo.serive;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileData;

public interface FileStorageService  {

public String save(MultipartFile file);
public FileData downloadFile(String id);

}
