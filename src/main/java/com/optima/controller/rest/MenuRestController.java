package com.optima.controller.rest;

import com.optima.forms.CafeForm;
import com.optima.forms.MenuForm;
import com.optima.forms.OrderData;
import com.optima.forms.OrderForm;
import com.optima.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MenuRestController {
    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/api/v1/menu/view/{cafe}/{tableNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MenuForm> view(@PathVariable Integer cafe, @PathVariable Integer tableNumber) {
        return ResponseEntity.ok(menuService.getMock());
    }

    @GetMapping(value = "/api/v1/bill/{cafe}/{tableNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> bill(@PathVariable Integer cafe, @PathVariable Integer tableNumber, @RequestParam String type) {
        return ResponseEntity.ok("Success request for bill for table #" + tableNumber +". Payment is " + type);
    }

    @PostMapping(value = "/api/v1/order/place/{cafe}/{tableNumber}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderData> placeOrder(@PathVariable Integer cafe, @PathVariable Integer tableNumber, @RequestBody OrderForm orderForm) {

        return ResponseEntity.ok(menuService.place(orderForm));
    }

//    @PostMapping(value = "/api/v1/order/place", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<OrderData> placeOrder(@RequestBody OrderForm orderForm) {
//
//        return ResponseEntity.ok(menuService.place(orderForm));
//    }

    @GetMapping(value = "/api/v1/order/{cafe}/{tableNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderData> order(@PathVariable Integer cafe, @PathVariable Integer tableNumber) {
        return ResponseEntity.ok(menuService.order());
    }

    @GetMapping(value = "/api/v1/cafe/{cafe}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CafeForm> cafe(@PathVariable Integer cafe) {
        Map<String, String> workingHours = new HashMap<>();
        workingHours.put("Mon", "9:00-21:00");
        workingHours.put("Tue", "9:00-21:00");
        workingHours.put("Wed", "9:00-21:00");
        workingHours.put("Thu", "9:00-21:00");
        workingHours.put("Fri", "9:00-21:00");
        workingHours.put("Sat", "9:00-21:00");
        workingHours.put("Sun", "9:00-17:00");
        CafeForm result = CafeForm.builder()
                .name("Summertime cafe")
                .address("Streat 2/3")
                .facebook("https://www.facebook.com")
                .instagram("https://www.instagram.com")
                .tripAdvisor("https://www.tripadvisor.com")
                .workingHours(workingHours)
                .build();
        return ResponseEntity.ok(result);
    }


}
