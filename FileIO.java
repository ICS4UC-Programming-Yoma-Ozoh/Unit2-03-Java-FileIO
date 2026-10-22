import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * This program calculates the board foot
 *from the given width and height*.
 * @author  Yoma Ozoh
 * @version 1.0
 * @since   2026-10-06
 */
public final class FileIO {
    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private FileIO() {
    }
    /**
     * Reads integers from an input file, calculates their sum,
     * and writes the results to an output file.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(final String[] args) {
        File inputFile = new File("Unit2-03-input.txt");
        if (!inputFile.exists()) {
            System.out.println("Input file not found.");
            return;
        }

        try (FileWriter writer = new FileWriter("output.txt");
             Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                int sum = 0;
                boolean flag = false;

                if (line.isEmpty()) {
                    writer.write("No numbers\n");
                } else {
                    String[] elements = line.split(" ");

                    for (String element : elements) {
                        if (element.isEmpty()) {
                            continue;
                        }
                        try {
                            int num = Integer.parseInt(element);
                            sum += num;
                        } catch (NumberFormatException e) {
                            writer.write("Error: Invalid number format\n");
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        writer.write(sum + "\n");
                    }
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error. invalid Input");
        }
    }
}
