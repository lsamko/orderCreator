package com.volunteer.ordercreator.mapper;

import com.volunteer.ordercreator.dto.OrderRequestDto;
import com.volunteer.ordercreator.dto.OrderResponseDto;
import com.volunteer.ordercreator.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "orderId", expression = "java(java.util.UUID.randomUUID().toString())")
    Order fromRequestDtoToEntity(OrderRequestDto requestDto);

    OrderResponseDto fromEntityToResponseDto(Order order);

}
