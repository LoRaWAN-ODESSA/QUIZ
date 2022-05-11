import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startNewGame();

    }

    public static void startNewGame() {
        boolean isPlay = true;
        while (isPlay) {
            Game game = new Game();
            game.startGame();
            for (int i = 0; i < 4; i++) {
                game.beginRound(i + 1);
            }
            printResult(game);
            isPlay = newGame();
        }

    }

    public static boolean newGame() {
        Scanner want = new Scanner(System.in);
        System.out.print("Do you want start new game (yes/no)?: ");
        String answer = want.next();
        String yes = "yes";
        String no = "no";
        if(answer.trim().toLowerCase().equals(no)) {
            boolean isPlay = false;
            return isPlay;
        } else if(answer.trim().toLowerCase().equals(yes)) {
            System.out.println("\nStarting new game...\n");
            try {
                Thread.sleep(1500);
            } catch(InterruptedException ex) {}
            boolean isPlay = true;
            return isPlay;
        } else {
            System.out.println("Unknown command!");
            boolean isPlay = false;
            return isPlay;
        }
    }

    private static void printResult(Game game) {
        String winner = game.getUser()[findWinnerIndex(game.getScore())].getName();
        System.out.println("\nCongratulations! The winner is "+ winner + "! His result is: " + game.getScore()[findWinnerIndex(game.getScore())] + "/12.");
    }

    private static int findWinnerIndex(int[] array) {
        int indexOfMax = 0;
        int indexOfMin = 0;
        for (int i = 1; i < array.length; i++)
        {
            if (array[i] > array[indexOfMax])
            {
                indexOfMax = i;
            }
            else if (array[i] < array[indexOfMin])
            {
                indexOfMin = i;
            }
        }
        return indexOfMax;
    }
}
