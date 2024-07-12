package dev.kropotov.accounts.controller;

import dev.kropotov.accounts.controller.api.ProductApi;
import dev.kropotov.accounts.dto.ProductDto;
import dev.kropotov.accounts.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {
    private final ProductService productService;

    @Override
    public ResponseEntity<ProductDto> create(ProductDto dto) {
        return ResponseEntity.ok(productService.create(dto));
    }

    @Override
    public ResponseEntity<List<ProductDto>> readByProductNumber(String number) {
        if (number == null || number.isEmpty()) {
            return ResponseEntity.ok(productService.readAll());
        }
        return ResponseEntity.ok(productService.readByProductNumber(number));
    }

    @Override
    public ResponseEntity<ProductDto> readById(Long id) {
        return ResponseEntity.ok(productService.readById(id));
    }

    @Override
    public ResponseEntity<ProductDto> update(Long id, ProductDto updatedDto) {
        return ResponseEntity.ok(productService.update(id, updatedDto));
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted");
    }
}
