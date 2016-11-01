import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by Daniel on 11/1/2016.
 */

public class urlify {
    /*
     * Replace all spaces in a given string with "%20"
     */

    public static void main(String[] args) {
        String cont = "Y";

        // loop to allow multiple tests
        while (cont.equalsIgnoreCase("Y")) {
            // grab user input
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter a string to transform: ");
            String testString = scan.nextLine();

            if (testString.equals("")) {
                System.out.println("Please enter a valid string");
            } else {
                transformSpaces(testString);
                while (true) {
                    System.out.println("Would you like to continue? (Y or N): ");
                    cont = scan.nextLine();
                    if (!cont.equalsIgnoreCase("Y") && !cont.equalsIgnoreCase("N")) {
                        System.out.println("I didn't get that...");
                    } else {
                        break;
                    }
                }
            }
        }
    }

    // Utilizes an ArrayList to perform in place transformation of spaces
    private static void transformSpaces(String testString) {
        // convert to ArrayList
        ArrayList<String> charArray = stringToArrayList(testString);

        // replace spaces with "%20"
        for (int i=0; i<charArray.size(); i++) {
            String temp = charArray.get(i);
            if (temp.equals(" ")) {
                charArray.set(i, "%20");
            }
        }

        // print the result
        printArrayList(charArray);
    }

    private static ArrayList<String> stringToArrayList(String testString) {
        // convert to ArrayList for in place operation
        ArrayList<String> charArray = new ArrayList<>();
        for (int i=0; i<testString.length(); i++) {
            charArray.add(testString.substring(i, i+1));
        }

        return charArray;
    }

    private static void printArrayList(ArrayList<String> charArray) {
        // print ArrayList
        Iterator it = charArray.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
    }
}
