package com.optima.controller.rest;

import com.optima.forms.MenuForm;
import com.optima.forms.OrderData;
import com.optima.forms.OrderForm;
import com.optima.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuRestController {
    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/api/v1/menu/view/{tableNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MenuForm> view(@PathVariable Integer tableNumber) {
        System.out.println(tableNumber);
        return ResponseEntity.ok(menuService.getMock());
    }

    @PostMapping(value = "/api/v1/order/place/{tableNumber}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderData> placeOrder(@PathVariable Integer tableNumber, @RequestBody OrderForm orderForm) {
        System.out.println(tableNumber);

        return ResponseEntity.ok(menuService.place(orderForm));
    }
}
