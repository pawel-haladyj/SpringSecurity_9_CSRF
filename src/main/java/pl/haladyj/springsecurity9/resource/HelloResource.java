package pl.haladyj.springsecurity9.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @GetMapping("/hello")
    public String hello(){
        return "Hello GET";
    }

    @PostMapping("/posthello")
    public String postHello(){
        System.out.println("CSRF endpoint testing");
        return "Hello POST";
    }
}
