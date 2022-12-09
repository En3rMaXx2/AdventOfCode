package days.day7;

import java.io.IOException;

import service.TextReader;

public class Day7 {

    public static int day7No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/day7/Day7Example.txt");
        int dirSum =0;
        int endSum=0;


        for (int i=1; i<array.length-1; i++) {
            String[] split = array[i].split(" ");


            if(split[0].equals("$")){
                if(dirSum < 100000) {
                    endSum+= dirSum;
                    //System.out.println(dirSum);
                }
                dirSum =0;
            }
            else if(split[0].equals("dir")) {

            }
            else {



                try {
                    dirSum += Integer.parseInt(split[0]);
                }
                catch (NumberFormatException e) {
                    //nothing
                }





            }

        }

        return endSum;
    }
}
