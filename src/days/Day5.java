package days;

import java.io.IOException;
import java.util.Stack;

import service.TextReader;

public class Day5 {

    static Stack<Character> crates1 = new Stack<Character>();
    static Stack<Character> crates2 = new Stack<Character>();
    static Stack<Character> crates3 = new Stack<Character>();
    static Stack<Character> crates4 = new Stack<Character>();
    static Stack<Character> crates5 = new Stack<Character>();
    static Stack<Character> crates6 = new Stack<Character>();
    static Stack<Character> crates7 = new Stack<Character>();
    static Stack<Character> crates8 = new Stack<Character>();
    static Stack<Character> crates9 = new Stack<Character>();

    public static int day5No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day5Example.txt");

        int x = 0;
        while (array[x].charAt(1) != '1') {
            x++;
        }
        x--;

        for (int i = x; i >= 0; i--) {
            if (array[i].charAt(1) != ' ') {
                crates1.push(array[i].charAt(1));
            }
            if (array[i].charAt(5) != ' ') {
                crates2.push(array[i].charAt(5));
            }
            if (array[i].charAt(9) != ' ') {
                crates3.push(array[i].charAt(9));
            }
        }
        System.out.println(crates1.peek() + " " + crates2.peek() + " " + crates3.peek() + " ");

        x += 3;

        for (int i = x; i < array.length; i++) {

            int howManyCrates = 0;

            array[i] = array[i].substring(5);

            if (array[i].charAt(1) == ' ') {
                howManyCrates = Character.getNumericValue(array[i].charAt(0));
                array[i] = array[i].substring(7);
            } else if (array[i].charAt(2) == ' ') {
                howManyCrates = Character.getNumericValue(array[i].charAt(0));
                howManyCrates += 10 * Character.getNumericValue(array[i].charAt(1));
                array[i] = array[i].substring(8);
            }

            int From = 0;

            if (array[i].charAt(1) == ' ') {
                From = Character.getNumericValue(array[i].charAt(0));
                array[i] = array[i].substring(5);
            } else if (array[i].charAt(2) == ' ') {
                From = Character.getNumericValue(array[i].charAt(0));
                From += 10 * Character.getNumericValue(array[i].charAt(1));
                array[i] = array[i].substring(6);
            }

            int To = 0;

            if (array[i].charAt(0) == array[i].charAt(array[i].length() - 1)) {
                To = Character.getNumericValue(array[i].charAt(0));
            } else {
                To = Character.getNumericValue(array[i].charAt(0));
                To += 10 * Character.getNumericValue(array[i].charAt(1));
            }

            System.out.println("How many: " + howManyCrates + " From where: " + From + " to where: " + To);



            while (howManyCrates != 0) {
                crate(To).push(crate(From).peek());
                crate(From).pop();

                System.out.println(crate(To).peek() + "    " + crate(From).peek());

                howManyCrates--;
            }
            System.out.println(crates1.peek() + " " + crates2.peek() + " " + crates3.peek() + " ");
        }


        return 222222222;
    }

    public static Stack<Character> crate(int input) {
        switch (input) {
            case '1':
                return crates1;
            case '2':
                return crates2;
            case '3':
                return crates3;
        }
        return crates1;
    }
}
