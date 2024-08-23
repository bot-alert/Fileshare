package com.example.demo.service;

import com.example.demo.entity.FileData;
import com.example.demo.repo.FileDatabaseRepository;
import com.example.demo.utils.FileDirectoryResolver;
import com.example.demo.utils.FileFormatCategorizer;
import com.example.demo.utils.FileUuidGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Service
@Component
@RequiredArgsConstructor
public class FileStorageImpl implements FileStorageService {

    private final FileDatabaseRepository fileDatabaseRepository;

    @Override
    public String save(MultipartFile file) {

        FileData fileData = new FileData();
        fileData.setFileFormat(FileFormatCategorizer.categorizeFileType(file.getOriginalFilename()));
        fileData.setFilename(file.getOriginalFilename());
        fileData.setFileType(file.getContentType());
        fileData.setUuid(FileUuidGenerator.generateUniqueId(fileData.getFileFormat()));
        fileDatabaseRepository.save(fileData);

        File uploadDir = new File(FileDirectoryResolver.getFileDirectory(fileData.getFileFormat()));
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        File uploadedFile = new File(uploadDir, fileData.getUuid());

        try {
            Files.copy(file.getInputStream(), uploadedFile.getAbsoluteFile().toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileData.getUuid();


    }

    @Override
    public Pair<Resource, FileData> downloadFile(String id) {
        FileData fileData = fileDatabaseRepository.getFileByUuid(id);

        String fileDirectory = FileDirectoryResolver.getFileDirectory(fileData.getFileFormat()) + "/" + fileData.getUuid();

        File file = new File(fileDirectory);

        if (!file.exists()) {
            return null;
        }

        return Pair.of(new FileSystemResource(file), fileData);
    }

}
