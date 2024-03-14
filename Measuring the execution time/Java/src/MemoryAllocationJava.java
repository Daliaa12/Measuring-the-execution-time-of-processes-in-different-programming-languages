import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemoryAllocationJava {

    private static int NUMBER_OF_INTEGERS = 0;

    public static void readConstantsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\Masuratori.txt"))) {
            String line;
            boolean ok = false;
            while ((line = reader.readLine()) != null) {
                if (line.equals("Memory Allocation")) {
                    ok = true;
                } else if (ok) {
                    NUMBER_OF_INTEGERS = Integer.parseInt(line);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readConstantsFromFile();

        try (FileWriter fileWriter = new FileWriter("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\AlocareaMemoriei_Java.txt")) {
            fileWriter.write("Java\n");
            fileWriter.write("Masurarea alocarii unui sir cu " + NUMBER_OF_INTEGERS + " intregi \n\n");

            List<Integer> v = new ArrayList<>();
            double total_time = 0;
            int j = 0;

            while (j < 10) {
                long startTime = System.currentTimeMillis();

                for (int i = 0; i < NUMBER_OF_INTEGERS; i++) {
                    v.add(i);
                }

                long endTime = System.currentTimeMillis();

                if (endTime - startTime != 0) {
                    total_time += (endTime - startTime) / 1000.0;
                    j++;
                }

                v.clear();
                System.gc();
            }

            double mean_time = total_time / 10;
            fileWriter.write(String.format("=> %.8s secunde\n", mean_time));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
