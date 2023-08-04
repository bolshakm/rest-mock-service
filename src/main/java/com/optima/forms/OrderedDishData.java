package com.optima.forms;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderedDishData {
    private DishForm dish;
    private Integer quantity;
}
