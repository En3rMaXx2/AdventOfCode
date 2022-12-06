package days;

import java.io.IOException;

import service.TextReader;

public class Day6 {

    public static int day6No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day6.txt");

        String _4Characters = String.valueOf(array[0].charAt(0) + "" + array[0].charAt(1) + "" + array[0].charAt(2) + "" + array[0].charAt(3));
        boolean repeat;
        int afterCharacter = 4;


        do {
            repeat = false;

            for (int i = 0; i < _4Characters.length() - 1; i++) {
                for (int j = i + 1; j < _4Characters.length(); j++) {
                    if (_4Characters.charAt(i) == _4Characters.charAt(j)) {
                        repeat = true;
                    }
                }
            }

            if (repeat) {
                _4Characters += String.valueOf("" + array[0].charAt(afterCharacter));
                _4Characters = _4Characters.substring(1);
                afterCharacter++;
            }


        } while (repeat);

        return afterCharacter;
    }

    public static int day6No2() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day6.txt");

        String _14Characters = "";
        for (int i = 0; i < 14; i++) {
            _14Characters += String.valueOf(array[0].charAt(i));
        }

        boolean repeat;
        int afterCharacter = 14;


        do {
            repeat = false;

            for (int i = 0; i < _14Characters.length() - 1; i++) {
                for (int j = i + 1; j < _14Characters.length(); j++) {
                    if (_14Characters.charAt(i) == _14Characters.charAt(j)) {
                        repeat = true;
                    }
                }
            }

            if (repeat) {
                _14Characters += String.valueOf("" + array[0].charAt(afterCharacter));
                _14Characters = _14Characters.substring(1);
                afterCharacter++;
            }


        } while (repeat);

        return afterCharacter;
    }
}
