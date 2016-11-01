/**
 * Created by Daniel on 11/1/2016.
 */

import java.util.Scanner;
import java.util.HashSet;

public class isUnique {
    /*
     * Implementation of an algorithm to determine if a string has all unique characters
     */

    public static void main(String[] args) {
        String cont = "Y";

        // wrapper loop to allow for multiple inputs
        while (cont.equalsIgnoreCase("Y")) {
            // Grab user input
            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter a string: ");
            String testString = scan.nextLine();

            // ignore if there is no string entered
            if (testString.length() == 0) {
                System.out.println("Please enter an input!");
            } else {
                //boolean isUnique = testUnique(testString);
                boolean isUnique = testUniqueHash(testString);

                if (isUnique) {
                    System.out.println("All the characters are unique!");
                } else {
                    System.out.println("There are repeated characters.");
                }

                // make sure user wants to continue
                while (true) {
                    System.out.print("Would you like to continue? (Y or N): ");
                    cont = scan.nextLine();

                    if (!cont.equalsIgnoreCase("Y") && !cont.equalsIgnoreCase("N")) {
                        System.out.print("I didn't get that...");
                    } else {
                        break;
                    }
                }
            }
        }
    }

    // Brute force method iterating through the characters and checking each one by one
    private static boolean testUnique(String testString) {
        for (int i=0; i<testString.length(); i++) {
            char temp = testString.charAt(i);
            for (int j=i+1; j<testString.length(); j++) {
                if (temp == testString.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // More efficient solution utilizing a Java HashSet to check for duplicates
    // Added additional check for spaces
    private static boolean testUniqueHash(String testString) {
        // initialize hashset and temporary string
        HashSet<String> charSet = new HashSet<>();
        String temp;

        // loop checking each character against the HashSet and adding it if it is not found
        for (int i=0; i<testString.length(); i++) {
            temp = testString.substring(i, i+1);
            if (temp.equals(" ")) {
                continue;
            }
            System.out.println(temp);
            if (charSet.contains(temp)) {
                return false;
            } else {
                charSet.add(temp);
            }
        }

        return true;
    }
}
