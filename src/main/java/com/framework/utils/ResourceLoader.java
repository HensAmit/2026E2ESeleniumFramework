package com.framework.utils;

import com.framework.reports.ExtentLogger;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ResourceLoader {
    public static InputStream getResourceAsStream(String path) {
        try {
            InputStream stream = ResourceLoader.class.getClassLoader().getResourceAsStream(path);
            if (Objects.nonNull(stream)) {
                return stream;
            }
            return Files.newInputStream(Path.of(path));
        } catch (Exception e) {
            ExtentLogger.fail("Failed to get resource from: " + path + e);
        }
        return null;
    }
}
