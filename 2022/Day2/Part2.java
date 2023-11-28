package Day2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Part2 {
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
            String ending = moves[1];

            if (ending.equals("Y")) {
                roundScore += 3;
                if (opponentMove.equals("A")) {
                    roundScore += 1;
                } else if (opponentMove.equals("B")) {
                    roundScore += 2;
                } else if (opponentMove.equals("C")) {
                    roundScore += 3;
                }
            } else if (ending.equals("X")) {
                roundScore += 0;
                if (opponentMove.equals("A")) {
                    roundScore += 3;
                } else if (opponentMove.equals("B")) {
                    roundScore += 1;
                } else if (opponentMove.equals("C")) {
                    roundScore += 2;
                }
            } else if (ending.equals("Z")) {
                roundScore += 6;
                if (opponentMove.equals("A")) {
                    roundScore += 2;
                } else if (opponentMove.equals("B")) {
                    roundScore += 3;
                } else if (opponentMove.equals("C")) {
                    roundScore += 1;
                }
            }
            totalScore += roundScore;
        }
        sc.close();
        System.out.println(totalScore);
    }
}