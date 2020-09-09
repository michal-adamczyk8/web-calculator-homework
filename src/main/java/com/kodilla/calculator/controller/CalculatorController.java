package com.kodilla.calculator.controller;

import com.kodilla.calculator.domain.NumbersDto;
import com.kodilla.calculator.event.NewRegisteredCall;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/calculator")
public class CalculatorController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }

    @PostMapping(path = "add")
    public Integer add(@RequestBody NumbersDto numbersDto) {
        publisher.publishEvent(new NewRegisteredCall(this, "add"));
        return numbersDto.getNumber1() + numbersDto.getNumber2();
    }


    @PostMapping(path = "substract")
    public Integer substract(@RequestBody NumbersDto numbersDto) {
        publisher.publishEvent(new NewRegisteredCall(this, "substract"));
        return numbersDto.getNumber1() - numbersDto.getNumber2();
    }


    @PostMapping(path = "multiply")
    public Integer multiply(@RequestBody NumbersDto numbersDto) {
        publisher.publishEvent(new NewRegisteredCall(this, "multiply"));
        return numbersDto.getNumber1() * numbersDto.getNumber2();
    }


    @PostMapping(path = "divide")
    public Integer divide(@RequestBody NumbersDto numbersDto) {
        publisher.publishEvent(new NewRegisteredCall(this, "divide"));
        return numbersDto.getNumber2() == 0 ? 0 : numbersDto.getNumber1() / numbersDto.getNumber2();
    }
}
