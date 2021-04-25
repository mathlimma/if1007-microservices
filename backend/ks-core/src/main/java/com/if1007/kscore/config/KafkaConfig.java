package com.if1007.kscore.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {

    // Creates a topic with name of 'kit.share'
    @Bean
    NewTopic sharedKits() {
        return TopicBuilder.name("kit.share").partitions(6).replicas(1).build();
    }

    @Bean
    public ProducerFactory<String, String> sharedKitsProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Destination of kafka brokers
        configProps.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // Serializer for key
        configProps.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // Serializer for value
        configProps.put(
                JsonSerializer.ADD_TYPE_INFO_HEADERS,
                false); // Package name of value won't be added to header with this config

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> sharedKitsKafkaTemplate() {
        return new KafkaTemplate<>(sharedKitsProducerFactory());
    }
}