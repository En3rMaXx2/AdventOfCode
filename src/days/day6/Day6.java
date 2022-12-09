package days.day6;

import java.io.IOException;

import service.TextReader;

public class Day6 {

    public static int day6No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/day6/Day6.txt");
        String _4Characters = "";
        int afterCharacter = 4;

        for (int i = 0; i < afterCharacter; i++) {
            _4Characters += String.valueOf(array[0].charAt(i));
        }

        boolean repeat;

        do {
            repeat = false;

            for (int i = 0; i < _4Characters.length() - 1; i++) {
                for (int j = i + 1; j < _4Characters.length(); j++) {
                    if (_4Characters.charAt(i) == _4Characters.charAt(j)) {
                        repeat = true;
                        break;
                    }
                }
            }

            if (repeat) {
                _4Characters += String.valueOf(array[0].charAt(afterCharacter));
                _4Characters = _4Characters.substring(1);
                afterCharacter++;
            }


        } while (repeat);

        return afterCharacter;
    }

    public static int day6No2() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/day6/Day6.txt");
        String _14Characters = "";
        int afterCharacter = 14;

        for (int i = 0; i < afterCharacter; i++) {
            _14Characters += String.valueOf(array[0].charAt(i));
        }

        boolean repeat;

        do {
            repeat = false;

            for (int i = 0; i < _14Characters.length() - 1; i++) {
                for (int j = i + 1; j < _14Characters.length(); j++) {
                    if (_14Characters.charAt(i) == _14Characters.charAt(j)) {
                        repeat = true;
                        break;
                    }
                }
            }

            if (repeat) {
                _14Characters += String.valueOf(array[0].charAt(afterCharacter));
                _14Characters = _14Characters.substring(1);
                afterCharacter++;
            }


        } while (repeat);

        return afterCharacter;
    }
}
