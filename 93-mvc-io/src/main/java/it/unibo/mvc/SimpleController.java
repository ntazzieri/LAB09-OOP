package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * It implements the interface Controller.
 */
public final class SimpleController implements Controller {

    private final List<String> history = new ArrayList<>();
    private String toPrint;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStringToPrint(final String toPrint) {
        this.toPrint = Objects.requireNonNull(toPrint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStringToPrint() {
        return toPrint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getPrintHistory() {
        return new ArrayList<>(history);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void print() {
        if (Objects.isNull(getStringToPrint())) {
            throw new IllegalStateException("The current string is null");
        }
        System.out.println(getStringToPrint()); // NOPMD, it's required for the exercise
        history.addLast(toPrint);
    }

}
