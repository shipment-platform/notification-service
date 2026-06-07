package com.danijelsudimac.notification_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@Slf4j
public class NotificationController {

    @PostMapping("/shipment-created")
    public void notifyShipmentCreated(@RequestBody ShipmentNotificationRequest request) {
        //TODO: send email
        log.info("Email sent to {}", request.email());
    }

    public record ShipmentNotificationRequest(String email, String externalId, String trackingNumber){}
}
