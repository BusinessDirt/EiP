import java.util.Scanner;

public class NumberGuesser {

    public static void guessNumber(int maxNumber) {
        Scanner scanner = new Scanner(System.in);
        int minNumber = 0;
        int guess = 0;
        String input;

        while (minNumber <= maxNumber) {
            guess = (minNumber + maxNumber) / 2;
            System.out.printf("Ist die gedachte Zahl größer als %d?\n", guess);
            input = scanner.next().toLowerCase();

            if (input.equals("nein"))
                maxNumber = guess - 1;
            else if (input.equals("ja"))
                minNumber = guess + 1;
        }

        System.out.println("Die gedachte Zahl ist: " + guess);
        scanner.close();
    }
}
