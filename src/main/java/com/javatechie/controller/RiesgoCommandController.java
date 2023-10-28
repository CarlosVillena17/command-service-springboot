package com.javatechie.controller;

import com.javatechie.dto.RiesgoEvent;
import com.javatechie.entity.Riesgo;
import com.javatechie.service.RiesgoCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class RiesgoCommandController {

    @Autowired
    private RiesgoCommandService commandService;

    @PostMapping
    public Riesgo createProduct(@RequestBody RiesgoEvent productEvent) {
        return commandService.createProduct(productEvent);
    }

    @PutMapping("/{id}")
    public Riesgo updateProduct(@PathVariable long id, @RequestBody RiesgoEvent productEvent) {
        return commandService.updateProduct(id, productEvent);
    }
}
