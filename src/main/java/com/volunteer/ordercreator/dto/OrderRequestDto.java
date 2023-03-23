package com.volunteer.ordercreator.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderRequestDto {

    @NotNull(message = "Order name can not be empty")
    @Size(min = 3, max = 50)
    private String orderName;

    @NotNull(message = "Please specify how many items would you like to order")
    @Size(min = 1, max = 100)
    private Integer quantity;

    @Min(1)
    private Double price;

    @Min(1)
    @Max(5)
    private Integer priority;

}
