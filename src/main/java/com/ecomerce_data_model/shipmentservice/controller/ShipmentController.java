package com.ecomerce_data_model.shipmentservice.controller;

import com.ecomerce_data_model.shipmentservice.entity.Shipment;
import com.ecomerce_data_model.shipmentservice.repository.ShipmentRepository;
import com.ecomerce_data_model.shipmentservice.service.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shipments")
@Slf4j
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService){
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public ResponseEntity<Shipment> createShipment(@RequestBody Shipment shipment) {
        log.info("inside createShipment in ShipmentController");
        Shipment createdShipment = shipmentService.createShipment(shipment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShipment);
    }

    @GetMapping("/{shipment_id}")
    public ResponseEntity<Shipment> getShipment(@PathVariable("shipment_id") Long shipmentId) {
        log.info("inside getShipment in ShipmentController");
        Optional<Shipment> shipment = shipmentService.getShipmentById(shipmentId);
        if (shipment.isPresent()) {
            return ResponseEntity.ok(shipment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{shipment_id}")
    public ResponseEntity<String> updateShipment(@PathVariable("shipment_id") Long shipmentId, @RequestBody Shipment shipment) {
        log.info("inside updateShipment in ShipmentController");
        boolean updated = shipmentService.updateShipment(shipmentId, shipment);
        if (updated) {
            return ResponseEntity.ok("Shipment updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{shipment_id}")
    public ResponseEntity<String> deleteShipment(@PathVariable("shipment_id") Long shipmentId) {
        log.info("inside deleteShipment in ShipmentController");
        boolean deleted = shipmentService.deleteShipment(shipmentId);
        if (deleted) {
            return ResponseEntity.ok("Shipment deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
