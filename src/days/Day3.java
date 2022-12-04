package days;

import java.io.IOException;
import service.TextReader;

public class Day3 {

    public static int day3No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day3.txt");
        String firstHalf="";
        String secondHalf="";
        char bothCompartments = 0;
        int ascii = 0;
        int sum=0;

        for (int i = 0; i < array.length; i++) {
            firstHalf = array[i].substring(0,array[i].length()/2);
            secondHalf = array[i].substring(array[i].length()/2);

            for (int x=0; x<firstHalf.length(); x++) {
                for (int y=0; y<secondHalf.length(); y++) {
                    if (firstHalf.charAt(x) == secondHalf.charAt(y)) {
                        bothCompartments=firstHalf.charAt(x);
                    }
                }
            }

            if (bothCompartments == Character.toLowerCase(bothCompartments)) {
                ascii= (int) bothCompartments - 96;
            }
            else if (bothCompartments == Character.toUpperCase(bothCompartments)) {
                ascii = (int) bothCompartments - 38;
            }

            sum+=ascii;
        }
        return sum;
    }

    public static int day3No2() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day3.txt");
        String firstCompartment="";
        String secondCompartment="";
        String firstSecondSimilarities="";
        String thirdCompartment="";
        char allThreeCompartments=0;
        int ascii = 0;
        int sum=0;

        for (int i = 0; i < array.length; i+=3) {
            firstCompartment = array[i];
            secondCompartment = array[i+1];
            thirdCompartment = array[i+2];

            for (int x=0; x<firstCompartment.length(); x++) {
                for (int y=0; y<secondCompartment.length(); y++) {
                    if (firstCompartment.charAt(x) == secondCompartment.charAt(y)) {
                        firstSecondSimilarities+=firstCompartment.charAt(x);
                    }
                }
            }

            for (int x=0; x<firstSecondSimilarities.length(); x++) {
                for (int y=0; y<thirdCompartment.length(); y++) {
                    if (firstSecondSimilarities.charAt(x) == thirdCompartment.charAt(y)) {
                        allThreeCompartments=firstSecondSimilarities.charAt(x);
                    }
                }
            }

            if (allThreeCompartments == Character.toLowerCase(allThreeCompartments)) {
                ascii= (int) allThreeCompartments - 96;
            }
            else if (allThreeCompartments == Character.toUpperCase(allThreeCompartments)) {
                ascii = (int) allThreeCompartments - 38;
            }

            sum+=ascii;
        }
        return sum;
    }
}
