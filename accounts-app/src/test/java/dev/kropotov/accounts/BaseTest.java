package dev.kropotov.accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.nio.charset.StandardCharsets;

/**
 * Базовый тестовый класс.
 */
public abstract class BaseTest {
    protected static final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules()
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .registerModule(new JavaTimeModule());

    @SneakyThrows
    public static String readResourceToString(String filePath) {
        return IOUtils.resourceToString(filePath, StandardCharsets.UTF_8);
    }

    @SneakyThrows
    public static String asJsonString(final Object obj) {
        return objectMapper.writeValueAsString(obj);
    }

}
