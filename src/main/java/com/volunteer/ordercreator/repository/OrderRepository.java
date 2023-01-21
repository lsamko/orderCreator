package com.volunteer.ordercreator.repository;

import com.volunteer.ordercreator.entity.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {

    Optional<Order> findOrderId(String uuid);

    Optional<Order> deleteOrderByOrderId(String uuid);

    List<Order> findOrdersByOrderIdIn(List<String> ids);

    boolean existsOrderByName(String name);
}
