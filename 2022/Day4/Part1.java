import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\achar\\OneDrive\\Documents\\GitHub\\AdventOfCode2022\\Day4\\input.txt");
        Scanner sc = new Scanner(file);

        int count = 0;

        while (sc.hasNext()) {
            String pairAssignment = sc.nextLine();
            String firstPair = pairAssignment.substring(0, pairAssignment.indexOf(","));
            int firstRange1 = Integer.parseInt(firstPair.substring(0, firstPair.indexOf("-")));
            int firstRange2 = Integer.parseInt(firstPair.substring(firstPair.indexOf("-") + 1));

            String secondPair = pairAssignment.substring(pairAssignment.indexOf(",") + 1);
            int secondrange1 = Integer.parseInt(secondPair.substring(0, secondPair.indexOf("-")));
            int secondrange2 = Integer.parseInt(secondPair.substring(secondPair.indexOf("-") + 1));

            if ((firstRange1 <= secondrange1 && firstRange2 >= secondrange2)
                    || (firstRange1 >= secondrange1 && firstRange2 <= secondrange2)) {
                count++;
            }
        }
        sc.close();
        System.out.println(count);
    }
}