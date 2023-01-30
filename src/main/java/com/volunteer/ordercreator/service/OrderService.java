package com.volunteer.ordercreator.service;

import com.volunteer.ordercreator.dto.OrderRequestDto;
import com.volunteer.ordercreator.dto.OrderResponseDto;
import com.volunteer.ordercreator.dto.OrderUpdateDto;
import java.util.List;

public interface OrderService {

    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);

    List<OrderResponseDto> findAll(Integer from, Integer size);

    OrderResponseDto findById(String uuid);

    OrderResponseDto deleteById(String uuid);

    OrderResponseDto updateById(String uuid, OrderUpdateDto orderUpdateDto);

}

