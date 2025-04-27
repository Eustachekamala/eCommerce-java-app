package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.CategoryDTO;
import com.eustachecode.eCommerce_java_app.models.Category;
import com.eustachecode.eCommerce_java_app.models.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-27T01:56:38+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Ubuntu)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( categoryDTO.categoryId() );
        category.setCategoryName( categoryDTO.categoryName() );
        category.setDescription( categoryDTO.description() );
        category.setProducts( integerListToProductList( categoryDTO.products() ) );

        return category;
    }

    @Override
    public CategoryDTO toCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        Integer categoryId = null;
        String categoryName = null;
        String description = null;
        List<Integer> products = null;

        categoryId = category.getCategoryId();
        categoryName = category.getCategoryName();
        description = category.getDescription();
        products = productListToIntegerList( category.getProducts() );

        CategoryDTO categoryDTO = new CategoryDTO( categoryId, categoryName, description, products );

        return categoryDTO;
    }

    protected List<Product> integerListToProductList(List<Integer> list) {
        if ( list == null ) {
            return null;
        }

        List<Product> list1 = new ArrayList<Product>( list.size() );
        for ( Integer integer : list ) {
            list1.add( map( integer ) );
        }

        return list1;
    }

    protected List<Integer> productListToIntegerList(List<Product> list) {
        if ( list == null ) {
            return null;
        }

        List<Integer> list1 = new ArrayList<Integer>( list.size() );
        for ( Product product : list ) {
            list1.add( map( product ) );
        }

        return list1;
    }
}
