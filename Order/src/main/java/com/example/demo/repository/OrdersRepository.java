package com.example.demo.repository;

import com.example.demo.entity.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends PagingAndSortingRepository<Orders, Long>, CrudRepository<Orders, Long> {

}
