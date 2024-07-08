package dev.kropotov.accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

/**
 * Базовый тестовый класс.
 */
@SpringBootTest
@Testcontainers
@Sql(scripts = {"/sql/init-script.sql", "/sql/test-data.sql"})
@ActiveProfiles("test")
@Sql(scripts = "/sql/clear-data.sql", executionPhase = AFTER_TEST_METHOD)
public class BaseTest {
    protected static final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    public static String readResourceToString(String filePath) throws Exception {
        return IOUtils.resourceToString(filePath, StandardCharsets.UTF_8);
    }

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("prop")
            .withUsername("postgres")
            .withPassword("pass")
            .withExposedPorts(5432)
            .withReuse(true);

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",
                () -> String.format("jdbc:postgresql://localhost:%d/prop", postgres.getFirstMappedPort()));
        registry.add("spring.datasource.username", () -> "postgres");
        registry.add("spring.datasource.password", () -> "pass");
    }

    @SneakyThrows
    public static void assertJsonEqualWithoutId(String expectedStr, String actualStr) {
        JSONAssert.assertEquals(expectedStr,
                actualStr,
                new CustomComparator(
                        JSONCompareMode.STRICT,
                        new Customization("id", (o1, o2) -> true),
                        new Customization("[*].id", (o1, o2) -> true),
                        new Customization("[*].*.id", (o1, o2) -> true))
        );
    }

}
