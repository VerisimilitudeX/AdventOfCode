import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CalibrationValuePart1 {
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

            for (char c : currLineList) {
                if ((c + "").matches("[0-9]+")) {
                    currLineNumList.add(Integer.parseInt(c + ""));
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