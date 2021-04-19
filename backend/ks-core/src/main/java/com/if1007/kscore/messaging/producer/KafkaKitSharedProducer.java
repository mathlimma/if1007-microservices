package com.if1007.kscore.messaging.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaKitSharedProducer {

    private KafkaProducer<String, String> kafkaProducer;

    public void sendSharedKit(String id){
        log.info("Enviando Kit compartilhado com id: {}, para Análise via Kafka", id);
        try {
            kafkaProducer.send(new ProducerRecord<>("kit.share", id));
        } catch (Exception e){
            log.error("Erro ao se comunicar com tópico do Kafka",e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
