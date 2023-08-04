package com.optima.forms;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OrderForm {
    private Integer tableNumber;
    private Map<Long, Integer> orderedDishes;

}
