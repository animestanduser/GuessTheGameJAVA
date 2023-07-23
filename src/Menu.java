import java.util.InputMismatchException;
import java.util.Scanner;
class Menu {

    public void showMenu() {
        boolean gameOn = true;
        while (gameOn) {
            Scanner scanner = new Scanner(System.in);
            int gameOperator;

            System.out.println("------------- MENU -------------");
            System.out.println("--------- 0 Start Game ---------");
            System.out.println("-------- 1 Instructions --------");
            System.out.println("---------- 2 End Game ----------");

            try {
                gameOperator = scanner.nextInt();

            switch (gameOperator) {
                case 0:
                    Game game = new Game();
                    game.play();
                    break;
                case 1:
                    instructions();
                    break;
                case 2:
                    gameOn = false;
                    System.out.println("See you next time!");
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number from the menu.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from the menu.");
                scanner.nextLine(); // Clear input buffer
            }
        }
    }

    public void instructions() {
        System.out.println("Welcome to the guess the number game! You have to guess a 4-digit number."
                + " After each guess, you will get some hints.\nIf a digit you typed is not in"
                + " the answer, it will be marked as 'O',\nif it is in the number but in a different position,"
                + " it will be marked as 'I',\nand if you guess a digit correctly, it will be marked as 'X'."
                + "\nTry your luck and have fun! :)");
    }
}
