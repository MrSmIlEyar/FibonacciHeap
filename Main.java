import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws IOException {

        fibHeap fh = new fibHeap();

        File file = new File("data.txt");

        Scanner sc = new Scanner(file);

        FileWriter writer = new FileWriter("insertStatistics.txt");

        while (sc.hasNextLine()) {
            long start = System.currentTimeMillis();
            fh.insert(Integer.parseInt(sc.nextLine()));
            long end = System.currentTimeMillis();
            writer.write(end - start + "\n");
        }
        sc.close();
        writer.close();

        Scanner sc2 = new Scanner(file);

        FileWriter writer2 = new FileWriter("findStatistics.txt");

        Integer[] indexes = new Integer[100];

        Random ran = new Random();

        for (int i = 0; i < 100; i++) {
            indexes[i] = ran.nextInt(10000) + 1;
        }

        int k = 0;
        while (sc2.hasNextLine()) {
            String s = sc2.nextLine();
            if (Arrays.asList(indexes).contains(k)) {
                int n = Integer.parseInt(s);
                long start = System.currentTimeMillis();
                fh.find(n);
                long end = System.currentTimeMillis();
                writer2.write(end - start + "\n");
            }
            k++;

        }
        sc2.close();
        writer2.close();

        Scanner sc3 = new Scanner(file);

        FileWriter writer3 = new FileWriter("removeStatistics.txt");

        for (int i = 0; i < 1000; i++) {
            long start = System.nanoTime();
            int u = fh.extract_min();
            long end = System.nanoTime();
            System.out.println(u);
            writer3.write(end - start + "\n");
        }

        sc3.close();
        writer3.close();

    }
}
