package com.project.demo.demo_test.controllers;


import com.project.demo.demo_test.models.K_PAC;
import com.project.demo.demo_test.models.K_PAC_set;
import com.project.demo.demo_test.services.K_PAC_Service;
import com.project.demo.demo_test.services.K_PAC_Sets_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/kpacs")
public class K_PAC_Controller {

    private final K_PAC_Service k_pac_service;
    private final K_PAC_Sets_Service k_pac_sets_service;

    @Autowired
    public K_PAC_Controller(K_PAC_Service k_pac_service, K_PAC_Sets_Service k_pac_sets_service) {
        this.k_pac_service = k_pac_service;
        this.k_pac_sets_service = k_pac_sets_service;
    }

    @GetMapping()
    public String displayK_PACs(@ModelAttribute("kpac") K_PAC kPac, Model model) {
        List<K_PAC_set> k_pac_sets = k_pac_sets_service.findAllK_PAC_Sets();
        List<K_PAC> k_pacList = k_pac_service.findAllK_PACs();
        model.addAttribute("kpacs", k_pacList);
        model.addAttribute("kpac_set", k_pac_sets);
        return "k_pac.jsp";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("kpac") K_PAC kPac, BindingResult result) {
        if (result.hasErrors()) {
            return "error.jsp";
        } else {
            k_pac_service.addK_PAC(kPac);
            return "redirect:/kpacs";
        }
    }

    @DeleteMapping(value = "/{id}")
    public String deleteK_PAC(@PathVariable("id") Long id) {
        k_pac_service.deleteK_PAC(id);
        return "redirect:/kpacs";
    }
}


