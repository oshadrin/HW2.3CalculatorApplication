package pro.sky.java.course2.calculatorapplication.service;

import org.springframework.stereotype.Service;
@Service
public class CalculatorServiceimpl implements CalculatorService {

    @Override
    public int plus(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public double divide(int a, int b) throws ArithmeticException {
        if (b==0) {
            throw new ArithmeticException("На ноль делить нелья");
        }
        return (double)a / b;
    }
}
