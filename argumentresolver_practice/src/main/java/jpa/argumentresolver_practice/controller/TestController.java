package jpa.argumentresolver_practice.controller;

import jpa.argumentresolver_practice.config.custom.CustomPathVariable;
import jpa.argumentresolver_practice.config.custom.CustomRequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/request")
    public String requestParamDemo(@CustomRequestParam String name) {
        return "name: " + name;
    }

    @GetMapping("/path/{id}")
    public String pathVariableDemo(@CustomPathVariable Long id) {
        return "id: " + id;
    }
}
