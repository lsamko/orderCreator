package com.volunteer.ordercreator.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(nullable = false, unique = true, length = 50)
    private String orderName;

    @Basic
    @Column(nullable = false)
    private Integer quantity;

    @Basic
    @Column
    private Integer price;

    @Basic
    @Column(length = 16)
    private Integer priority;

    @Basic
    @Column(unique = true, nullable = false)
    private String orderId;

    public Order(String name, int quantity,  int priority, int price, String orderId) {
        this.orderName = name;
        this.quantity = quantity;
        this.priority = priority;
        this.price = price;
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Order order = (Order) o;
        return id != null && Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
