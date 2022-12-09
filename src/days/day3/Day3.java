package days.day3;

import java.io.IOException;

import service.TextReader;

public class Day3 {

    public static int day3No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/day3/Day3.txt");
        String firstHalfOfCompartment;
        String secondHalfOfCompartment;
        char letterInBothCompartments = 0;
        int asciiConversion = 0;
        int sumOfPriorities = 0;

        for (int i = 0; i < array.length; i++) {
            firstHalfOfCompartment = array[i].substring(0, array[i].length() / 2);
            secondHalfOfCompartment = array[i].substring(array[i].length() / 2);

            for (int x = 0; x < firstHalfOfCompartment.length(); x++) {
                for (int y = 0; y < secondHalfOfCompartment.length(); y++) {
                    if (firstHalfOfCompartment.charAt(x) == secondHalfOfCompartment.charAt(y)) {
                        letterInBothCompartments = firstHalfOfCompartment.charAt(x);
                        break;
                    }
                }
            }

            //ASCII Table

            if (letterInBothCompartments == Character.toLowerCase(letterInBothCompartments)) {
                asciiConversion = (int) letterInBothCompartments - 96;
            } else if (letterInBothCompartments == Character.toUpperCase(letterInBothCompartments)) {
                asciiConversion = (int) letterInBothCompartments - 38;
            }

            sumOfPriorities += asciiConversion;
        }

        return sumOfPriorities;
    }

    public static int day3No2() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/day3/Day3.txt");
        String firstCompartment;
        String secondCompartment;
        String firstSecondSimilarities = "";
        String thirdCompartment;
        char letterInAllThreeCompartments = 0;
        int asciiConversion = 0;
        int sumOfPriorities = 0;

        for (int i = 0; i < array.length; i += 3) {
            firstCompartment = array[i];
            secondCompartment = array[i + 1];
            thirdCompartment = array[i + 2];

            for (int x = 0; x < firstCompartment.length(); x++) {
                for (int y = 0; y < secondCompartment.length(); y++) {
                    if (firstCompartment.charAt(x) == secondCompartment.charAt(y)) {
                        firstSecondSimilarities += firstCompartment.charAt(x);
                    }
                }
            }

            for (int x = 0; x < firstSecondSimilarities.length(); x++) {
                for (int y = 0; y < thirdCompartment.length(); y++) {
                    if (firstSecondSimilarities.charAt(x) == thirdCompartment.charAt(y)) {
                        letterInAllThreeCompartments = firstSecondSimilarities.charAt(x);
                        break;
                    }
                }
            }

            //ASCII Table

            if (letterInAllThreeCompartments == Character.toLowerCase(letterInAllThreeCompartments)) {
                asciiConversion = (int) letterInAllThreeCompartments - 96;
            } else if (letterInAllThreeCompartments == Character.toUpperCase(letterInAllThreeCompartments)) {
                asciiConversion = (int) letterInAllThreeCompartments - 38;
            }

            sumOfPriorities += asciiConversion;
        }

        return sumOfPriorities;
    }
}
