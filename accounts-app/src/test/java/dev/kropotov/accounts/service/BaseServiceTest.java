package dev.kropotov.accounts.service;

import dev.kropotov.accounts.BaseTest;
import lombok.SneakyThrows;
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

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

/**
 * Базовый тестовый класс.
 */
@SpringBootTest
@Sql(scripts = {"/sql/init-script.sql", "/sql/test-data.sql"})
@ActiveProfiles("test")
@Sql(scripts = "/sql/clear-data.sql", executionPhase = AFTER_TEST_METHOD)
public abstract class BaseServiceTest extends BaseTest {
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("prop")
            .withUsername("postgres")
            .withPassword("pass")
            .withExposedPorts(5432)
            .withReuse(true);

    static {
        postgres.start();
    }

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
                        //TODO: сделать че-то приличное с этим
                        new Customization("id", (o1, o2) -> true),
                        new Customization("*[*].id", (o1, o2) -> true),
                        new Customization("[*].id", (o1, o2) -> true),
                        new Customization("[*].*.id", (o1, o2) -> true),
                        new Customization("*[*].*.id", (o1, o2) -> true),
                        new Customization("[*].*[*].*.id", (o1, o2) -> true)
                )
        );
    }

}
