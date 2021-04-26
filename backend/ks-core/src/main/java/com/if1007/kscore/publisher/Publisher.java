package com.if1007.kscore.publisher;

import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
public class Publisher extends PubsubPublisher {

    private static Logger LOG = LoggerFactory.getLogger(Publisher.class);

    @Value("${pubsub.topic}")
    private String topic;

    @Override
    protected String topic() {
        return this.topic;
    }

    public void publishMessage(String messageId, Map<String, String> attributeMap, String message) throws ExecutionException, InterruptedException {
        LOG.info("Sending Message to the topic:::");
        PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
                .putAllAttributes(attributeMap)
                .setData(ByteString.copyFromUtf8(message))
                .setMessageId(messageId)
                .build();

        this.publish(pubsubMessage);
    }
}