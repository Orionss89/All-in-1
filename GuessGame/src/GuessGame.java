import java.util.Scanner;

class GuessGame {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        final int number = 500;
        int userInput;
        System.out.println("Guess the number");

        while ((userInput = reader.nextInt()) != number) {
            if (userInput > number) {
                System.out.println("Number is too large!");
            } else {
                System.out.println("Number is too small, keep guessing!");
            }
        }

        System.out.println("Well done, you guessed the number :D");

        reader.close();
    }
}