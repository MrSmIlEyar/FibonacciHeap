import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;



public class GenerateData {


    public static void main(String[] args) throws IOException {
        Random ran = new Random();
        try {
            FileWriter file = new FileWriter("data.txt");
            for (int i = 0; i <= 10500; i++) {
                file.write(ran.nextInt() + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        File file = new File("data.txt");
        Scanner sc = new Scanner(file);
        int k = 0;
        while (sc.hasNextLine()) {
            k++;
            sc.nextLine();
        }
        System.out.println(k);
        sc.close();
    }


}
