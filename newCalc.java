import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class newCalc {

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    public static Deque<Integer> addLastValue(int value, Deque<Integer> dequeList) {
        dequeList.add(value);
        return dequeList;
    }

    public static Integer removeLastValue(Deque<Integer> dequeList) {
        dequeList.removeLast();
        int lastValue;
        try {
            lastValue = dequeList.peekLast();

        } catch (Exception e) {
            System.out.println("The list is empty");
            return 0;
        }
        return lastValue;
    }

    public static void simpleCalculator() {

        System.out.println(
                "Input values for solving e.g. : \n   5\n   +   \n   3\n   '=' show your result \n\n *you can continue solving if you want to  \n **to cancel the last operation input 'undo' \n ***for the exit input 'exit':");

        Scanner userInput = new Scanner(System.in);
        int result = 0;
        int prev = 0;
        char operator = ' ';
        Deque<Integer> dequeLogger = new LinkedList<>();

        while (userInput.hasNext()) {
            String input = userInput.next();

            if (input.equals("exit")) {
                System.out.println("Bye-Bye");
                break;
            }
            if (isNumber(input)) {
                prev = Integer.parseInt(input);
                addLastValue(prev, dequeLogger);
                if (operator == '+') {
                    result += prev;
                    addLastValue(result, dequeLogger);
                    System.out.println(result);
                } else if (operator == '-') {
                    result -= prev;
                    addLastValue(result, dequeLogger);
                    System.out.println(result);
                } else if (operator == '*') {
                    result *= prev;
                    addLastValue(result, dequeLogger);
                    System.out.println(result);
                } else if (operator == '/') {
                    result /= prev;
                    addLastValue(result, dequeLogger);
                    System.out.println(result);
                } else {
                    result = prev;
                }
            } else if (isOperator(input)) {
                operator = input.charAt(0);
            } else if (input.equals("undo")) {
                result = removeLastValue(dequeLogger);
                System.out.println(result);
            } else if (input.equals("=")) {
                System.out.println("Last result is " + result);
            } else {
                System.out.println("Unknown command: " + input);
            }

        }
        System.out.print("The last result was: ");
        System.out.println(result);

    }

    public static void main(String[] args) {
        simpleCalculator();
    }
}
