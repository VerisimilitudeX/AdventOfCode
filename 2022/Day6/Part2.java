package Day6;

import java.io.IOException;
import java.util.HashSet;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part2 {
    private static String getText(Path filename) throws IOException {
        return Files.readString(filename);
    }

    public static void main(String[] args) throws IOException {
        // Get the file path and read the text
        Path filepath = Path.of("C:\\Users\\achar\\OneDrive\\Documents\\GitHub\\AdventOfCode2022\\Day6\\input.txt");
        String input = getText(filepath);
        for (int i = 0; i < input.length(); i++) {
            char[] letters = new char[14];

            if (i + 13 > input.length()) {
                break;
            }

            letters[0] = input.charAt(i);
            letters[1] = input.charAt(i + 1);
            letters[2] = input.charAt(i + 2);
            letters[3] = input.charAt(i + 3);
            letters[4] = input.charAt(i + 4);
            letters[5] = input.charAt(i + 5);
            letters[6] = input.charAt(i + 6);
            letters[7] = input.charAt(i + 7);
            letters[8] = input.charAt(i + 8);
            letters[9] = input.charAt(i + 9);
            letters[10] = input.charAt(i + 10);
            letters[11] = input.charAt(i + 11);
            letters[12] = input.charAt(i + 12);
            letters[13] = input.charAt(i + 13);

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

            if (uniqueFound == 14) {
                System.out.println(i + 14);
                break;
            }
        }
    }
}