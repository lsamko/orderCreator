package com.volunteer.ordercreator.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponseDto {

    private String orderName;
    private String orderId;
    private Integer quantity;
    private Integer price;
    private Integer priority;

}
