package com.volunteer.ordercreator.controller;

import com.volunteer.ordercreator.dto.OrderRequestDto;
import com.volunteer.ordercreator.dto.OrderResponseDto;
import com.volunteer.ordercreator.dto.OrderUpdateDto;
import com.volunteer.ordercreator.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDto createOrder(@Valid @RequestBody OrderRequestDto orderRequestDto) {
        return orderService.createOrder(orderRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<OrderResponseDto> getAllOrders(@NotNull Pageable pageable){
        return orderService.findAll(pageable);
    }

    @GetMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponseDto getOrderById(@PathVariable String uuid) {
        return orderService.findById(uuid);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponseDto deleteOrderById(@PathVariable String uuid) {
        return orderService.deleteById(uuid);
    }

    @PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponseDto updateOrder(@Valid @RequestBody OrderUpdateDto orderUpdateDto, @PathVariable String uuid) {
        return orderService.updateById(uuid, orderUpdateDto);
    }
}
