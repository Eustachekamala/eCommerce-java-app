package com.eustachecode.eCommerce_java_app.services;

import com.eustachecode.eCommerce_java_app.dto.CategoryDTO;
import com.eustachecode.eCommerce_java_app.errors.ResourceNotFoundException;
import com.eustachecode.eCommerce_java_app.mappers.CategoryMapper;
import com.eustachecode.eCommerce_java_app.models.Category;
import com.eustachecode.eCommerce_java_app.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toCategoryDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO findById(Integer id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toCategoryDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " +id+ " not found"));
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toCategory(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toCategoryDTO(savedCategory);
    }

    public CategoryDTO updateCategory(Integer id, CategoryDTO categoryDTO) {
        Category category = categoryMapper.toCategory(categoryDTO);
        categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " +id+ " not found"));
        category.setCategoryName(category.getCategoryName());
        category.setDescription(category.getDescription());
        category.setProducts(category.getProducts());
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toCategoryDTO(savedCategory);
    }

    public void deleteCategory(Integer id) {
        categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " +id + " not found"));
        categoryRepository.deleteById(id);
    }
}
