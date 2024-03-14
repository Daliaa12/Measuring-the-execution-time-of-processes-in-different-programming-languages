import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemoryAccessJava {

    private static int NUMBER_OF_INTEGERS = 0;

    public static void readConstantsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\Masuratori.txt"))) {
            String line;
            boolean ok = false;
            while ((line = reader.readLine()) != null) {
                if (line.equals("Memory Access")) {
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

    public static void staticAccess(FileWriter fileWriter) throws IOException {
        fileWriter.write("Sir static\n");
        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_INTEGERS; i++) {
            v.add(0);
        }

        double total_time = 0;
        for (int j = 0; j < 10; j++) {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < NUMBER_OF_INTEGERS; i++) {
                v.set(i, i);
            }
            long endTime = System.currentTimeMillis();
            if (endTime - startTime != 0) {
                total_time += (endTime - startTime) / 1000.0;
            }
        }

        double mean_time = total_time / 10;
        fileWriter.write(String.format("=> %.8s secunde\n", mean_time));
    }

    public static void main(String[] args) {
        readConstantsFromFile();

        try (FileWriter fileWriter = new FileWriter("C:\\Users\\dalia\\OneDrive\\Desktop\\SSC-project.1\\AccesMemorie_Java.txt")) {
            fileWriter.write("Java\n");
            fileWriter.write("Masurarea accesului la memorie a unui sir cu " + NUMBER_OF_INTEGERS + " intregi \n\n");

            staticAccess(fileWriter);

            // DYNAMIC
            fileWriter.write("\nSir dinamic\n");
            List<Integer> v = new ArrayList<>();
            for (int i = 0; i < NUMBER_OF_INTEGERS; i++) {
                v.add(0);
            }

            double total_time_dynamic = 0;
            for (int j = 0; j < 10; j++) {
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < NUMBER_OF_INTEGERS; i++) {
                    v.set(i, i);
                }
                long endTime = System.currentTimeMillis();
                if (endTime - startTime != 0) {
                    total_time_dynamic += (endTime - startTime) / 1000.0;
                }
            }

            double mean_time_dynamic = total_time_dynamic / 10;
            fileWriter.write(String.format("=> %.8s secunde\n", mean_time_dynamic));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}