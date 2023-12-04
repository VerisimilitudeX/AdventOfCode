package Day3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws IOException {
        // Creating the File object
        File file = new File("C:\\Users\\achar\\OneDrive\\Documents\\GitHub\\AdventOfCode2022\\Day3\\input.txt");

        // Creating a Scanner object
        Scanner sc = new Scanner(file);
        int sumMutualLetterPriorities = 0;
        
        // Appending each line to the buffer
        while (sc.hasNext()) {
            String rucksack = sc.nextLine();
            int compartmentLength = rucksack.length() / 2;
            String compartment1 = rucksack.substring(0, compartmentLength);
            String compartment2 = rucksack.substring(compartmentLength, rucksack.length());
            char mutualLetter = '1';
            for (char letter : compartment1.toCharArray()) {
                if (compartment2.contains(Character.toString(letter))) {
                    mutualLetter = letter;
                }
            }

            int priority = 0;
            if (Character.isLowerCase(mutualLetter) && mutualLetter != '1') {
                priority = (int) mutualLetter - 96;
                sumMutualLetterPriorities += priority;
            } else if (Character.isUpperCase(mutualLetter) && mutualLetter != '1') {
                priority = (int) mutualLetter - 38;
                sumMutualLetterPriorities += priority;
            }
        }
        sc.close();
        System.out.println(sumMutualLetterPriorities);
    }
}