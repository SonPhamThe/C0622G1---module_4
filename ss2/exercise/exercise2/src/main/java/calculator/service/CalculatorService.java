package calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public static Double addition(double a, double b, String calculation) {
        double result;
        switch (calculation) {
            case "Addition(+)":
                result = a + b;
                break;
            case "Subtraction(-)":
                result = a - b;
                break;
            case "Multiplication(*)":
                result = a * b;
                break;
            case "Division(/)":
                result = a / b;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calculation);
        }
        return result;
    }
}
