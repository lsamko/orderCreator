package com.volunteer.ordercreator.service;

import com.volunteer.ordercreator.dto.OrderRequestDto;
import com.volunteer.ordercreator.dto.OrderResponseDto;
import com.volunteer.ordercreator.dto.OrderUpdateDto;
import com.volunteer.ordercreator.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);

    Page<Order> findAll(Pageable pageable);

    OrderResponseDto findById(String uuid);

    OrderResponseDto deleteById(String uuid);

    OrderResponseDto updateById(String uuid, OrderUpdateDto orderUpdateDto);

}

