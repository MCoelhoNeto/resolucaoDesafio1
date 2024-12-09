package com.devsuperior.aula.service;

import com.devsuperior.aula.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order){
        double discountAmount = order.getBasic() * (order.getDiscount() / 100.0);
        double subTotal = order.getBasic() - discountAmount;
        double shipping = this.shippingService.shipment(order);
        double total = subTotal + shipping;

        return total;
    }

}
