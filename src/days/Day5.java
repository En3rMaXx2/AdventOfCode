package days;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import service.TextReader;

public class Day5 {

    //TODO refactor
    public static String day5No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day5.txt");

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


            if (array[i].charAt(13) != ' ') {
                listOfCrates.get(3).push(array[i].charAt(13));
            }
            if (array[i].charAt(17) != ' ') {
                listOfCrates.get(4).push(array[i].charAt(17));
            }
            if (array[i].charAt(21) != ' ') {
                listOfCrates.get(5).push(array[i].charAt(21));
            }
            if (array[i].charAt(25) != ' ') {
                listOfCrates.get(6).push(array[i].charAt(25));
            }
            if (array[i].charAt(29) != ' ') {
                listOfCrates.get(7).push(array[i].charAt(29));
            }
            if (array[i].charAt(33) != ' ') {
                listOfCrates.get(8).push(array[i].charAt(33));
            }


        }

        while (array[x].charAt(0) != 'm') {
            x++;
        }

        for (int i = x; i < array.length; i++) {

            int howManyCrates = 0;
            int from = 0;
            int to = 0;

            String[] arraySplit = array[i].split(" ");
            howManyCrates = Integer.parseInt(arraySplit[1]);
            from = Integer.parseInt(arraySplit[3]);
            to = Integer.parseInt(arraySplit[5]);

            while (howManyCrates != 0) {
                listOfCrates.get(to - 1).push(listOfCrates.get(from - 1).peek());
                listOfCrates.get(from - 1).pop();
                howManyCrates--;
            }

        }

        String result = "";
        for (int i = 0; i < 9; i++) {
            if (listOfCrates.get(i) != null) {
                result += listOfCrates.get(i).peek();
            }
        }
        return result;
    }

    public static String day5No2() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day5.txt");

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


            if (array[i].charAt(13) != ' ') {
                listOfCrates.get(3).push(array[i].charAt(13));
            }
            if (array[i].charAt(17) != ' ') {
                listOfCrates.get(4).push(array[i].charAt(17));
            }
            if (array[i].charAt(21) != ' ') {
                listOfCrates.get(5).push(array[i].charAt(21));
            }
            if (array[i].charAt(25) != ' ') {
                listOfCrates.get(6).push(array[i].charAt(25));
            }
            if (array[i].charAt(29) != ' ') {
                listOfCrates.get(7).push(array[i].charAt(29));
            }
            if (array[i].charAt(33) != ' ') {
                listOfCrates.get(8).push(array[i].charAt(33));
            }
        }

        while (array[x].charAt(0) != 'm') {
            x++;
        }

        Stack<Character> temp = new Stack<Character>();

        for (int i = x; i < array.length; i++) {

            int howManyCrates = 0;
            int tempHowManyCrates = 0;
            int from = 0;
            int to = 0;

            String[] arraySplit = array[i].split(" ");
            howManyCrates = Integer.parseInt(arraySplit[1]);
            from = Integer.parseInt(arraySplit[3]);
            to = Integer.parseInt(arraySplit[5]);

            tempHowManyCrates = howManyCrates;

            while (howManyCrates != 0) {
                temp.push(listOfCrates.get(from - 1).peek());
                listOfCrates.get(from - 1).pop();
                howManyCrates--;
            }
            while (tempHowManyCrates != 0) {
                listOfCrates.get(to - 1).push(temp.peek());
                temp.pop();
                tempHowManyCrates--;
            }

        }

        String result = "";
        for (int i = 0; i < 9; i++) {
            if (listOfCrates.get(i) != null) {
                result += listOfCrates.get(i).peek();
            }
        }
        return result;
    }
}
