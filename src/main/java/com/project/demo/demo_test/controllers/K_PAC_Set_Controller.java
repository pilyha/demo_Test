package com.project.demo.demo_test.controllers;

import com.project.demo.demo_test.models.K_PAC;
import com.project.demo.demo_test.models.K_PAC_set;
import com.project.demo.demo_test.services.K_PAC_Sets_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/kpac-sets")
public class K_PAC_Set_Controller {

    private final K_PAC_Sets_Service k_pac_sets_service;

    @Autowired
    public K_PAC_Set_Controller(K_PAC_Sets_Service k_pac_sets_service) {
        this.k_pac_sets_service = k_pac_sets_service;
    }

    @GetMapping()
    public String displayK_PAC_sets(@ModelAttribute("kpac_set") K_PAC_set kPacSet, Model model) {
        List<K_PAC_set> k_pac_sets = k_pac_sets_service.findAllK_PAC_Sets();
        model.addAttribute("kpac_sets", k_pac_sets);
        return "sets.jsp";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("kPacSet") K_PAC_set kPacSet, BindingResult result) {
        if (result.hasErrors()) {
            return "error.jsp";
        } else {
            k_pac_sets_service.addK_PAC_Set(kPacSet);
            return "redirect:/kpac-sets";
        }
    }

    @DeleteMapping(value = "/{id}")
    public String deleteK_PAC_set(@PathVariable("id") Long id) {
        k_pac_sets_service.deleteK_PAC_Set(id);
        return "redirect:/kpac-sets";
    }

    @GetMapping(value = "/{id}")
    public String displaySet(@PathVariable("id") Long id, Model model) {
        K_PAC_set kPacSet = k_pac_sets_service.findK_PAC_SetById(id);
        List<K_PAC> k_pacList = kPacSet.getK_pacs();
        model.addAttribute("kpac_set", kPacSet);
        return "k_pac_set.jsp";
    }

}
