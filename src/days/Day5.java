package days;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import service.TextReader;

public class Day5 {

    //TODO edit method that Day5Example.txt and Day5.txt work without the "]" at the end
    public static String day5No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day5.txt");
        int locateLastRowOfStack = 0;
        int locateBeginningOfText = 0;
        int amoutOfStacks = 0;

        while (array[locateLastRowOfStack + 1].charAt(1) != '1') {
            locateLastRowOfStack++;
        }

        amoutOfStacks = array[locateLastRowOfStack + 1].charAt(array[locateLastRowOfStack + 1].length() - 1) - 48;

        List<Stack<Character>> listOfCrates = new ArrayList<>();
        for (int i = 0; i < amoutOfStacks; i++) {
            listOfCrates.add(new Stack<>());
        }


        for (int i = locateLastRowOfStack; i >= 0; i--) {
            int whichStack = 0;
            int charPlaceInRow = 1;

            for (int j = 0; j < amoutOfStacks; j++) {
                if (array[i].charAt(charPlaceInRow) != ' ') {
                    listOfCrates.get(whichStack).push(array[i].charAt(charPlaceInRow));
                }
                whichStack++;
                charPlaceInRow += 4;
            }
        }

        while (!array[locateBeginningOfText].isEmpty()) {
            locateBeginningOfText++;
        }
        locateBeginningOfText++;

        for (int i = locateBeginningOfText; i < array.length; i++) {

            int howManyCrates = 0;
            int fromWhere = 0;
            int toWhere = 0;

            String[] arraySplit = array[i].split(" ");
            howManyCrates = Integer.parseInt(arraySplit[1]);
            fromWhere = Integer.parseInt(arraySplit[3]) - 1;
            toWhere = Integer.parseInt(arraySplit[5]) - 1;

            while (howManyCrates != 0) {
                listOfCrates.get(toWhere).push(listOfCrates.get(fromWhere).peek());
                listOfCrates.get(fromWhere).pop();
                howManyCrates--;
            }
        }

        String result = "";
        for (int i = 0; i < amoutOfStacks; i++) {
            if (listOfCrates.get(i) != null) {
                result += listOfCrates.get(i).peek();
            }
        }
        return result;
    }

    public static String day5No2() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day5.txt");
        int locateLastRowOfStack = 0;
        int locateBeginningOfText = 0;
        int amoutOfStacks = 0;

        while (array[locateLastRowOfStack + 1].charAt(1) != '1') {
            locateLastRowOfStack++;
        }

        amoutOfStacks = array[locateLastRowOfStack + 1].charAt(array[locateLastRowOfStack + 1].length() - 1) - 48;

        List<Stack<Character>> listOfStacksCrates = new ArrayList<>();
        for (int i = 0; i < amoutOfStacks; i++) {
            listOfStacksCrates.add(new Stack<>());
        }


        for (int i = locateLastRowOfStack; i >= 0; i--) {
            int whichStack = 0;
            int charPlaceInRow = 1;

            for (int j = 0; j < amoutOfStacks; j++) {
                if (array[i].charAt(charPlaceInRow) != ' ') {
                    listOfStacksCrates.get(whichStack).push(array[i].charAt(charPlaceInRow));
                }
                whichStack++;
                charPlaceInRow += 4;
            }
        }

        while (!array[locateBeginningOfText].isEmpty()) {
            locateBeginningOfText++;
        }
        locateBeginningOfText++;

        Stack<Character> tempStackCrates = new Stack<Character>();
        for (int i = locateBeginningOfText; i < array.length; i++) {

            int howManyCrates = 0;
            int tempHowManyCrates = 0;
            int fromWhere = 0;
            int toWhere = 0;

            String[] arraySplit = array[i].split(" ");
            howManyCrates = Integer.parseInt(arraySplit[1]);
            fromWhere = Integer.parseInt(arraySplit[3]) - 1;
            toWhere = Integer.parseInt(arraySplit[5]) - 1;
            tempHowManyCrates = howManyCrates;

            while (howManyCrates != 0) {
                tempStackCrates.push(listOfStacksCrates.get(fromWhere).peek());
                listOfStacksCrates.get(fromWhere).pop();
                howManyCrates--;
            }

            while (tempHowManyCrates != 0) {
                listOfStacksCrates.get(toWhere).push(tempStackCrates.peek());
                tempStackCrates.pop();
                tempHowManyCrates--;
            }
        }

        String result = "";
        for (int i = 0; i < amoutOfStacks; i++) {
            if (listOfStacksCrates.get(i) != null) {
                result += listOfStacksCrates.get(i).peek();
            }
        }
        return result;
    }
}
