package org.insurance.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.insurance.dto.InboxPolisRequest;
import org.insurance.service.InboxPolisService;
import org.jboss.logging.Logger;

@ApplicationScoped
public class PolicyConsumer {

    private static final Logger LOG = Logger.getLogger(PolicyConsumer.class.getName());
    @Inject
    InboxPolisService inboxPolisService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Incoming("policy-events-in")
    public void consume(String event){
        LOG.infof("Received event messages : %s ",event);
        InboxPolisRequest polisInboxRequest = polisRequest(event);
        this.inboxPolisService.saveInbox(polisInboxRequest);
    }

    private InboxPolisRequest polisRequest(String event){
        try{
            InboxPolisRequest polisRequest = objectMapper.readValue(event, InboxPolisRequest.class);
            return polisRequest;
        }catch (Exception e){
            LOG.errorf("error failed processing json : %s",e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
