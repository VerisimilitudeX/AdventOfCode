package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {
    private static String getText(Path filename) throws IOException {
        return Files.readString(filename);
    }

    private static String[] getPeople(String input) {
        return input.split("\n\n");
    }

    private static int[] getTotalCals(String[] people) {
        int[] calsPerPerson = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            String[] individualCalories = people[i].split("\n");
            int totalCals = 0;
            for (int j = 0; j < individualCalories.length; j++) {
                totalCals += Integer.parseInt(individualCalories[j]);
            }

            calsPerPerson[i] = totalCals;
        }

        return calsPerPerson;
    }

    private static int findMostCals(int[] calsPerPerson) {
        int mostCals = 0;
        for (int i = 0; i < calsPerPerson.length; i++) {
            if (calsPerPerson[i] > mostCals) {
                mostCals = calsPerPerson[i];
            }
        }

        return mostCals;
    }

    public static void main(String[] args) throws IOException {
        // Get the file path and read the text
        Path filepath = Path.of("C:\\Users\\achar\\OneDrive\\Documents\\GitHub\\AdventOfCode2022\\Day1\\input.txt");
        String input = getText(filepath);

        // Split the input into an array of people
        String[] people = getPeople(input);

        // Add up the calories for each person
        int[] calsPerPerson = getTotalCals(people);

        // Find the person with the most calories
        int mostCals = findMostCals(calsPerPerson);

        System.out.println(mostCals);
    }
}