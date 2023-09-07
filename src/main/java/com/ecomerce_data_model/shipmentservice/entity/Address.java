package com.ecomerce_data_model.shipmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    private String street;
    private String aptBuilding;
    private String city;
    private String stateProvince;
    private String zipCode;
    private String country;

    @ManyToOne
    private Account account;
}
