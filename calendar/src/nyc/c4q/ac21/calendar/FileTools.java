package nyc.c4q.ac21.calendar;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileTools {

    /**
     * Reads lines of text from a file on disk.
     * @param filename
     *   The filename from which to read.
     * @return
     *   A list of lines of text from the file, or null if a problem occurred.
     */
    public static ArrayList<String> readLinesFromFile(String filename) {
        ArrayList<String> lines = new ArrayList<String>();
        try {
            return (ArrayList<String>) Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
        } catch (IOException exception) {
            exception.printStackTrace(System.err);
            return null;
        }
    }

}
