package com.kodilla.calculator.service;

import com.kodilla.calculator.event.NewRegisteredCall;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MethodManager implements ApplicationListener<NewRegisteredCall> {

    @Override
    public void onApplicationEvent(NewRegisteredCall event) {
        System.out.println("Method " + event.getCalledMethod() + " was called!!!");
    }
}
