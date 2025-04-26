package com.eustachecode.eCommerce_java_app.mappers;

import com.eustachecode.eCommerce_java_app.dto.OrderDTO;
import com.eustachecode.eCommerce_java_app.models.Order;
import com.eustachecode.eCommerce_java_app.models.OrderItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-26T21:25:38+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Ubuntu)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toOrder(OrderDTO orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setOrderId( orderDto.orderId() );
        order.setOrderItems( integerListToOrderItemList( orderDto.orderItems() ) );
        order.setOrderDate( orderDto.orderDate() );
        order.setTotalAmount( orderDto.totalAmount() );

        return order;
    }

    @Override
    public OrderDTO toOrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        Integer orderId = null;
        Date orderDate = null;
        double totalAmount = 0.0d;
        List<Integer> orderItems = null;

        orderId = order.getOrderId();
        orderDate = order.getOrderDate();
        totalAmount = order.getTotalAmount();
        orderItems = orderItemListToIntegerList( order.getOrderItems() );

        Integer customerId = null;
        List<Integer> products = null;

        OrderDTO orderDTO = new OrderDTO( orderId, customerId, orderDate, totalAmount, orderItems, products );

        return orderDTO;
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
