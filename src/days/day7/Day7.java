package days.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import service.TextReader;

//Copyright @VincentSteele
//https://github.com/VincentSteele/aoc22
public class Day7 {

    public static int day7No1() throws IOException {
        String[] array = TextReader.textFileToArray("C:/Projekte/AdventOfCode/src/resources/day7/Day7Example.txt");
        final  String INPUT_FILE = "C:/Projekte/AdventOfCode/src/resources/day7/Day7.txt";
        final int TOTAL_SPACE = 70000000;
        final int NEEDED_UNUSED_SPACE = 30000000;


        BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));

        Folder root = new Folder("", null);
        root.addChild(new Folder("/", null));

        Folder currentFolder  = root;

        for (String line = reader.readLine(); line != null; line = reader.readLine())
        {
            if (line.startsWith("$"))
            {
                if (line.charAt(2) == 'c')
                {
                    if (line.charAt(5) == '.')
                    {
                        currentFolder = currentFolder.goUpFolder();
                    }
                    else
                    {
                        String name = line.substring(line.lastIndexOf(' ') + 1);
                        currentFolder = currentFolder.changeFolder(name);

                    }
                }
            }
            else if (line.startsWith("d"))
            {
                String name = line.substring(line.lastIndexOf(' ') + 1);
                currentFolder.addChild(new Folder(name, currentFolder));
            }
            else
            {
                int size = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                String name = line.substring(line.lastIndexOf(' ') + 1);
                currentFolder.addChild(new File(name, size));
            }
        }

        reader.close();

        // puzzle 1

        int sum = root.getAllFolders().stream()
                .filter(f -> f.getSize() <= 100000)
                .mapToInt(Folder::getSize)
                .sum();

        System.out.println("Sum of directory sizes <= 100000: " + sum);

        // puzzle 2

        int unusedSpace = TOTAL_SPACE - root.getSize();
        int spaceToDelete = NEEDED_UNUSED_SPACE - unusedSpace;

        int sizeOfFolder = root.getAllFolders().stream()
                .filter(f -> f.getSize() >= spaceToDelete)
                .mapToInt(Folder::getSize)
                .sorted()
                .findFirst()
                .getAsInt();

        System.out.println("Size of folder to delete: " + sizeOfFolder);

        return 0;
    }
}
