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
        String[] array1 = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day1.txt");

        int sum1=0;
        int no1 =0;
        int no2 =0;
        int no3 =0;

        for (int i=0; i<array1.length; i++) {
            if(array1[i].equals("")) {
                if(no1 <sum1) {
                    no3 = no2;
                    no2= no1;
                    no1 =sum1;

                }
                else if(no2 <sum1) {
                    no3=no2;
                    no2 =sum1;
                }
                else if(no3 <sum1) {
                    no3 =sum1;
                }
                sum1=0;

            }
            else {

                sum1+=Integer.parseInt(array1[i]);
            }


        }

        if(no1 <sum1) {
            no3 = no2;
            no2= no1;
            no1 =sum1;

        }
        else if(no2 <sum1) {
            no3=no2;
            no2 =sum1;
        }
        else if(no3 <sum1) {
            no3 =sum1;
        }
        return sum1;
    }


}
