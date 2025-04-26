package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.ProductDTO;
import com.eustachecode.eCommerce_java_app.models.Category;
import com.eustachecode.eCommerce_java_app.models.OrderItem;
import com.eustachecode.eCommerce_java_app.models.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-26T21:25:38+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Ubuntu)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductId( dto.productId() );
        product.setProductName( dto.productName() );
        product.setPrice( dto.price() );
        product.setCategory( dto.category() );
        product.setOrderItems( integerListToOrderItemList( dto.orderItems() ) );

        return product;
    }

    @Override
    public ProductDTO toProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        Integer productId = null;
        String productName = null;
        double price = 0.0d;
        Category category = null;
        List<Integer> orderItems = null;

        productId = product.getProductId();
        productName = product.getProductName();
        price = product.getPrice();
        category = product.getCategory();
        orderItems = orderItemListToIntegerList( product.getOrderItems() );

        int stock = 0;

        ProductDTO productDTO = new ProductDTO( productId, productName, stock, price, category, orderItems );

        return productDTO;
    }

    protected List<OrderItem> integerListToOrderItemList(List<Integer> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItem> list1 = new ArrayList<OrderItem>( list.size() );
        for ( Integer integer : list ) {
            list1.add( map( integer ) );
        }

        return list1;
    }

    protected List<Integer> orderItemListToIntegerList(List<OrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<Integer> list1 = new ArrayList<Integer>( list.size() );
        for ( OrderItem orderItem : list ) {
            list1.add( map( orderItem ) );
        }

        return list1;
    }
}
