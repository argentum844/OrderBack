package com.example.demo.controller;

import com.example.demo.dto.PageDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Orders;
import com.example.demo.service.OrdersService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrdersController {

    private OrdersService ordersService;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id) {
        return ordersService.getOrderById(id);
    }

    @GetMapping
    public Page<Orders> getOrders(PageDto pageDto) {
        return ordersService.getOrders(pageDto.getPageable());
    }

    @PostMapping
    public Orders addOrder(@RequestBody OrderDto orderDto) {
        Orders orders = modelMapper.map(orderDto, Orders.class);
        return ordersService.addOrder(orders);
    }

    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders orders) {
        return ordersService.updateOrder(id, orders);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        ordersService.deleteOrderById(id);
    }

}
