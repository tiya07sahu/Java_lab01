import java.util.Scanner;

public class MenuDrivenProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1) Calculator");
            System.out.println("2) Factorial");
            System.out.println("3) Fibonacci");
            System.out.println("4) Root");
            System.out.println("5) Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    calculator(sc);
                    break;
                case 2:
                    factorial(sc);
                    break;
                case 3:
                    fibonacci(sc);
                    break;
                case 4:
                    root(sc);
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    // Calculator function
    public static void calculator(Scanner sc) {
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        System.out.println("Choose operation (+, -, *, /): ");
        char op = sc.next().charAt(0);

        double result;
        switch (op) {
            case '+':
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid operation.");
        }
    }

    // Factorial function
    public static void factorial(Scanner sc) {
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + num + " is: " + fact);
    }

    // Fibonacci function
    public static void fibonacci(Scanner sc) {
        System.out.print("Enter the number of terms: ");
        int n = sc.nextInt();
        int a = 0, b = 1;
        System.out.println("Fibonacci Series: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    // Root function
    public static void root(Scanner sc) {
        System.out.print("Enter a number: ");
        double num = sc.nextDouble();
        if (num < 0) {
            System.out.println("Square root of negative numbers is not defined for real numbers.");
        } else {
            System.out.println("Square root of " + num + " is: " + Math.sqrt(num));
        }
    }
}