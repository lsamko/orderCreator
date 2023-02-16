package com.volunteer.ordercreator.service;

import com.volunteer.ordercreator.dto.OrderRequestDto;
import com.volunteer.ordercreator.dto.OrderResponseDto;
import com.volunteer.ordercreator.dto.OrderUpdateDto;
import com.volunteer.ordercreator.entity.Order;
import com.volunteer.ordercreator.exception.OrderNotFoundException;
import com.volunteer.ordercreator.exception.OrderWithNameAlreadyExistsException;
import com.volunteer.ordercreator.mapper.OrderMapper;
import com.volunteer.ordercreator.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        Order order = orderMapper.fromRequestDtoToEntity(orderRequestDto);
        String orderName = orderRequestDto.getOrderName();
        if (this.orderNameExists(orderName)) {

            throw new OrderWithNameAlreadyExistsException(
                String.format(orderName));
        }
        Order orderToSave = orderRepository.save(order);
        return orderMapper.fromEntityToResponseDto(orderToSave);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public OrderResponseDto findById(String uuid) {
        Order order = orderRepository.findOrderById(uuid)

            .orElseThrow(() -> new OrderNotFoundException(uuid));
        return orderMapper.fromEntityToResponseDto(order);
    }

    @Override
    public OrderResponseDto deleteById(String uuid) {
        Order order = orderRepository.deleteOrderByOrderId(uuid)

            .orElseThrow(() -> new OrderNotFoundException(uuid));
        return orderMapper.fromEntityToResponseDto(order);
    }

    @Override
    public OrderResponseDto updateById(String uuid, OrderUpdateDto orderUpdateDto) {
        Order nameToUpdate = orderRepository.findOrderById(uuid)

            .orElseThrow(() -> new OrderNotFoundException(uuid));
        String newOrderName = orderUpdateDto.getOrderName();
        if (this.orderNameChanged(nameToUpdate, newOrderName) && this.orderNameExists(newOrderName)) {

            throw new OrderWithNameAlreadyExistsException(
                String.format("Order with name '%s' already exists", newOrderName));
        }
        nameToUpdate.setOrderName(newOrderName);
        orderRepository.save(nameToUpdate);
        return orderMapper.fromEntityToResponseDto(nameToUpdate);
    }

    private boolean orderNameExists(String orderName) {
        return orderRepository.existsOrderByOrderName(orderName);
    }

    private boolean orderNameChanged(Order nameToUpdate, String orderName) {
        return !nameToUpdate.getOrderName().equals(orderName);
    }
}
