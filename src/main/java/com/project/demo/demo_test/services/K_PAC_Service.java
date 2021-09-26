package com.project.demo.demo_test.services;

import com.project.demo.demo_test.models.K_PAC;

import java.util.List;

public interface K_PAC_Service {

    void addK_PAC(K_PAC k_pac);

    K_PAC findK_PACById(Long id);

    void deleteK_PAC(Long id);

    List<K_PAC> findAllK_PACs();

}
