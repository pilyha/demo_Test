package com.project.demo.demo_test.services.impl;

import com.project.demo.demo_test.models.K_PAC_set;
import com.project.demo.demo_test.repositories.K_PAC_Sets_Repository;
import com.project.demo.demo_test.services.K_PAC_Sets_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class K_PAC_Sets_ServiceImpl implements K_PAC_Sets_Service {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final K_PAC_Sets_Repository k_pac_sets_repository;

    @Autowired
    public K_PAC_Sets_ServiceImpl(K_PAC_Sets_Repository k_pac_sets_repository) {
        this.k_pac_sets_repository = k_pac_sets_repository;
    }

    @Override
    public void addK_PAC_Set(K_PAC_set k_pac_set) {
        if (k_pac_set != null) {
            LOGGER_INFO.info("Start create K_PAC_set: " + k_pac_set.getTitle());
            k_pac_sets_repository.save(k_pac_set);
            LOGGER_INFO.info("End create K_PAC_set: " + k_pac_set.getTitle());
        } else {
            LOGGER_ERROR.error("K_PAC_Set is null!");
        }
    }

    @Override
    public K_PAC_set findK_PAC_SetById(Long id) {
        return k_pac_sets_repository.findById(id).orElse(null);
    }

    @Override
    public void deleteK_PAC_Set(Long id) {
        if (k_pac_sets_repository.existsById(id)) {
            LOGGER_WARN.warn("Start delete K_PAC_set: " + id);
            k_pac_sets_repository.deleteById(id);
            LOGGER_WARN.warn("End delete K_PAC_set: " + id);
        } else {
            LOGGER_ERROR.error("K_PAC_Set doesn't exists");
        }
    }

    @Override
    public List<K_PAC_set> findAllK_PAC_Sets() {
        LOGGER_INFO.info("Read all K_PAC_Sets");
        return k_pac_sets_repository.findAll();
    }
}
