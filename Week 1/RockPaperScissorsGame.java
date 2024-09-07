import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int player1Wins = 0;
        int player2Wins = 0;
        String playAgain;

        // Main game loop
        do {
            String player1Choice;
            String player2Choice;

            // Gets valid input from Player 1
            do {
                System.out.println("\nPlayer 1: Enter your choice (rock, paper, scissors): ");
                player1Choice = scanner.nextLine().toLowerCase();
                if (!isValidChoice(player1Choice)) {
                    System.out.println("\nInvalid choice. Please enter rock, paper, or scissors.");
                }
            } while (!isValidChoice(player1Choice));

            // Gets valid input from Player 2
            do {
                System.out.println("\nPlayer 2: Enter your choice (rock, paper, scissors): ");
                player2Choice = scanner.nextLine().toLowerCase();
                if (!isValidChoice(player2Choice)) {
                    System.out.println("\nInvalid choice. Please enter rock, paper, or scissors.");
                }
            } while (!isValidChoice(player2Choice));

            // Determines the winner
            String result = Winner(player1Choice, player2Choice);

            if (result.equals("Player 1")) {
                System.out.println("\nPlayer 1 wins this round!");
                player1Wins++;
            } else if (result.equals("Player 2")) {
                System.out.println("\nPlayer 2 wins this round!");
                player2Wins++;
            } else {
                System.out.println("\nIt's a tie!");
            }

            // Asks if players are up for another round
            System.out.println("Do you want to play another round? (y/n): ");
            playAgain = scanner.nextLine().toLowerCase();
            
        } while (playAgain.equals("y"));

        // Final Score
        System.out.println("\nFinal Score:");
        System.out.println("Player 1 Wins: " + player1Wins);
        System.out.println("Player 2 Wins: " + player2Wins);

        scanner.close();
    }

    // Function to determine winner
    public static String Winner(String player1, String player2) {
        if (player1.equals(player2)) {
            return "Tie";
        }

        switch (player1) {
            case "rock":
                return player2.equals("scissors") ? "Player 1" : "Player 2";
            case "paper":
                return player2.equals("rock") ? "Player 1" : "Player 2";
            case "scissors":
                return player2.equals("paper") ? "Player 1" : "Player 2";
            default:
                return "Invalid";
        }
    }

    // Function to check if the player's choice is correct
    public static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }
}
