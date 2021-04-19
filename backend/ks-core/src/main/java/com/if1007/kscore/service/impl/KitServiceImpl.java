package com.if1007.kscore.service.impl;

import com.if1007.kscore.client.KitClient;
import com.if1007.kscore.context.IRequestContext;
import com.if1007.kscore.dto.request.KitRequest;
import com.if1007.kscore.dto.response.Content;
import com.if1007.kscore.dto.response.KitResponse;
import com.if1007.kscore.messaging.producer.KafkaKitSharedProducer;
import com.if1007.kscore.service.KitService;
import com.if1007.kscore.storage.Storage;
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
    private final KafkaKitSharedProducer kafkaKitSharedProducer;

    @Override
    public KitResponse getAll(IRequestContext context) {
        log.info("Iniciando busca de Kits no Strateegia");
        try {
            var token = storage.get(context.getCorrelationId());
            var response = kitClient.getAllKits(token, false);
            storage.delete(context.getCorrelationId());
            return response;
        } catch (Exception e) {
            log.error("Erro ao se comunicar com api do Strateegia", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Content getById(IRequestContext context, String id) {
        log.info("Iniciando busca de Kit no Strateegia com o id: {}", id);
        try {
            var token = storage.get(context.getCorrelationId());
            var response = kitClient.getById(token, id);
            storage.delete(context.getCorrelationId());
            return response;
        } catch (Exception e) {
            log.error("Erro ao se comunicar com api do Strateegia", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Content saveKit(IRequestContext context, KitRequest kitRequest) {
        log.info("Iniciando armazenamento de Kit no Strateegia");
        try {
            var token = storage.get(context.getCorrelationId());
            var response = kitClient.saveKit(token, kitRequest);
            storage.delete(context.getCorrelationId());
            return response;
        } catch (Exception e) {
            log.error("Erro ao se comunicar com api do Strateegia", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void shareKit(String id) {
        log.info("Adicionando Kit com id: {}, no tópico de kit-analysis do kafka", id);
        try {
            kafkaKitSharedProducer.sendSharedKit(id);
            log.info("Adiciona no tópico com sucesso");
        } catch (Exception e) {
            log.error("Erro ao adicionar id no tópico do kafka", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void deleteKit(String id) {
        log.info("Iniciando rotina de remoção de kit compartilhado com o id: {}", id);
        try {
            log.info("Adiciona id: {}, para remoção de kit compartilhado", id);
        } catch (Exception e) {
            log.error("Erro ao adicionar id no tópico do kafka", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
