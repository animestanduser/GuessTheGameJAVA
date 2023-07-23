import java.util.Random;
import java.util.Scanner;

class Game {

    private int[] randomN;

    public void play() {
        System.out.println("You have 7 tries to guess the number. Good luck!");

        randomN = generateRandomNumber(4);

        for (int i = 7; i > 0; i--) {
            if (round()) {
                break;
            } else if (i == 1) {
                System.out.println("No more tries left :(");
            } else {
                System.out.println("Only " + (i - 1) + " has left. \nTry once again!\n");
            }
        }
    }

    public boolean round() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write a 4-digit number: ");
        String roundOperator = scanner.nextLine();

        try {
            if (roundOperator.length() != 4) {
                throw new IllegalArgumentException("Invalid input. Please enter a 4-digit number.");
            }

            int[] userInput = toArrayFromString(roundOperator);
            char[] result = checkNumber(userInput);
            String message = generateOutputMessage(result);

            System.out.println("For user input : " + roundOperator + "\nthe answer is : " + message);

            if (checkAnswer(result)) {
                System.out.println("Good job! You guessed the right number!");
                return true;
            } else {
                System.out.println("Wrong answer :(");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a 4-digit number.");
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private String generateOutputMessage(char[] result) {
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            if (c == 'X') {
                sb.append(c);
            } else if ( c == 'I' ) {
                sb.append(c);
            } else {
                sb.append('?');
            }
        }
        return sb.toString();
    }

    private int[] generateRandomNumber(int size) {
        int[] randomNumber = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomNumber[i] = random.nextInt(10);
        }

        return randomNumber;
    }

    private int[] toArrayFromString(String numberString) {
        char[] charArray = numberString.toCharArray();
        int[] numberArray = new int[numberString.length()];

        for (int i = 0; i < charArray.length; i++) {
            numberArray[i] = Character.getNumericValue(charArray[i]);
        }

        return numberArray;
    }

    private char[] checkNumber(int[] input) {
        int[] generatedNumber = randomN;

        char[] answerArray = new char[]{'X', 'X', 'X', 'X'};

        for (int i = 0; i < input.length; i++) {
            if (input[i] == generatedNumber[i]) {
                answerArray[i] = 'X';
            } else if (contains(generatedNumber, input[i])) {
                answerArray[i] = 'I';
            } else {
                answerArray[i] = 'O';
            }
        }

        return answerArray;
    }

    private boolean contains(int[] arr, int key) {
        for (int num : arr) {
            if (num == key) {
                return true;
            }
        }
        return false;
    }

    private boolean checkAnswer(char[] input) {
        String correctAnswer = "XXXX";
        String userAnswer = new String(input);

        return correctAnswer.equals(userAnswer);
    }
}