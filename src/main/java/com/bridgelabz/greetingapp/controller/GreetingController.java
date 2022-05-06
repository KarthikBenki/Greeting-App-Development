package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {
    /**
     * Dependency injection for Greeting service
     */
    @Autowired
    private GreetingService greetingService;

    /**
     *
     * @param fname
     * @param lname
     * @return Json object on success
     */
    @GetMapping("/home")
    public Greeting greeting(@RequestParam(value = "fname",defaultValue = "world") String fname,
                             @RequestParam(value = "lname",defaultValue = "")String lname){
        User user = new User();
        user.setFirstName(fname);
        user.setLastName(lname);
        return greetingService.addGreeting(user);
    }

    /**
     *
     * @return lis of objects
     */
    @GetMapping("/all")
    public List<Greeting> getAll(){
        return greetingService.getAll();
    }

    /**
     *
     * @param id
     * @return json object of found greeting by id
     */
    @GetMapping("/path/{id}")
    public Greeting getGreetingById(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }

    /**
     *
     * @param id
     * @param name
     * @return returns edited json object
     */
    @PutMapping("/edit/{id}")
    public Greeting editGreetingById(@PathVariable long id, @RequestParam String name){
        return greetingService.editGreetingById(id, name);
    }

    /**
     *
     * @param id
     * @return returns list of greetings remaining after deletion
     */
    @DeleteMapping("/delete/{id}")
    public List<Greeting> deleteGreetingById(@PathVariable Long id){
        return greetingService.deleteGreetingById(id);
    }
}
