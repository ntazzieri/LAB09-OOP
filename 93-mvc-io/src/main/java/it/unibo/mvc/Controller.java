package it.unibo.mvc;

import java.util.List;

/**
 *  It's the application controller. It's responsible of I/O access.
 */
public interface Controller {

    /**
     * It sets the next string to print.
     * 
     * @param toPrint next string to print
     * @throws NullPointerException if it's passed a null string
     */
    void setStringToPrint(String toPrint);

    /**
     * It returns the next string to print.
     * 
     * @return next string to print
     */
    String getStringToPrint();

    /**
     * It returns the history of printed strings.
     * 
     * @return history of printed strings
     */
    List<String> getPrintHistory();

    /**
     * Prints the current string. 
     * 
     * @throws IllegalStateExcepion if the current string is unset
     */
    void print();


}
