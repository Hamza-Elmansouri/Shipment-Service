package com.ecomerce_data_model.shipmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long quantity;
    private Long price;
    private Long totalPrice;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Shipment shipment;

}
