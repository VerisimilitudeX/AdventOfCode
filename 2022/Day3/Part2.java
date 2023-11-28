package Day3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) throws IOException {
        // Creating the File object
        File file = new File("C:\\Users\\achar\\OneDrive\\Documents\\GitHub\\AdventOfCode2022\\Day3\\input.txt");

        // Creating a Scanner object
        Scanner sc = new Scanner(file);

        int sumMutualLetterPriorities = 0;

        // Appending each line to the buffer
        while (sc.hasNext()) {
            String badge = "1";
            String first = sc.nextLine();
            String[] firstArray = first.split("");
            ArrayList<String> firstRucksack = new ArrayList<String>(Arrays.asList(firstArray));

            String second = sc.nextLine();
            String[] secondArray = second.split("");
            ArrayList<String> secondRucksack = new ArrayList<String>(Arrays.asList(secondArray));

            String third = sc.nextLine();
            String[] thirdArray = third.split("");
            ArrayList<String> thirdRucksack = new ArrayList<String>(Arrays.asList(thirdArray));

            for (String letter : firstRucksack) {
                if (secondRucksack.contains(letter) && thirdRucksack.contains(letter)) {
                    badge = letter;
                }
            }

            int priority = 0;
            if (Character.isLowerCase(badge.charAt(0)) && badge.charAt(0) != '1') {
                priority = (int) badge.charAt(0) - 96;
                sumMutualLetterPriorities += priority;
            } else if (Character.isUpperCase(badge.charAt(0)) && badge.charAt(0) != '1') {
                priority = (int) badge.charAt(0) - 38;
                sumMutualLetterPriorities += priority;
            }
        }
        System.out.println(sumMutualLetterPriorities);
        sc.close();
    }
}