package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello() {
        return "Hello omar";
    }

    @PostMapping("/post")

    public String post(@RequestBody String message) {
        return "i'm post : " + message;
    }

    @PostMapping("/post-order")

    public String postOrder(@RequestBody Order order) {
        return "order Accepted " + order.toString();
    }

}
