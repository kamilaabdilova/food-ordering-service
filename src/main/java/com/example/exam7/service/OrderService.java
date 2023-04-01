package com.example.exam7.service;

import com.example.exam7.dao.OrderDao;
import com.example.exam7.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderDao orderDao;

    public OrderDto weCanSeeAllOrders(Long idClient) {

    }

    public Object addOrder(Long idClient, Long idDish) {
    }
}
