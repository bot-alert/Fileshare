package com.example.demo.utils;

import com.example.demo.enums.FileFormat;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class FileUuidGenerator {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    public static String generateUniqueId(FileFormat fileFormat) {

        char shortCode = fileFormat.toString().charAt(0);

        // Generate a unique suffix using timestamp and counter
        String uniqueSuffix = Long.toHexString(Instant.now().toEpochMilli())
                + Integer.toHexString(COUNTER.getAndIncrement());

        // Combine the short code with the unique suffix
        return shortCode + "-" + uniqueSuffix+"-"+COUNTER;
    }
}
