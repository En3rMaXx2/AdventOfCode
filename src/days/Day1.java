package days;

import java.io.IOException;

import service.TextReader;

public class Day1 {

    public static int day1No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day1.txt");

        int caloriesCarriedByEachElf = 0;
        int mostCalories = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("")) {
                caloriesCarriedByEachElf = 0;
            } else {
                caloriesCarriedByEachElf += Integer.parseInt(array[i]);
            }

            if (mostCalories < caloriesCarriedByEachElf) {
                mostCalories = caloriesCarriedByEachElf;
            }
        }

        return mostCalories;
    }

    public static int day1No2() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day1.txt");

        int caloriesCarriedByEachElf = 0;
        int no1_Elf = 0;
        int no2_Elf = 0;
        int no3_Elf = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("")) {
                caloriesCarriedByEachElf = 0;
            } else {
                caloriesCarriedByEachElf += Integer.parseInt(array[i]);
            }

            if (no1_Elf < caloriesCarriedByEachElf) {
                no3_Elf = no2_Elf;
                no2_Elf = no1_Elf;
                no1_Elf = caloriesCarriedByEachElf;

            } else if (no2_Elf < caloriesCarriedByEachElf) {
                no3_Elf = no2_Elf;
                no2_Elf = caloriesCarriedByEachElf;

            } else if (no3_Elf < caloriesCarriedByEachElf) {
                no3_Elf = caloriesCarriedByEachElf;

            }
        }

        int sumOfCalories = no1_Elf + no2_Elf + no3_Elf;
        return sumOfCalories;
    }
}
