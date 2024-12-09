package digit_sum;

import java.util.Scanner;

public class DigitSum {
    /**
     * This method calculates the sum of the digits of a number.
     * @param number The number to calculate the sum of its digits.
     * @return The sum of the digits of the number.
     */
    public static int sumOfDigits(int number) {
        number = Math.abs(number);
        if (number == 0) {
            return 0;
        } else {
            return number % 10 + sumOfDigits(number / 10);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Calculate and display the result
        int result = sumOfDigits(number);
        System.out.println("Sum of digits: " + result);

        scanner.close();
    }
}
