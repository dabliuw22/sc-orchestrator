
package com.leyton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leyton.flow.gateway.MicroserviceOneGateway;

@RestController
@RequestMapping(
        value = {
            "/orchestrator"
        })
public class OrchestratorController {

    @Autowired
    private MicroserviceOneGateway microserviceOneGateway;

    @GetMapping
    public ResponseEntity<Void> orchestrator(@RequestParam(
            name = "name") String name) {
        microserviceOneGateway.request(name);
        return ResponseEntity.noContent().build();
    }
}
