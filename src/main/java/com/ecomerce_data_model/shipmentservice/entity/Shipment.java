package com.ecomerce_data_model.shipmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shipmentId;
    @ManyToOne
    private Account account;
    @OneToOne
    private Address shippingAddress;
    @ManyToOne
    private OrderLine orderLineItems;
    private Date shippedDate;
    private Date deliveryDate;
}
