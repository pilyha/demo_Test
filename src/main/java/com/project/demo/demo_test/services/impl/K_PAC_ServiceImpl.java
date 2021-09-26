package com.project.demo.demo_test.services.impl;


import com.project.demo.demo_test.models.K_PAC;
import com.project.demo.demo_test.repositories.K_PAC_Repository;
import com.project.demo.demo_test.services.K_PAC_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class K_PAC_ServiceImpl implements K_PAC_Service {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final K_PAC_Repository kPacRepository;

    @Autowired
    public K_PAC_ServiceImpl(K_PAC_Repository kPacRepository) {
        this.kPacRepository = kPacRepository;
    }

    @Override
    public void addK_PAC(K_PAC k_pac) {
        if (k_pac != null) {
            LOGGER_INFO.info("Start create K_PAC: " + k_pac.getTitle());
            kPacRepository.save(k_pac);
            LOGGER_INFO.info("End create K_PAC: " + k_pac.getTitle());
        } else {
            LOGGER_ERROR.error("K_PAC is null!");
        }
    }

    @Override
    public K_PAC findK_PACById(Long id) {
        return kPacRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteK_PAC(Long id) {
        if (kPacRepository.existsById(id)) {
            LOGGER_WARN.warn("Start delete K_PAC: " + id);
            kPacRepository.deleteById(id);
            LOGGER_WARN.warn("End delete K_PAC: " + id);
        } else {
            LOGGER_ERROR.error("K_PAC doesn't exists");
        }
    }

    @Override
    public List<K_PAC> findAllK_PACs() {
        LOGGER_INFO.info("Read all k_pacs");
        return kPacRepository.findAll();
    }
}
