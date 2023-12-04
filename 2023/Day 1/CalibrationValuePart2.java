import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CalibrationValuePart2 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("2023\\Day 1\\input.txt");
        Scanner sc = new Scanner(input);

        ArrayList<Integer> addList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String currLineString = sc.nextLine();

            // clean string
            ArrayList<Character> currLineList = new ArrayList<>();
            for (int i = 0; i < currLineString.length(); i++) {
                currLineList.add(currLineString.charAt(i));
            }

            ArrayList<Integer> currLineNumList = new ArrayList<>();

            String spelledOut = "";
            for (char c : currLineList) {
                if ((c + "").matches("[0-9]+")) {
                    currLineNumList.add(Integer.parseInt(c + ""));
                    spelledOut = "";
                } else if (spelledOut.matches("zero|one|two|three|four|five|six|seven|eight|nine")) {                    
                    if (spelledOut.contains("zero")) {
                        currLineNumList.add(0);
                    } else if (spelledOut.contains("one")) {
                        currLineNumList.add(1);
                    } else if (spelledOut.contains("two")) {
                        currLineNumList.add(2);
                    } else if (spelledOut.contains("three")) {
                        currLineNumList.add(3);
                    } else if (spelledOut.contains("four")) {
                        currLineNumList.add(4);
                    } else if (spelledOut.contains("five")) {
                        currLineNumList.add(5);
                    } else if (spelledOut.contains("six")) {
                        currLineNumList.add(6);
                    } else if (spelledOut.contains("seven")) {
                        currLineNumList.add(7);
                    } else if (spelledOut.contains("eight")) {
                        currLineNumList.add(8);
                    } else if (spelledOut.contains("nine")) {
                        currLineNumList.add(9);
                    }
                } else {
                    spelledOut += c;
                }
            }

            if (currLineNumList.size() == 1) {
                addList.add((10 * currLineNumList.get(0)) + currLineNumList.get(0));
            } else {
                addList.add((10 * currLineNumList.get(0)) + currLineNumList.get(currLineNumList.size() - 1));
            }
        }
        sc.close();

        int sum = 0;
        for (int i = 0; i < addList.size(); i++) {
            sum += addList.get(i);
        }

        System.out.println(sum);
    }
}