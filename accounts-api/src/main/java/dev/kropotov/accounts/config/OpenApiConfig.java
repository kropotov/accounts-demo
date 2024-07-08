package dev.kropotov.accounts.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Тестовый рест-сервис",
                description = "Сервис предназначен для тестирования" +
                        " хранения и обслуживания тестового приложения",
                version = "1.0.0",
                contact = @Contact(
                        name = "Alexey Kropotov",
                        email = "a.n.kropotov@gmail.com"
                )
        )
)

public class OpenApiConfig {
}