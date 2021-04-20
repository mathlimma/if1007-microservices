package com.if1007.ksanalysis.consumer;

import com.if1007.ksanalysis.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ShareKitStreamConsumer {

    private final AnalysisService analysisService;

    @Autowired
    public void process(StreamsBuilder builder) {
        log.info("Recebendo stream de dados");

        Serde<String> keySerde = Serdes.String();
        Serde<String> valueSerde = Serdes.String();

        builder.stream("kit.share", Consumed.with(keySerde, valueSerde))
                .foreach((key, value) -> this.analyseKit(value));
    }

    private void analyseKit(String id) {
       log.info("Analisando kit com id: {}", id);
       var response = analysisService.getById(id);
    }
}