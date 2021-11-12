package Lab8;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "src/Lab8/text.txt";
        Scanner scanner = new Scanner(System.in);
        String text = "";
        while (scanner.hasNextLine()) {
            text += "\n" + scanner.nextLine();
        }
        try {
           // Files.write(Paths.get(filePath), text.getBytes(), StandardOpenOption.APPEND);
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(text);
            writer.flush();
            writer.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
    }
}