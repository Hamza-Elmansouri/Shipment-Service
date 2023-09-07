package com.ecomerce_data_model.shipmentservice.service;

import com.ecomerce_data_model.shipmentservice.controller.ShipmentController;
import com.ecomerce_data_model.shipmentservice.entity.Shipment;
import com.ecomerce_data_model.shipmentservice.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public Optional<Shipment> getShipmentById(Long shipmentId) {
        return shipmentRepository.findById(shipmentId);
    }

    public boolean updateShipment(Long shipmentId, Shipment updatedShipment) {
        Optional<Shipment> existingShipment = shipmentRepository.findById(shipmentId);
        if (existingShipment.isPresent()) {
            updatedShipment.setShipmentId(shipmentId);
            shipmentRepository.save(updatedShipment);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteShipment(Long shipmentId) {
        Optional<Shipment> existingShipment = shipmentRepository.findById(shipmentId);
        if (existingShipment.isPresent()) {
            shipmentRepository.deleteById(shipmentId);
            return true;
        } else {
            return false;
        }
    }
}
