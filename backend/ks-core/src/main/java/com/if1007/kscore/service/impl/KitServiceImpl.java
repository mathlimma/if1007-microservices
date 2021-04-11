package com.if1007.kscore.service.impl;

import com.if1007.kscore.client.KitClient;
import com.if1007.kscore.context.IRequestContext;
import com.if1007.kscore.dto.response.Content;
import com.if1007.kscore.dto.response.KitResponse;
import com.if1007.kscore.service.KitService;
import com.if1007.kscore.store.Storage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class KitServiceImpl implements KitService {

    private final Storage storage;
    private final KitClient kitClient;

    @Override
    public KitResponse getAll(IRequestContext context) {
        log.info("Iniciando busca de Kits no Strateegia");
        try {
            var token = storage.get(context.getCorrelationId());
            var response = kitClient.getAllKits(token, false);
            storage.delete(context.getCorrelationId());
            return response;
        } catch (Exception e){
            log.error("Erro ao se comunicar com api do Strateegia", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Content getById(IRequestContext context, String id) {
        log.info("Iniciando busca de Kit no Strateegia por ID");
        try {
            var token = storage.get(context.getCorrelationId());
            var response = kitClient.getById(token, id);
            storage.delete(context.getCorrelationId());
            return response;
        } catch (Exception e){
            log.error("Erro ao se comunicar com api do Strateegia", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
