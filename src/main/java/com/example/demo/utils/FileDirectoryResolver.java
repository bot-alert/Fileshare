package com.example.demo.utils;

import com.example.demo.enums.FileFormat;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileDirectoryResolver {
    private static final String ROOT_DIRECTORY = "uploads/";

    public static String getFileDirectory(FileFormat fileFormat) {
        return ROOT_DIRECTORY.concat(fileFormat.toString().toLowerCase());
    }
}
