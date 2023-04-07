package com.volunteer.ordercreator.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.volunteer.ordercreator.dto.OrderRequestDto;
import com.volunteer.ordercreator.entity.Order;
import com.volunteer.ordercreator.exception.OrderNotFoundException;
import com.volunteer.ordercreator.exception.OrderWithNameAlreadyExistsException;
import com.volunteer.ordercreator.mapper.OrderMapper;
import com.volunteer.ordercreator.mapper.OrderMapperImpl;
import com.volunteer.ordercreator.repository.OrderRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    public static final String ORDER_NAME = "Himars";
    private static final int ORDER_PRIORITY = 1;
    private static final int ORDER_QUANTITY = 5;
    private static final int ORDER_PRICE = 1000000;
    private final String id = "89765";
    private final Order EXAMPLE = new Order(
        "Pistol", 3, 100, 45000, "89765");


    @Captor
    ArgumentCaptor<Order> orderCaptor;
    @Captor
    ArgumentCaptor<String> idCaptor;
    @Mock
    private OrderRepository orderRepository;

    private OrderServiceImpl orderService;
    private OrderRequestDto orderRequestDto;
    private final OrderMapper orderMapper = new OrderMapperImpl();

    @BeforeEach
    void setUp() {
        orderService = new OrderServiceImpl(orderRepository, orderMapper);
        orderRequestDto = new OrderRequestDto();
        orderRequestDto.setOrderName(ORDER_NAME);
        orderRequestDto.setPriority(ORDER_PRIORITY);
        orderRequestDto.setQuantity(ORDER_QUANTITY);
        orderRequestDto.setPrice(ORDER_PRICE);

        Order myOrder = new Order();
        myOrder.setOrderName(ORDER_NAME);
        myOrder.setQuantity(ORDER_QUANTITY);
        myOrder.setPriority(ORDER_PRIORITY);
        myOrder.setPrice(ORDER_PRICE);
    }

    @Test
    void createOrderTest() {
        when(orderRepository.existsOrderByOrderName(ORDER_NAME)).thenReturn(false);
        orderService.createOrder(orderRequestDto);
        verify(orderRepository, times(1)).save(orderCaptor.capture());
        Order captureOrder = orderCaptor.getValue();
        assertNotNull(captureOrder.getOrderId());
        assertEquals(ORDER_NAME, captureOrder.getOrderName());
        assertEquals(ORDER_PRIORITY, captureOrder.getPriority());
        assertEquals(ORDER_QUANTITY, captureOrder.getQuantity());
        assertEquals(ORDER_PRICE, captureOrder.getPrice());
    }

    @Test
    void createOrderWithExistingNameTest() {
        when(orderRepository.existsOrderByOrderName(ORDER_NAME)).thenReturn(true);
        assertThrows(OrderWithNameAlreadyExistsException.class,
            () -> orderService.createOrder(orderRequestDto), "Order with name '" + ORDER_NAME + "' already exists");
        verify(orderRepository, never()).save(any());
    }

    @Test
    void findOrderByIdTest() {
        when(orderRepository.findOrderById(idCaptor.capture())).thenReturn(Optional.of(EXAMPLE));
        orderService.findById(id);
        String value = idCaptor.getValue();
        assertThat(value, is(equalTo(id)));
    }

    @Test
    void findOrderByIdNotFoundTest() {
        String id = "876";
        when(orderRepository.findOrderById(idCaptor.capture())).thenReturn(Optional.empty());
        assertThrows(OrderNotFoundException.class,
            () -> orderService.findById(id), "Could not find order: " + id);

        String value = idCaptor.getValue();
        assertThat(value, is(equalTo(id)));
    }


}
