package com.project.demo.demo_test.services;

import com.project.demo.demo_test.models.K_PAC_set;

import java.util.List;

public interface K_PAC_Sets_Service {

    void addK_PAC_Set(K_PAC_set k_pac_set);

    K_PAC_set findK_PAC_SetById(Long id);

    void deleteK_PAC_Set(Long id);

    List<K_PAC_set> findAllK_PAC_Sets();

}
