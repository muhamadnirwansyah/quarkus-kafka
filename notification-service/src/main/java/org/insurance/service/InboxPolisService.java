package org.insurance.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.insurance.dto.InboxPolisRequest;
import org.insurance.entity.Inbox;
import org.jboss.logging.Logger;

@ApplicationScoped
public class InboxPolisService {

    private static final Logger LOG = Logger.getLogger(InboxPolisService.class.getName());
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Transactional
    public void saveInbox(InboxPolisRequest request){
        LOG.infof("proses save inbox polis : %s",convertObjToJsonString(request));
        Inbox inbox = new Inbox();
        inbox.setAction(request.getType());
        inbox.setCustomerName(request.getCustomerName());
        inbox.setPolicyNumber(request.getPolicyNumber());
        inbox.setPremiumAmount(request.getPremium());
        inbox.setMessage("save polis to inbox");
        inbox.persist();
        LOG.infof("success save inbox polis..");
    }

    private String convertObjToJsonString(InboxPolisRequest request){
        try{
            return objectMapper.writeValueAsString(request);
        } catch (Exception e) {
            Log.errorf("Error failed convert obj to json string : %s",e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
