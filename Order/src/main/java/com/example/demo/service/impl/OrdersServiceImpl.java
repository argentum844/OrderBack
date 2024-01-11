package com.example.demo.service.impl;

import com.example.demo.entity.Orders;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@AllArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private OrdersRepository ordersRepository;

    @Override
    public Orders getOrderById(Long id) {
        return ordersRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("There is no product with id=" + id));
    }

    @Override
    public Page<Orders> getOrders(Pageable pageable) {
        return ordersRepository.findAll(pageable);
    }

    @Override
    public Orders addOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Orders updateOrder(Long id, Orders orders) {
        if (!id.equals(orders.getId())) {
            throw new RuntimeException("Id`s should be equaled.");
        }
        if (!ordersRepository.existsById(id)) {
            throw new RuntimeException("Product with id=" + id + " must be created.");
        }
        return ordersRepository.save(orders);
    }

    @Override
    public void deleteOrderById(Long id) {
        if (!ordersRepository.existsById(id)) {
            throw new RuntimeException("Product with id=" + id + " cannot be deleted.");
        }
        ordersRepository.deleteById(id);
    }

}
