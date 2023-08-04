package com.optima.controller;

import com.optima.service.MenuService;
import com.optima.util.PageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu/view")
    public String vew(Model model) {
        model.addAttribute("selectedMenu", menuService.getMock());
//        model.addAttribute("isMenuVewPage", true);

        return PageConstants.MENU_VIEW;

    }
}
