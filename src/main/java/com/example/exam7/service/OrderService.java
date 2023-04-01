package com.example.exam7.service;

import com.example.exam7.dao.OrderDao;
import com.example.exam7.dto.OrderDto;
import com.example.exam7.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderDao orderDao;


    public List<OrderDto> getMyOrders(long myId) {
        List<Order> orders = orderDao.getMyOrders(myId);
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order o : orders) {
            OrderDto orderDto = new OrderDto();
            orderDto.setClient(o.getClient().getName());
            orderDto.setDish(DishService.makeDishDto(o.getDish()));
            orderDto.setDateOrder(o.getDateOrder());
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }

    public String addOrder(long clientId, long dishId) {
        try {
            orderDao.addOrder(clientId, dishId);
            return "Ok";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
