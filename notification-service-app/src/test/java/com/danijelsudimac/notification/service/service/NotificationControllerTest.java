package com.danijelsudimac.notification.service.service;

import com.danijelsudimac.notification.service.controller.NotificationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NotificationController.class)
class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldSendShipmentCreatedNotification() throws Exception {
        NotificationController.ShipmentNotificationRequest request =
                new NotificationController.ShipmentNotificationRequest("test@mail.com", "EXT-123","TRACK-123");

        mockMvc.perform(post("/notifications/shipment-created").contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnBadRequestWhenBodyMissing() throws Exception {
        mockMvc.perform(post("/notifications/shipment-created").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
