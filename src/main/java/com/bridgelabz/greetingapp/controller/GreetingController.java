package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello , %s!";
    private final AtomicLong counter = new AtomicLong();//used for auto increment

    /**
     *URL:localhost:8080/greeting
     @return: {id =1 , content="hello world!}
      * localhost:8080/greeting?name=Karthik
      * @return: { id=2, content="hello Karthik!
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

    /**
     *localhost:8080/greeting/Karthik
     @return: {id =1 , content="hello Karthik!}
     */
    @GetMapping("/path/{name}")
    public Greeting greetings(@PathVariable(value = "name") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}
