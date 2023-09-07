package com.ecomerce_data_model.shipmentservice;

import com.ecomerce_data_model.shipmentservice.controller.ShipmentController;
import com.ecomerce_data_model.shipmentservice.entity.Shipment;
import com.ecomerce_data_model.shipmentservice.service.ShipmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShipmentControllerTest {

    private ShipmentController shipmentController;

    @Mock
    private ShipmentService shipmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        shipmentController = new ShipmentController(shipmentService);
    }

    @Test
    void testCreateShipment() {
        Shipment shipment = new Shipment();
        Shipment createdShipment = new Shipment();
        when(shipmentService.createShipment(shipment)).thenReturn(createdShipment);

        ResponseEntity<Shipment> response = shipmentController.createShipment(shipment);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdShipment, response.getBody());
    }

    @Test
    void testGetShipment() {
        Long shipmentId = 1L;
        Shipment shipment = new Shipment();
        when(shipmentService.getShipmentById(shipmentId)).thenReturn(Optional.of(shipment));

        ResponseEntity<Shipment> response = shipmentController.getShipment(shipmentId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(shipment, response.getBody());
    }

    @Test
    void testGetNotFoundShipment() {
        Long shipmentId = 1L;
        when(shipmentService.getShipmentById(shipmentId)).thenReturn(Optional.empty());

        ResponseEntity<Shipment> response = shipmentController.getShipment(shipmentId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testUpdateShipment() {
        Shipment shipment = new Shipment();
        shipment.setShipmentId(1L);

        when(shipmentService.updateShipment(eq(1L), any(Shipment.class))).thenReturn(true);

        ResponseEntity<String> response = shipmentController.updateShipment(1L, shipment);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Shipment updated successfully", response.getBody());

        verify(shipmentService).updateShipment(eq(1L), any(Shipment.class));
    }

    @Test
    void testUpdateShipmentNotFound() {
        Shipment shipment = new Shipment();
        shipment.setShipmentId(1L);

        when(shipmentService.updateShipment(eq(1L), any(Shipment.class))).thenReturn(false);

        ResponseEntity<String> response = shipmentController.updateShipment(1L, shipment);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(shipmentService).updateShipment(eq(1L), any(Shipment.class));
    }

    @Test
    void testDeleteShipment() {
        when(shipmentService.deleteShipment(1L)).thenReturn(true);

        ResponseEntity<String> response = shipmentController.deleteShipment(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Shipment deleted successfully", response.getBody());

        verify(shipmentService).deleteShipment(1L);
    }

    @Test
    void testDeleteShipmentNotFound() {
        when(shipmentService.deleteShipment(1L)).thenReturn(false);

        ResponseEntity<String> response = shipmentController.deleteShipment(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(shipmentService).deleteShipment(1L);
    }
}
