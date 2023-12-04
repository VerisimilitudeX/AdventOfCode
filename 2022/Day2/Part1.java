package Day2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws IOException {
        int totalScore = 0;
        // Creating the File object
        File file = new File("C:\\Users\\achar\\OneDrive\\Documents\\GitHub\\AdventOfCode2022\\Day2\\input.txt");
        // Creating a Scanner object
        Scanner sc = new Scanner(file);
        // Appending each line to the buffer
        while (sc.hasNext()) {
            int roundScore = 0;
            String[] moves = sc.nextLine().split(" ");
            String opponentMove = moves[0];
            String yourMove = moves[1];
            if (yourMove.equals("X")) {
                roundScore += 1;
            } else if (yourMove.equals("Y")) {
                roundScore += 2;
            } else if (yourMove.equals("Z")) {
                roundScore += 3;
            }

            if ((opponentMove.equals("A") && yourMove.equals("X")) || (opponentMove.equals("B") && yourMove.equals("Y"))
                    || (opponentMove.equals("C") && yourMove.equals("Z"))) {
                roundScore += 3;
            } else if ((opponentMove.equals("A") && yourMove.equals("Y"))
                    || (opponentMove.equals("B") && yourMove.equals("Z"))
                    || (opponentMove.equals("C") && yourMove.equals("X"))) {
                roundScore += 6;
            } else {
                roundScore += 0;
            }
            totalScore += roundScore;
        }
        sc.close();
        System.out.println(totalScore);
    }
}