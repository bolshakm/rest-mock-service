package com.optima.forms;

import lombok.Data;

import java.util.List;

@Data
public class CategoryForm {
    private Long id;
    private String name;
    private String description;
    private List<DishForm> dishes;
}
