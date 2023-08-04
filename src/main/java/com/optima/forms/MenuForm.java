package com.optima.forms;

import lombok.Data;

import java.util.List;

@Data
public class MenuForm {
    private Long id;
    private String name;
    private boolean isActive;
    private List<CategoryForm> categories;
}
