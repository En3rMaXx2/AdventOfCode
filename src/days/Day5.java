package days;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import service.TextReader;

public class Day5 {



    public static String day5No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day5Example.txt");

        List<Stack<Character>> listOfCrates = Arrays.asList(new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>());


        int x = 0;
        while (array[x].charAt(1) != '1') {
            x++;
        }
        x--;

        for (int i = x; i >= 0; i--) {
            if (array[i].charAt(1) != ' ') {
                listOfCrates.get(0).push(array[i].charAt(1));
            }
            if (array[i].charAt(5) != ' ') {
                listOfCrates.get(1).push(array[i].charAt(5));
            }
            if (array[i].charAt(9) != ' ') {
                listOfCrates.get(2).push(array[i].charAt(9));
            }
            System.out.println(listOfCrates.get(0).peek() + " " + listOfCrates.get(1).peek() + " " + listOfCrates.get(2).peek() + " ");
        }


        x += 3;

        for (int i = x; i < array.length; i++) {

            int howManyCrates = 0;
            int from = 0;
            int to = 0;

            String[] arraySplit = array[i].split(" ");
            howManyCrates=Integer.parseInt(arraySplit[1]);
            from=Integer.parseInt(arraySplit[3]);
            to=Integer.parseInt(arraySplit[5]);

            System.out.println("How many: " + howManyCrates + " From where: " + from + " to where: " + to);

            while (howManyCrates != 0) {
                listOfCrates.get(to-1).push(listOfCrates.get(from-1).peek());
                listOfCrates.get(from-1).pop();
                howManyCrates--;
            }

        }

        return listOfCrates.get(0).peek() + " " + listOfCrates.get(1).peek() + " " + listOfCrates.get(2).peek();
    }
}
