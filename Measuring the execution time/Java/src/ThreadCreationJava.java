import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadCreationJava {

    private static int NUMBER_OF_THREADS = 0;

    public static void readConstantsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\Masuratori.txt"))) {
            String line;
            boolean ok = false;
            while ((line = reader.readLine()) != null) {
                if (line.equals("Thread Creation")) {
                    ok = true;
                } else if (ok) {
                    NUMBER_OF_THREADS = Integer.parseInt(line);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Thread[] createThreads() {
        Thread[] threads = new Thread[NUMBER_OF_THREADS];
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i] = new Thread();
        }
        return threads;
    }

    public static void main(String[] args) {
        readConstantsFromFile();

        try (FileWriter fileWriter = new FileWriter("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\CreareThreaduriJava.txt")) {
            fileWriter.write("Java\n");
            fileWriter.write("Masurarea alocarii a " + NUMBER_OF_THREADS + " threaduri \n\n");

            double total_time = 0;
            int j = 0;

            while (j < 10) {
                long startTime = System.currentTimeMillis();
                createThreads();
                long endTime = System.currentTimeMillis();
                if (endTime - startTime != 0) {
                    total_time += (endTime - startTime) / 1000.0;
                    j++;
                }
            }

            double mean_time = total_time / 10;
            fileWriter.write(String.format("=> %.8s secunde\n", mean_time));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}