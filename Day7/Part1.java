package Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\achar\\OneDrive\\Documents\\GitHub\\AdventOfCode2022\\Day7\\input.txt");
        Scanner sc = new Scanner(file);

        ArrayList<String> input = new ArrayList<String>();
        TreeMap<Integer, String> commandLines = new TreeMap<>();
        TreeMap<Integer, Directory> dirLines = new TreeMap<>();
        TreeMap<Integer, FileType> files = new TreeMap<>();

        // Read the file contents into the ArrayList
        while (sc.hasNext()) {
            String thisLine = sc.nextLine();
            input.add(thisLine);
        }

        // Recognize lines that contain a command ($)
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).charAt(0) == '$') {
                commandLines.put(i + 1, input.get(i).substring(input.get(i).indexOf("$") + 1));
            } else if (input.get(i).contains("dir")) {
                Directory newDir = new Directory();
                newDir.name = input.get(i).substring(input.get(i).indexOf("dir") + 4);
                dirLines.put(i + 1, newDir);
            } else if (input.get(i).matches(".*\\d.*")) {
                FileType newFile = new FileType();
                newFile.size = Integer.parseInt(input.get(i).substring(0, input.get(i).indexOf(" ")));
                newFile.filename = input.get(i).substring(input.get(i).indexOf(" ") + 1);
                files.put(i + 1, newFile);
            }
        }

        // Iterate over the files in the TreeMap using the line numbers as the keys
        for (int lineNumber : files.keySet()) {
            int previousLineNum = lineNumber - 1;
            boolean check = findDirParentAndAdd(previousLineNum, files.get(lineNumber), dirLines, commandLines, files);
            if (check) {
                continue;
            } else {
                if (files.containsKey(previousLineNum)) {
                    findDirParentAndAdd(previousLineNum, files.get(lineNumber), dirLines, commandLines, files);
                    System.out.println("recursion");
                }
            }
        }

    }

    private static boolean findDirParentAndAdd(int previousLineNum, FileType file, TreeMap<Integer, Directory> dirLines,
            TreeMap<Integer, String> commandLines, TreeMap<Integer, FileType> files) {
        if (dirLines.containsKey(previousLineNum)) {
            dirLines.get(previousLineNum).files.add(file);
            dirLines.get(previousLineNum).size += file.size;
        } else {
            if (commandLines.containsKey(previousLineNum)) {
                return true;
            }
        }
        return false;
    }

}
