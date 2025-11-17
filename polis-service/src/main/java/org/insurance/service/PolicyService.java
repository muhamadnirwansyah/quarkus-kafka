package org.insurance.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.insurance.dto.PolicyRequest;
import org.insurance.entity.Policy;
import org.insurance.kafka.PolicyProducer;
import org.insurance.resource.PolicyResource;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class PolicyService {

    @Inject
    PolicyProducer policyProducer;
    private static final Logger LOG = Logger.getLogger(PolicyResource.class.getName());
    private ObjectMapper objectMapper = new ObjectMapper();

    @Transactional
    public Policy create(PolicyRequest request){
        LOG.infof("process create request new polis : %s ",convertObjToString(request));
        Policy policy = new Policy();
        policy.setPolicyNumber("POL"+System.currentTimeMillis());
        policy.setCustomerName(request.customerName);
        policy.setProductName(request.productName);
        policy.setPremium(request.getPremium());
        policy.persist();

        //publish to event kafka
        JsonObject event = JsonObject.of()
                .put("type", "POLIS_CREATED")
                .put("policyNumber", policy.getPolicyNumber())
                .put("customerName", policy.getCustomerName())
                .put("premium", policy.getPremium());

        LOG.infof("Prepare send data to topic : %s ", event.encode());
        policyProducer.sendEvent(event.encode());
        return policy;
    }

    private String convertObjToString(PolicyRequest request){
        try{
            return objectMapper.writeValueAsString(request);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.errorf("Error convert object to json string : %s ",e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<Policy> listAll(){
        LOG.infof("process list all polis..");
        return Policy.listAll();
    }

    public Policy getById(Long id){
        return Policy.findById(id);
    }
}
