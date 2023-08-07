package com.optima.forms;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class CafeForm {
//    private Long id;
    private String name;
//    private String description;
    private String address;
    private Map<String, String> workingHours;
    private String facebook;
    private String instagram;
    private String tripAdvisor;
}
