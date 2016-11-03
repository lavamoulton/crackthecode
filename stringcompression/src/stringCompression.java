/**
 * Created by Daniel on 11/1/2016.
 */

import java.util.Scanner;

public class stringCompression {
    /*
     * Takes a string input of repeated characters (ex. aaaabbccc)
     * compresses it to take into account the number of characters (ex. a4b2c3)
     * Strings without any repeating characters will be returned unchanged
     */

    public static void main(String[] args) {
        String cont = "Y";

        while (cont.equalsIgnoreCase("Y")) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter a string: ");
            String testString = scan.nextLine();

            if (testString.equals("")) {
                System.out.println("I didn't get that...");
            } else {
                String result = compressString(testString);
                System.out.println(result);

                while (true) {
                    System.out.print("Would you like to continue? (Y or N): ");
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

    private static String compressString(String testString) {
        // keeps track of whether the string has any repeating characters
        boolean noRepeat = true;

        // initialize the temporary string with the first character
        String temp = testString.substring(0, 1);
        System.out.println("temp: " + temp);
        String result = "";
        int count = 1;

        for (int i=1; i<testString.length(); i++) {
            String next = testString.substring(i, i+1);
            System.out.println("next: " + next);
            if (temp.equals(next)) {
                count++;
                noRepeat = false;
            } else {
                result += temp + count;
                temp = next;
                count = 1;
            }
        }

        // handles end of string
        result += temp + count;

        if (noRepeat) {
            return testString;
        } else {
            return result;
        }
    }
}
