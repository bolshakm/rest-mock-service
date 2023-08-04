package com.optima.forms;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DishForm {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
