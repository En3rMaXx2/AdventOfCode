package days;

import java.io.IOException;
import service.TextReader;

public class Day2 {
    public static int day2No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day2.txt");
        int score=0;
        int opponentInt=0;
        int myselfInt=0;

        for (int i=0; i<array.length; i++) {
            String opponent = array[i].substring(0,1);
            String myself = array[i].substring(2);
            switch(myself) {
                case "X": //Rock
                    score+=1;
                    myselfInt=1;
                    break;
                case "Y": //Paper
                    score+=2;
                    myselfInt=2;
                    break;
                case "Z": //Scissors
                    score+=3;
                    myselfInt=3;
                    break;
            }

            switch(opponent) {
                case "A": //Rock
                    opponentInt=1;
                    break;
                case "B": //Paper
                    opponentInt=2;
                    break;
                case "C": //Scissors
                    opponentInt=3;
                    break;
            }

            if(myselfInt==opponentInt) {
                score+=3;
            }
            else if(myselfInt==1 && opponentInt==2) {
                score+=0;
            }
            else if(myselfInt==1 && opponentInt==3) {
                score+=6;
            }
            else if(myselfInt==2 && opponentInt==1) {
                score+=6;
            }
            else if(myselfInt==2 && opponentInt==3) {
                score+=0;
            }
            else if(myselfInt==3 && opponentInt==1) {
                score+=0;
            }
            else if(myselfInt==3 && opponentInt==2) {
                score += 6;
            }
        }

        return score;
    }

    public static int day2No2() throws IOException {

        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/Day2.txt");
        int score=0;
        int opponentInt=0;
        int myselfInt=0;
        String opponent;
        String myself;

        for (int i=0; i<array.length; i++) {
            opponent = array[i].substring(0,1);
            myself = array[i].substring(2);

            switch(opponent) {
                case "A": //Rock
                    opponentInt=1;
                    break;
                case "B": //Paper
                    opponentInt=2;
                    break;
                case "C": //Scissors
                    opponentInt=3;
                    break;
            }
            if(opponentInt==1) {
                if(myself.equals("X")) {
                    myselfInt=3;
                    score+=3;
                }
                if(myself.equals("Y")) {
                    myselfInt=1;
                    score+=1;
                }
                if(myself.equals("Z")) {
                    myselfInt=2;
                    score+=2;
                }
            }
            else if(opponentInt==2) {
                if(myself.equals("X")) {
                    myselfInt=1;
                    score+=1;
                }
                if(myself.equals("Y")) {
                    myselfInt=2;
                    score+=2;
                }
                if(myself.equals("Z")) {
                    myselfInt=3;
                    score+=3;
                }
            }
            else if(opponentInt==3) {
                if(myself.equals("X")) {
                    myselfInt=2;
                    score+=2;
                }
                if(myself.equals("Y")) {
                    myselfInt=3;
                    score+=3;
                }
                if(myself.equals("Z")) {
                    myselfInt=1;
                    score+=1;
                }
            }

            if(myselfInt==opponentInt) {
                score+=3;
            }
            else if(myselfInt==1 && opponentInt==2) {
                score+=0;
            }
            else if(myselfInt==1 && opponentInt==3) {
                score+=6;
            }
            else if(myselfInt==2 && opponentInt==1) {
                score+=6;
            }
            else if(myselfInt==2 && opponentInt==3) {
                score+=0;
            }
            else if(myselfInt==3 && opponentInt==1) {
                score+=0;
            }
            else if(myselfInt==3 && opponentInt==2) {
                score += 6;
            }
        }

        return score;
    }



}
