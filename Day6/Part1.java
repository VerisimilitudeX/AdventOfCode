package Day6;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {
    private static String getText(Path filename) throws IOException {
        return Files.readString(filename);
    }

    public static void main(String[] args) throws IOException {
        // Get the file path and read the text
        Path filepath = Path.of("C:\\Users\\achar\\OneDrive\\Documents\\GitHub\\AdventOfCode2022\\Day6\\input.txt");
        String input = getText(filepath);
        for (int i = 0; i < input.length(); i++) {
            char[] letters = new char[4];

            if (i + 4 > input.length()) {
                break;
            }

            letters[0] = input.charAt(i);
            letters[1] = input.charAt(i + 1);
            letters[2] = input.charAt(i + 2);
            letters[3] = input.charAt(i + 3);

            HashSet<Character> hs = new HashSet<>();
            int uniqueFound = 0;

            for (char j : letters) {
                // Convert the char value to a Character object
                Character ch = Character.valueOf(j);
                if (hs.add(ch)) {
                    uniqueFound++;
                    continue;
                } else {
                    break;
                }
            }

            if (uniqueFound == 4) {
                System.out.println(i + 4);
                break;
            }
        }
    }
}