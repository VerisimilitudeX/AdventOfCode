package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class part1 {
    private static String getText(Path filename) throws IOException {
        return Files.readString(filename);
    }

    public static void main(String[] args) throws IOException {
        Path filepath = Path.of("C:\\Users\\achar\\OneDrive\\Documents\\GitHub\\AdventOfCode2022\\input.txt");
        String input = getText(filepath);

        ArrayList<Integer> calsPerPerson = new ArrayList<>();

        String[] people = input.split("\n\n");
        for (int i = 0; i < people.length; i++) {
            String[] individualCalories = people[i].split("\n");

            int totalCals = 0;
            for (int j = 0; j < individualCalories.length; j++) {
                totalCals += Integer.parseInt(individualCalories[j]);
            }

            calsPerPerson.add(totalCals);
        }

        int mostCals = 0;
        for (int i = 0; i < calsPerPerson.size(); i++) {
            if (calsPerPerson.get(i) > mostCals) {
                mostCals = calsPerPerson.get(i);
            }
        }

        System.out.println(mostCals);
    }
}