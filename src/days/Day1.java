package days;

import java.io.IOException;
import service.TextReader;

public class Day1 {

    public static int day1No1() throws IOException {

        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day1.txt");

        int sum=0;
        int max =0;

        for (int i=0; i<array.length; i++) {
            if(!array[i].equals("")) {
                sum+=Integer.parseInt(array[i]);
                if(max <sum) {
                    max =sum;
                }
            }
            else {
                sum=0;
            }
        }

        return max;
    }

    public static int day1No2() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day1.txt");

        int sum =0;
        int no1 =0;
        int no2 =0;
        int no3 =0;

        for (int i = 0; i< array.length; i++) {
            if(array[i].equals("")) {
                if(no1 < sum) {
                    no3 = no2;
                    no2= no1;
                    no1 = sum;

                }
                else if(no2 < sum) {
                    no3=no2;
                    no2 = sum;
                }
                else if(no3 < sum) {
                    no3 = sum;
                }
                sum =0;

            }
            else {

                sum +=Integer.parseInt(array[i]);
            }


        }

        if(no1 < sum) {
            no3 = no2;
            no2= no1;
            no1 = sum;

        }
        else if(no2 < sum) {
            no3=no2;
            no2 = sum;
        }
        else if(no3 < sum) {
            no3 = sum;
        }
        return sum;
    }


}
