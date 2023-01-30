package com.volunteer.ordercreator.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderResponseDto {

    private String orderName;
    private String orderId;
    private Integer quantity;
    private Double price;
    private Integer priority;

}
