package com.volunteer.ordercreator.repository;

import com.volunteer.ordercreator.entity.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findOrderById(String uuid);

    Optional<Order> deleteOrderByOrderId(String uuid);

    boolean existsOrderByOrderName(String name);
}
