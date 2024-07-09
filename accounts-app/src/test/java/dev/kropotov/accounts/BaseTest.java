package dev.kropotov.accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.nio.charset.StandardCharsets;

/**
 * Базовый тестовый класс.
 */
public abstract class BaseTest {
    protected static final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    @SneakyThrows
    public static String readResourceToString(String filePath) {
        return IOUtils.resourceToString(filePath, StandardCharsets.UTF_8);
    }

    @SneakyThrows
    public static String asJsonString(final Object obj) {
        return objectMapper.writeValueAsString(obj);
    }

}
