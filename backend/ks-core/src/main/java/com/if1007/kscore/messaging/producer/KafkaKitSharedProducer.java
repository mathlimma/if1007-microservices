package com.if1007.kscore.messaging.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.if1007.kscore.dto.response.Content;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaKitSharedProducer {

    private final KafkaTemplate<String, String> sharedKitsKafkaTemplate;
    private final ObjectMapper mapper;

    public void sendSharedKit(Content content){
        try {
            var contentJson = mapper.writeValueAsString(mapper);
            log.info("Enviando Kit compartilhado: {}, para Análise via Kafka", contentJson);
            sharedKitsKafkaTemplate.send("kit.share", contentJson);
        } catch (Exception e){
            log.error("Erro ao se comunicar com tópico do Kafka",e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
