package functionalinterface;

public class Main {
    public static void main(String[] args) {
        IntOperation addition = (x, y) -> x + y;
        IntOperation subtraction = (x, y) -> x - y;
        IntOperation multiplication = (x ,y) -> x * y;
        IntOperation division = (x, y) -> {
            if (y == 0) {
                throw new ArithmeticException("Division by zero is not possible");
            }
            return x / y;
        };

        System.out.println("Addition of 10 and 5 is: " + addition.apply(10, 5));
        System.out.println("Subtraction of 10 and 5 is: " + subtraction.apply(10, 5));
        System.out.println("Multiplication of 10 and 5 is: " + multiplication.apply(10, 5));
        System.out.println("Division of 10 and 5 is: " + division.apply(10, 5));
    }
}