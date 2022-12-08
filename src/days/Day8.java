package days;

import java.io.IOException;

import service.TextReader;

public class Day8 {

    public static int day8No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day8.txt");

        int[][] treeSystem=new int[array[0].length()][array.length];
        int counter=0;
        boolean isTreeInTheWay;

        for (int y = 0; y <treeSystem.length; y++) {
            for (int x = 0; x <treeSystem[y].length; x++) {
                treeSystem[y][x]=Integer.parseInt(String.valueOf(array[y].charAt(x)));
            }
        }
        for (int y = 1; y <treeSystem.length-1; y++) {
            for (int x = 1; x < treeSystem[y].length - 1; x++) {

                isTreeInTheWay = isTreeInTheWayNo1(treeSystem, y, x);
                System.out.println(isTreeInTheWay + "\n");
                if (!isTreeInTheWay) {
                    counter++;
                }

            }
        }

        counter += treeSystem.length*2;
        counter += treeSystem.length*2-4;

        return counter;
    }

    public static boolean isTreeInTheWayNo1(int[][] treeSystem, int y, int x) {

        int mainTree = treeSystem[y][x];
        boolean xToMain=false;
        boolean mainToXEnd=false;
        boolean yToMain=false;
        boolean mainToYEnd=false;

        // 3  0  3  7  3
        // 2  5 |5| 1  2
        // 6  5  3  3  2
        // 3  3  5  4  9
        // 3  5  3  9  0
        // treeSystem[1][2] = 5

        for (int i = 0; i < x; i++) {
            if (mainTree <= treeSystem[y][i]) {
                xToMain = true;
            }
        }

        for (int i = x + 1; i < treeSystem[y].length; i++) {

            if (mainTree <= treeSystem[y][i]) {
                mainToXEnd = true;
            }

        }

        for (int i = 0; i < y; i++) {

            if (mainTree <= treeSystem[i][x]) {
                yToMain = true;
            }
        }

        for (int i = y + 1; i < treeSystem.length; i++) {
            if (mainTree <= treeSystem[i][x]) {
                mainToYEnd = true;
            }
        }

        System.out.println(mainTree);
        if (xToMain && mainToXEnd && yToMain && mainToYEnd) {
            return true;
        }
        return false;
    }

    public static int day8No2() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day8.txt");

        int[][] treeSystem=new int[array[0].length()][array.length];
        int tempSpot=0;
        int perfectSpot=0;

        for (int y = 0; y <treeSystem.length; y++) {
            for (int x = 0; x <treeSystem[y].length; x++) {
                treeSystem[y][x]=Integer.parseInt(String.valueOf(array[y].charAt(x)));
            }
        }
        for (int y = 1; y <treeSystem.length-1; y++) {
            for (int x = 1; x < treeSystem[y].length - 1; x++) {

                tempSpot = isTreeInTheWayNo2(treeSystem, y, x);
                if(tempSpot > perfectSpot) {
                    perfectSpot=tempSpot;
                }
            }
        }


        return perfectSpot;
    }

    public static int isTreeInTheWayNo2(int[][] treeSystem, int y, int x) {

        int mainTree = treeSystem[y][x];
        int lookingLeft =0;
        int lookingRight =0;
        int lookingUp =0;
        int lookingDown =0;
        int sum=0;

        System.out.println(mainTree);
        // 3  0  3  7  3
        // 2  5 |5| 1  2
        // 6  5  3  3  2
        // 3  3  5  4  9
        // 3  5  3  9  0
        // treeSystem[1][2] = 5




        for (int i = x-1; i >= 0; i--) {
            if (mainTree > treeSystem[y][i]) {
                lookingLeft++;
            } else if (mainTree == treeSystem[y][i]) {
                lookingLeft++;
                break;
            }
            else {
                lookingLeft++;
                break;
            }
        }
        System.out.println("lookingLeft "+lookingLeft);
        for (int i = x+1; i < treeSystem[y].length; i++) {

            if (mainTree > treeSystem[y][i]) {
                lookingRight++;
            }
            else if (mainTree == treeSystem[y][i]) {
                lookingRight++;
                break;
            }
            else {
                lookingRight++;
                break;
            }

        }
        System.out.println("lookingRight " +lookingRight);
        for (int i = y-1; i >= 0; i--) {

            if (mainTree > treeSystem[i][x]) {
                lookingUp++;
            }
            else if (mainTree == treeSystem[i][x]) {
                lookingUp++;
                break;
            }
            else {
                lookingUp++;
                break;
            }
        }
        System.out.println("lookingUp " + lookingUp);
        for (int i = y + 1; i < treeSystem.length; i++) {
            if (mainTree > treeSystem[i][x]) {
                lookingDown++;
            }
            else if (mainTree == treeSystem[i][x]) {
                lookingDown++;
                break;
            }
            else {
                lookingDown++;
                break;
            }
        }
        System.out.println("lookingDown " +lookingDown);

        sum = lookingLeft * lookingRight * lookingUp * lookingDown;
        System.out.println(sum);
        return sum;
    }

}
