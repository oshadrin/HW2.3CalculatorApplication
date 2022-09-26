package pro.sky.java.course2.calculatorapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.calculatorapplication.service.CalculatorServiceimpl;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    private final CalculatorServiceimpl calculatorService;

    public CalculatorController(CalculatorServiceimpl calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer a,@RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Параметр не передан";
        }
        int plus = calculatorService.plus(a, b);
        return a + "+" + b + "=" + plus;
    }
    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer a,@RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Параметр не передан";
        }
        int minus = calculatorService.minus(a, b);
        return a + "-" + b + "=" + minus;
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer a,@RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Параметр не передан";
        }
        int multiply = calculatorService.multiply(a, b);
        return a + "*" + b + "=" + multiply;
    }
    @GetMapping("/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer a,@RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Параметр не передан";
        }
        double divide = 0;
        try {
            divide = calculatorService.divide(a, b);
        } catch (ArithmeticException e) {
            return "На ноль делить нельзя";
        }
        return a + "/" + b + "=" + divide;
    }
}
