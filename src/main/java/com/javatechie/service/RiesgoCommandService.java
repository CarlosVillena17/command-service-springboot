package com.javatechie.service;

import com.javatechie.dto.RiesgoEvent;
import com.javatechie.entity.Riesgo;
import com.javatechie.repository.RiesgoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RiesgoCommandService {

    @Autowired
    private RiesgoRepository repository;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public Riesgo createProduct(RiesgoEvent productEvent){
        Riesgo productDO = repository.save(productEvent.getProduct());
        RiesgoEvent event=new RiesgoEvent("CreateProduct", productDO);
        kafkaTemplate.send("product-event-topic", event);
        return productDO;
    }

    public Riesgo updateProduct(long id,RiesgoEvent productEvent){
        Riesgo existingProduct = repository.findById(id).get();
        Riesgo newProduct=productEvent.getProduct();
        existingProduct.setName(newProduct.getName());
        existingProduct.setPrice(newProduct.getPrice());
        existingProduct.setDescription(newProduct.getDescription());
        Riesgo productDO = repository.save(existingProduct);
        RiesgoEvent event=new RiesgoEvent("UpdateProduct", productDO);
        kafkaTemplate.send("product-event-topic", event);
        return productDO;
    }

}
