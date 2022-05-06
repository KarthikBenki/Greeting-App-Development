package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

import java.util.List;
import java.util.Optional;

public interface GreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);

    List<Greeting> getAll();

    Greeting editGreetingById(long id, String name);

    List<Greeting> deleteGreetingById(Long id);
}
