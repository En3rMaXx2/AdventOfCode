package days;

import java.io.IOException;

import service.TextReader;

public class Day4 {

    public static int day4No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day4.txt");
        String beginA;
        String endA;
        String beginB;
        String endB;
        int counter = 0;

        boolean firstDash;

        for (int i = 0; i < array.length; i++) {
            String temp = "";

            beginA = "";
            beginB = "";
            endA = "";
            endB = "";
            firstDash = true;

            for (int a = 0; a < array[i].length(); a++) {
                if (array[i].charAt(a) == '-' && firstDash) {
                    beginA = temp;
                    temp = "";
                    a++;
                    firstDash = false;
                } else if (array[i].charAt(a) == '-' && !firstDash) {
                    beginB = temp;
                    temp = "";
                    a++;
                } else if (array[i].charAt(a) == ',') {
                    endA = temp;
                    temp = "";
                    a++;
                }
                temp += array[i].charAt(a);
            }

            endB = temp;

            // Example 2-4,6-8
            // beginA 2 - endA 4 - beginB 6 - endB 8

            //TODO needs adjustment
            if (Integer.parseInt(beginA) <= Integer.parseInt(beginB) && Integer.parseInt(endA) >= Integer.parseInt(endB)) {
                counter++;
            } else if (Integer.parseInt(beginA) >= Integer.parseInt(beginB) && Integer.parseInt(endA) <= Integer.parseInt(endB)) {
                counter++;
            }
        }

        return counter;
    }

    public static int day4No2() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day4.txt");
        String beginA;
        String endA;
        String beginB;
        String endB;

        int counter = 0;
        boolean firstDash;

        for (int i = 0; i < array.length; i++) {
            String temp = "";

            beginA = "";
            beginB = "";
            endA = "";
            endB = "";
            firstDash = true;

            for (int a = 0; a < array[i].length(); a++) {
                if (array[i].charAt(a) == '-' && firstDash) {
                    beginA = temp;
                    temp = "";
                    a++;
                    firstDash = false;
                } else if (array[i].charAt(a) == '-' && !firstDash) {
                    beginB = temp;
                    temp = "";
                    a++;
                } else if (array[i].charAt(a) == ',') {
                    endA = temp;
                    temp = "";
                    a++;
                }
                temp += array[i].charAt(a);
            }

            endB = temp;

            // Example 2-4,6-8
            // beginA 2 - endA 4 - beginB 6 - endB 8

            //TODO needs adjustment
            if (Integer.parseInt(beginA) > Integer.parseInt(endB)) {
                //Do nothing
            } else if (Integer.parseInt(endA) >= Integer.parseInt(beginB)) {
                counter++;
            }
        }

        return counter;
    }
}
