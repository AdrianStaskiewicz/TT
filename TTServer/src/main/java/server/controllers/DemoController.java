package server.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @PersistenceContext
    private EntityManager em;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }

}
