package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Part2 {
    private static String getText(Path filename) throws IOException {
        // Create a string from the file
        return Files.readString(filename);
    }

    // This method takes in a string that contains the calories eaten by each
    // person, separated by a newline character
    // It returns an array list of the total calories eaten by each person
    private static ArrayList<Integer> getCaloriesPerPerson(String input) {
        // create an array list to store the calorie count of each person
        ArrayList<Integer> calsPerPerson = new ArrayList<>();

        // split the string input by the newline character "\n\n" to get each person's
        // calories
        String[] people = input.split("\n\n");
        // loop through each person
        for (int i = 0; i < people.length; i++) {
            // split each person's calories by the newline character "\n" to get each food
            // item calorie count
            String[] individualCalories = people[i].split("\n");

            // create a variable to store the total calories for each person
            int totalCals = 0;
            // loop through each food item calorie count
            for (int j = 0; j < individualCalories.length; j++) {
                // convert the string to an integer and add it to the total calories for each
                // person
                totalCals += Integer.parseInt(individualCalories[j]);
            }

            // add the total calories for each person to the array list
            calsPerPerson.add(totalCals);
        }

        // return the array list of the total calories eaten by each person
        return calsPerPerson;
    }

    private static ArrayList<Integer> getTop3Calories(ArrayList<Integer> calsPerPerson) {
        // Initialise a new ArrayList to store the top 3 values
        ArrayList<Integer> top3Cals = new ArrayList<>();
        // Add 3 values of 0 to the ArrayList
        top3Cals.add(0, 0);
        top3Cals.add(1, 0);
        top3Cals.add(2, 0);

        // Loop through the ArrayList of calories per person
        for (int i = 0; i < calsPerPerson.size(); i++) {
            // If the current element is greater than the first element of top3Cals
            if (calsPerPerson.get(i) > top3Cals.get(0)) {
                // Add the current element to the first element of top3Cals
                top3Cals.add(0, calsPerPerson.get(i));
                // Else if the current element is greater than the second element of top3Cals
            } else if (calsPerPerson.get(i) > top3Cals.get(1)) {
                // Add the current element to the second element of top3Cals
                top3Cals.add(1, calsPerPerson.get(i));
                // Else if the current element is greater than the third element of top3Cals
            } else if (calsPerPerson.get(i) > top3Cals.get(2)) {
                // Add the current element to the third element of top3Cals
                top3Cals.add(2, calsPerPerson.get(i));
            }
        }

        // Return the top3Cals ArrayList
        return top3Cals;
    }

    public static void main(String[] args) throws IOException {
        // Create filepath to input file
        Path filepath = Path.of("C:\\Users\\achar\\OneDrive\\Documents\\GitHub\\AdventOfCode2022\\day1\\input.txt");

        // Get input from input file
        String input = getText(filepath);

        // Get list of calories per person
        ArrayList<Integer> calsPerPerson = getCaloriesPerPerson(input);

        // Get top 3 calories
        ArrayList<Integer> top3Cals = getTop3Calories(calsPerPerson);

        // Print sum of top 3 calories
        System.out.println(top3Cals.get(0) + top3Cals.get(1) + top3Cals.get(2));
    }
}