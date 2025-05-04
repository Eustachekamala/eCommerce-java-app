package com.eustachecode.eCommerce_java_app.services;

import com.eustachecode.eCommerce_java_app.dto.ProductDTO;
import com.eustachecode.eCommerce_java_app.errors.ResourceNotFoundException;
import com.eustachecode.eCommerce_java_app.mappers.ProductMapper;
import com.eustachecode.eCommerce_java_app.models.Product;
import com.eustachecode.eCommerce_java_app.repositories.CategoryRepository;
import com.eustachecode.eCommerce_java_app.repositories.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final String UPLOAD_DIRECTORY = "uploads/";

    //Create a product
    @Operation(summary = "Create a new Customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ProductDTO createProduct(ProductDTO productDTO, MultipartFile imageFile) throws IOException {
        var category = categoryRepository.findById(productDTO.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + productDTO.categoryId() + " not found"));
        //Save image
        String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
        Path imagePath = Paths.get(UPLOAD_DIRECTORY + fileName);
        Files.createDirectories(imagePath.getParent());
        Files.write(imagePath, imageFile.getBytes());

        //Map and set image
        Product product = productMapper.toProduct(productDTO);
        product.setCategory(category);
        product.setImageUrl("/" + UPLOAD_DIRECTORY + fileName);
        Product savedProduct = productRepository.save(product);
        return productMapper.toProductDTO(savedProduct);
    }

    //Get all products
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    //Get product by id
    public ProductDTO findById(Integer id) {
        return productRepository.findById(id)
                .map(productMapper::toProductDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id: " +id+ " not found"));
    }

    //update product
    @Operation(summary = "Update Product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product updated successfully"),
            @ApiResponse(responseCode = "404", description = "Invalid id")
    })
    public ProductDTO updateProduct(Integer productId, ProductDTO productDTO) {
        var category = categoryRepository.findById(productDTO.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + productDTO.categoryId() + " not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id: " +productId+ " not found"));
        product.setProductName(productDTO.productName());
        product.setPrice(productDTO.price());
        product.setCategory(category);
        Product updatedProduct = productRepository.save(product);
        return productMapper.toProductDTO(updatedProduct);
    }

    //delete a product
    @Operation(summary = "Delete Product")
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
