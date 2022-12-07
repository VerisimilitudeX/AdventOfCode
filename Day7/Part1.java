package Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\achar\\OneDrive\\Documents\\GitHub\\AdventOfCode2022\\Day7\\input.txt");
        Scanner sc = new Scanner(file);

        ArrayList<String> input = new ArrayList<String>();
        HashMap<Integer, String> commandLines = new HashMap<>();
        HashMap<Integer, String> dirLines = new HashMap<>();
        HashMap<Integer, String> files = new HashMap<>();

        HashMap<Integer, HashMap<Integer, Long>> allLines = new HashMap<>();

        // Read the file contents into the ArrayList
        while (sc.hasNext()) {
            String thisLine = sc.nextLine();
            input.add(thisLine);
        }

        // Recognize lines that contain a command ($)
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).charAt(0) == '$') {
                commandLines.put(i, input.get(i).substring(input.get(i).indexOf("$") + 1));
            } else if (input.get(i).contains("dir")) {
                dirLines.put(i, input.get(i).substring(input.get(i).indexOf("dir") + 4));
            } else if (input.get(i).matches(".*\\d.*")) {
                files.put(i, input.get(i).substring(0, input.get(i).indexOf(" ")));
            } else {
                System.out.println("Error: Line " + i + " is not a command, dir, or file.");
            }
        }


    }

}
