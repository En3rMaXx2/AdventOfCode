package days;

import java.io.IOException;
import service.TextReader;

public class Day4 {

    public static int day4No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day4.txt");
        String beginA="";
        String endA="";
        String beginB="";
        String endB="";

        int counter=0;

        boolean checkFirst=true;

        String temp="";

        for (int i=0; i<array.length; i++) {

            for (int a=0; a<array[i].length(); a++) {

                if(array[i].charAt(a) == '-' && checkFirst==true) {
                    beginA=temp;
                    temp="";
                    a++;
                    checkFirst=false;
                }
                if(array[i].charAt(a) == '-' && checkFirst==false) {
                    beginB=temp;
                    temp="";
                    a++;
                }
                else if(array[i].charAt(a) == ',') {
                    endA=temp;
                    temp="";
                    a++;
                }
                temp+=array[i].charAt(a);
                }
            endB=temp;
            temp="";

            System.out.println(beginA + "-" + endA + "," + beginB + "-" + endB);

            if (Integer.parseInt(beginA) <= Integer.parseInt(beginB) && Integer.parseInt(endA) >= Integer.parseInt(endB)) {
                counter++;
            }
            else if (Integer.parseInt(beginA) >= Integer.parseInt(beginB) && Integer.parseInt(endA) <= Integer.parseInt(endB)) {
                counter++;
            }

            checkFirst=true;
            beginA="";
            beginB="";
            endA="";
            endB="";
        }

        return counter;
    }

    public static int day4No2() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day4.txt");
        String beginA="";
        String endA="";
        String beginB="";
        String endB="";

        int counter=0;

        boolean checkFirst=true;

        String temp="";

        for (int i=0; i<array.length; i++) {

            for (int a=0; a<array[i].length(); a++) {

                if(array[i].charAt(a) == '-' && checkFirst==true) {
                    beginA=temp;
                    temp="";
                    a++;
                    checkFirst=false;
                }
                if(array[i].charAt(a) == '-' && checkFirst==false) {
                    beginB=temp;
                    temp="";
                    a++;
                }
                else if(array[i].charAt(a) == ',') {
                    endA=temp;
                    temp="";
                    a++;
                }
                temp+=array[i].charAt(a);
            }
            endB=temp;
            temp="";

            System.out.println(beginA + "-" + endA + "," + beginB + "-" + endB);

            if (Integer.parseInt(beginA) > Integer.parseInt(endB) && Integer.parseInt(endB) < Integer.parseInt(beginA)) {
                System.out.println("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
            }
            else if (Integer.parseInt(endA) >= Integer.parseInt(beginB) && Integer.parseInt(beginB) <= Integer.parseInt(endA)) {
                counter++;
            }
            else {
                System.out.println("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
            }

            checkFirst=true;
            beginA="";
            beginB="";
            endA="";
            endB="";
        }

        return counter;
    }
}
