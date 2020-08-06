package de.oette.lecture.A01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    public int value;

    @PostMapping
    public int setValue(int value) {
        this.value = value;
        return this.value;
    }

    @PostMapping("/add")
    public int plus(int value) {
        this.value += value;
        return this.value;
    }

    @PostMapping("/subtract")
    public int minus(int value) {
        this.value -= value;
        return this.value;
    }

    @GetMapping
    public int getValue() {
        return this.value;
    }


}
