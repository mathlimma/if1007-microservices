package com.if1007.ksanalysis.service.impl;

import com.if1007.ksanalysis.dto.Content;
import com.if1007.ksanalysis.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnalysisServiceImpl implements AnalysisService {

    //private final KitClient kitClient;

    @Override
    public Content getById(String id) {
        log.info("Iniciando busca de Kit no ks-core");
        try {
            //TODO: buscar kit via ks-core
            return null;
        } catch (Exception e) {
            log.error("Erro ao se comunicar com ks-core", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
