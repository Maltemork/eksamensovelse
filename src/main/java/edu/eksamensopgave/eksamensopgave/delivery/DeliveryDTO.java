package edu.eksamensopgave.eksamensopgave.delivery;

import java.util.Date;

public record DeliveryDTO(int deliveryId, Date deliveryDate, String deliveryTime, String deliveryAddress) {
}
