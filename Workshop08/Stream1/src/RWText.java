import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class RWText {
    public static void main(String[] args) {
        String fileName = "file.txt";
        try {
            // FileWriter without append mode
            FileWriter fileWriter1 = new FileWriter(fileName);
            fileWriter1.write("hello at first line\n");
            fileWriter1.close();
            // FileWriter with append mode
            FileWriter fileWriter2 = new FileWriter(fileName, true);
            fileWriter2.write("hello second line(appended) \n");
            fileWriter2.close();
            // FileReader
            FileReader fileReader1 = new FileReader(fileName);
            int i;
            while ((i = fileReader1.read()) != -1) {
                System.out.print((char) i);
            }
            fileReader1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}