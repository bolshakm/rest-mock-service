package com.optima.forms;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
public class OrderData {
    private List<OrderedDishData> orderedDish;
    private BigDecimal totalSum;
}
