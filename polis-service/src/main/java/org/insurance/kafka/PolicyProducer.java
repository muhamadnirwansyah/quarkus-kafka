package org.insurance.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.insurance.resource.PolicyResource;
import org.jboss.logging.Logger;

import java.util.Objects;

@ApplicationScoped
public class PolicyProducer {

    private static final Logger LOG = Logger.getLogger(PolicyResource.class.getName());

    @Channel("policy-events-out")
    Emitter<String> emitter;

    public void sendEvent(String eventJson){
        LOG.infof("Sending event to Kafka : %s ",eventJson);
        emitter.send(eventJson)
                .whenComplete((success,failure) -> {
                    if (!Objects.isNull(failure)){
                        LOG.error("Failed to send event : ", failure);
                    }else{
                        LOG.infof("Event successfully sent to Kafka : ",eventJson);
                    }
                });
    }
}
