package com.volunteer.ordercreator.controller;

import com.volunteer.ordercreator.dto.OrderRequestDto;
import com.volunteer.ordercreator.dto.OrderResponseDto;
import com.volunteer.ordercreator.dto.OrderUpdateDto;
import com.volunteer.ordercreator.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController implements OrdersApi {

    private final OrderService orderService;

    @Override
    public ResponseEntity<OrderResponseDto> createOrder(OrderRequestDto orderRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(orderRequestDto));
    }

    @Override
    public ResponseEntity<List<OrderResponseDto>> getAllOrders(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAll(pageable).getContent());
    }

    @Override
    public ResponseEntity<OrderResponseDto> getOrderById(String uuid) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(uuid));
    }

    @Override
    public ResponseEntity<Void> deleteOrderById(String uuid) {
        orderService.deleteById(uuid);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<OrderResponseDto> updateOrder(String uuid,
        OrderUpdateDto orderUpdateDto) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateById(uuid, orderUpdateDto));
    }
}
