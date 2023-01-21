package com.volunteer.ordercreator.service;

import com.volunteer.ordercreator.dto.OrderRequestDto;
import com.volunteer.ordercreator.dto.OrderResponseDto;
import com.volunteer.ordercreator.dto.OrderUpdateDto;
import com.volunteer.ordercreator.mapper.OrderMapper;
import com.volunteer.ordercreator.repository.OrderRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        return null;
    }

    @Override
    public List<OrderResponseDto> findAll(Integer from, Integer size) {
        return null;
    }

    @Override
    public OrderResponseDto findById(String uuid) {
        return null;
    }

    @Override
    public OrderResponseDto deleteById(String uuid) {
        return null;
    }

    @Override
    public OrderResponseDto updateById(String uuid, OrderUpdateDto orderUpdateDto) {
        return null;
    }
}
