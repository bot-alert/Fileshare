package com.example.demo.utils;

import com.example.demo.enums.FileFormat;

import static com.example.demo.enums.FileFormat.*;

import java.util.HashMap;
import java.util.Map;

public class FileFormatCategorizer {

    private static final Map<String, FileFormat> EXTENSION_TO_TYPE_MAP = new HashMap<>();

    static {
        // Image types
        EXTENSION_TO_TYPE_MAP.put("jpg", IMAGE);
        EXTENSION_TO_TYPE_MAP.put("jpeg", IMAGE);
        EXTENSION_TO_TYPE_MAP.put("png", IMAGE);
        EXTENSION_TO_TYPE_MAP.put("gif", IMAGE);
        EXTENSION_TO_TYPE_MAP.put("bmp", IMAGE);
        EXTENSION_TO_TYPE_MAP.put("webp", IMAGE);

        // PDF type
        EXTENSION_TO_TYPE_MAP.put("pdf",PDF );

        // Text types
        EXTENSION_TO_TYPE_MAP.put("txt", TEXT);
        EXTENSION_TO_TYPE_MAP.put("csv", TEXT);
        EXTENSION_TO_TYPE_MAP.put("md", TEXT);
        EXTENSION_TO_TYPE_MAP.put("xml", TEXT);
        EXTENSION_TO_TYPE_MAP.put("json", TEXT);

        // Audio types
        EXTENSION_TO_TYPE_MAP.put("mp3", AUDIO);
        EXTENSION_TO_TYPE_MAP.put("wav", AUDIO);
        EXTENSION_TO_TYPE_MAP.put("ogg", AUDIO);
        EXTENSION_TO_TYPE_MAP.put("flac", AUDIO);

        // Video types
        EXTENSION_TO_TYPE_MAP.put("mp4", VIDEO);
        EXTENSION_TO_TYPE_MAP.put("avi", VIDEO);
        EXTENSION_TO_TYPE_MAP.put("mkv", VIDEO);
        EXTENSION_TO_TYPE_MAP.put("mov", VIDEO);
        EXTENSION_TO_TYPE_MAP.put("wmv", VIDEO);
    }

    public static FileFormat categorizeFileType(String filename) {
        String extension = getFileExtension(filename);
        if (extension == null) {
            return OTHER;
        }
        return EXTENSION_TO_TYPE_MAP.getOrDefault(extension,OTHER);
    }

    public static String getFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return null;
        }
        int lastIndexOfDot = filename.lastIndexOf('.');
        return filename.substring(lastIndexOfDot + 1).toLowerCase();
    }
}
