package com.if1007.ksanalysis.consumer;

import com.google.pubsub.v1.PubsubMessage;
import com.if1007.ksanalysis.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer extends PubSubConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

    private final AnalysisService analysisService;

    @Autowired
    private PubSubTemplate pubSubTemplate;

    @Value("${pubsub.subscription}")
    private String subscription;

    @Override
    public String subscription() {
        return this.subscription;
    }

    @Override
    protected void consume(BasicAcknowledgeablePubsubMessage basicAcknowledgeablePubsubMessage) {

        PubsubMessage message = basicAcknowledgeablePubsubMessage.getPubsubMessage();
        try {
            analysisService.analyseSharedKit(message.getData().toStringUtf8());
            System.out.println(message.getData().toStringUtf8());
            System.out.println(message.getAttributesMap());
            String objectName = message.getAttributesMap().get("objectId");
            String bucketName = message.getAttributesMap().get("bucketId");
            String eventType = message.getAttributesMap().get("eventType");

            LOG.info("Event Type:::::" + eventType);
            LOG.info("File Name::::::" + objectName);
            LOG.info("Bucket Name::::" + bucketName);


        }catch(Exception ex) {
            LOG.error("Error Occured while receiving pubsub message:::::", ex);
        }
        basicAcknowledgeablePubsubMessage.ack();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void subscribe() {
        LOG.info("Subscribing {} to {} ", this.getClass().getSimpleName(), this.subscription());
        pubSubTemplate.subscribe(this.subscription(), this.consumer());
    }
}