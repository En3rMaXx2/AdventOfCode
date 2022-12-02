import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //Day1 No1
        String[] array = textFileToArray("C:/AOCInput/Day1.txt");

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

        //System.out.println(max);

        //Day1 No2
        String[] array1 = textFileToArray("C:/AOCInput/Day1.txt");

        int sum1=0;
        int no1 =0;
        int no2 =0;
        int no3 =0;

        for (int i=0; i<array1.length; i++) {
            if(array1[i].equals("")) {
                System.out.println(sum1);
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

        sum1 = no1 + no2 + no3;
        System.out.println(" 1: " + no1 + " 2: " + no2 + " 3: " + no3 + " s: " + sum1);
    }

    public static String[] textFileToArray(String path) throws IOException {
        List<String> listOfStrings = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(new FileReader(path));
        String line = bf.readLine();

        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }

        bf.close();

        String[] textFileArray = listOfStrings.toArray(new String[0]);

        return textFileArray;
    }
}
