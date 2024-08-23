package com.example.demo.service;

import com.example.demo.entity.FileData;
import org.springframework.core.io.Resource;
import org.springframework.data.util.Pair;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String save(MultipartFile file);

    Pair<Resource,FileData> downloadFile(String id);

}
