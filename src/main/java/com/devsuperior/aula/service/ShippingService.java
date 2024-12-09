package com.devsuperior.aula.service;

import com.devsuperior.aula.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {

        double valorBasico = order.getBasic();

        if (valorBasico < 100.00) {
            return 20.00;
        } else if (valorBasico < 200.00) {
            return 12.00;
        } else {
            return 0.00;
        }
    }
}
