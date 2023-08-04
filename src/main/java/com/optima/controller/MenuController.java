package com.optima.controller;

import com.optima.service.MenuService;
import com.optima.util.PageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu/view")
    public String vew(Model model) {
        model.addAttribute("selectedMenu", menuService.getMock());

        return PageConstants.MENU_VIEW;

    }

    @GetMapping("/menu/view/v2")
    public String vewv2(Model model) {
        model.addAttribute("selectedMenu", menuService.getMock());

        return PageConstants.MENU;
    }

}
