package com.example.demo.service;

import com.example.demo.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrdersService {

    Orders getOrderById(Long id);

    Page<Orders> getOrders(Pageable pageable);

    Orders addOrder(Orders orders);

    Orders updateOrder(Long id, Orders orders);

    void deleteOrderById(Long id);

}
