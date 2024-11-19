package it.unibo.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String HOME = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String DEFAULT_PATH = HOME + SEPARATOR + "output.txt";

    private File currentFile = new File(DEFAULT_PATH);

    /**
     * Returns a copy of the current file
     * @return a copy of the current file 
     */
    public File getCurrentFile() {
        return new File(currentFile.getPath());
    }

    /**
     * Sets the current file
     * @param file to set as current
     */
    public void setCurrentFile(final File file) {
        if (file != null) {
            this.currentFile = new File(file.getPath());
        }
    }

    /**
     * returns the current file path
     * @return a string representing the current file path
     */
    public String getCurrentFilePath() {
        return currentFile.getPath();
    }

    /**
     * Writes on the current file
     * @param text to write
     * @throws IOException
     */
    public void writeOnCurrentFile(final String text) throws IOException {
        try (PrintStream ps = new PrintStream(currentFile)) {
            ps.println(text);
        } catch (final FileNotFoundException ex) {
            throw new IOException(currentFile.getPath() + " has not been found");
        }
    }

}
