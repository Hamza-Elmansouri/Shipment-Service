package com.ecomerce_data_model.shipmentservice.repository;

import com.ecomerce_data_model.shipmentservice.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
