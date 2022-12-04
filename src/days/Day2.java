package days;

import java.io.IOException;

import service.TextReader;

public class Day2 {
    public static int day2No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day2.txt");
        String opponentOption;
        String myOption;
        int myScore = 0;

        for (int i = 0; i < array.length; i++) {
            opponentOption = array[i].substring(0, 1);
            myOption = array[i].substring(2);

            opponentOption = convertLetterToWord(opponentOption);
            myOption = convertLetterToWord(myOption);

            // Win 6 - Draw 3 - Lose 0 | Rock 1 - Paper - 2 - Scissors 3

            if (myOption.equals("Rock") && opponentOption.equals("Rock")) {
                myScore += 3 + 1;
            } else if (myOption.equals("Paper") && opponentOption.equals("Paper")) {
                myScore += 3 + 2;
            } else if (myOption.equals("Scissors") && opponentOption.equals("Scissors")) {
                myScore += 3 + 3;
            } else if (myOption.equals("Rock") && opponentOption.equals("Paper")) {
                myScore += 0 + 1;
            } else if (myOption.equals("Rock") && opponentOption.equals("Scissors")) {
                myScore += 6 + 1;
            } else if (myOption.equals("Paper") && opponentOption.equals("Rock")) {
                myScore += 6 + 2;
            } else if (myOption.equals("Paper") && opponentOption.equals("Scissors")) {
                myScore += 0 + 2;
            } else if (myOption.equals("Scissors") && opponentOption.equals("Rock")) {
                myScore += 0 + 3;
            } else if (myOption.equals("Scissors") && opponentOption.equals("Paper")) {
                myScore += 6 + 3;
            }
        }

        return myScore;
    }

    public static int day2No2() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day2.txt");
        String opponentOption;
        String myOption;
        int myScore = 0;

        for (int i = 0; i < array.length; i++) {
            opponentOption = array[i].substring(0, 1);
            myOption = array[i].substring(2);

            opponentOption = convertLetterToWord(opponentOption);
            myOption = convertLetterToWord(myOption);

            // Win 6 - Draw 3 - Lose 0 | Rock 1 - Paper - 2 - Scissors 3

            if (opponentOption.equals("Rock")) {
                if (myOption.equals("Rock")) {
                    myOption = "Scissors";
                } else if (myOption.equals("Paper")) {
                    myOption = "Rock";
                } else if (myOption.equals("Scissors")) {
                    myOption = "Paper";
                }

            } else if (opponentOption.equals("Paper")) {
                if (myOption.equals("Rock")) {
                    myOption = "Rock";
                } else if (myOption.equals("Paper")) {
                    myOption = "Paper";
                } else if (myOption.equals("Scissors")) {
                    myOption = "Scissors";
                }

            } else if (opponentOption.equals("Scissors")) {
                if (myOption.equals("Rock")) {
                    myOption = "Paper";
                } else if (myOption.equals("Paper")) {
                    myOption = "Scissors";
                } else if (myOption.equals("Scissors")) {
                    myOption = "Rock";
                }
            }

            if (myOption.equals("Rock") && opponentOption.equals("Rock")) {
                myScore += 3 + 1;
            } else if (myOption.equals("Paper") && opponentOption.equals("Paper")) {
                myScore += 3 + 2;
            } else if (myOption.equals("Scissors") && opponentOption.equals("Scissors")) {
                myScore += 3 + 3;
            } else if (myOption.equals("Rock") && opponentOption.equals("Paper")) {
                myScore += 0 + 1;
            } else if (myOption.equals("Rock") && opponentOption.equals("Scissors")) {
                myScore += 6 + 1;
            } else if (myOption.equals("Paper") && opponentOption.equals("Rock")) {
                myScore += 6 + 2;
            } else if (myOption.equals("Paper") && opponentOption.equals("Scissors")) {
                myScore += 0 + 2;
            } else if (myOption.equals("Scissors") && opponentOption.equals("Rock")) {
                myScore += 0 + 3;
            } else if (myOption.equals("Scissors") && opponentOption.equals("Paper")) {
                myScore += 6 + 3;
            }
        }

        return myScore;
    }

    public static String convertLetterToWord(String letter) {
        String word = "";

        // Myself:      X Rock - Y Paper - Z Scissors
        // Opponent:    A Rock - B Paper - C Scissors

        switch (letter) {
            case "A", "X":
                word = "Rock";
                break;
            case "B", "Y":
                word = "Paper";
                break;
            case "C", "Z":
                word = "Scissors";
                break;
        }
        return word;
    }
}
