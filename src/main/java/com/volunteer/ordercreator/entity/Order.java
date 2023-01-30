package com.volunteer.ordercreator.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor
@Data
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
    private Double price;

    @Basic
    @Column(length = 16)
    private Integer priority;

    @Basic
    @Column(unique = true, nullable = false)
    private String orderId;


}
