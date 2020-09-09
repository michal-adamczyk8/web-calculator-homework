package com.kodilla.calculator.event;

import org.springframework.context.ApplicationEvent;

public class NewRegisteredCall extends ApplicationEvent {

    private String calledMethod;

    public NewRegisteredCall(Object source, String method) {
        super(source);
        calledMethod = method;
    }

    public String getCalledMethod() {
        return calledMethod;
    }
}
