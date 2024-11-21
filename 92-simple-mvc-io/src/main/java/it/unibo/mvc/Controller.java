package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String HOME = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String DEFAULT_PATH = HOME + SEPARATOR + "output.txt";

    private File currentFile = new File(DEFAULT_PATH);

    /**
     * Returns a copy of the current file.
     * @return a copy of the current file.
     */
    public File getCurrentFile() {
        return currentFile;
    }

    /**
     * Sets the current file, if it doesn't exist, no change will be made.
     * @param file to set as current.
     */
    public void setCurrentFile(final File file) {
        final File toSet = Objects.requireNonNull(file);
        if (toSet.exists()) {
            this.currentFile = toSet;
        }
    }

    /**
     * returns the current file path.
     * @return a string representing the current file path.
     */
    public String getCurrentFilePath() {
        return currentFile.getPath();
    }

    /**
     * Writes on the current file.
     * @param text to write.
     * @throws IOException
     */
    public void writeOnCurrentFile(final String text) throws IOException {
        try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            ps.println(text);
        } 
    }

}
