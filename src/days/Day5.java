package days;

import java.io.IOException;
import java.util.Stack;

import service.TextReader;

public class Day5 {

    public static int day5No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day5Example.txt");
        for (int i =0; i<array.length; i++) {

            int x=0;
            while(array[x].charAt(0) != 'm') {
                System.out.println(array[x].charAt(0));
                array[x].replaceAll("\\s","");
                x++;
            }
            //System.out.println(array[x+1].charAt(array[x+1].length()));

            Stack<String>[] crates = new Stack[9];


        }



        return 0;
    }
}
