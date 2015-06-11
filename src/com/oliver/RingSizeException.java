package com.oliver;

public class RingSizeException extends Exception {

    private int ring, old;

    RingSizeException(int ring, int old) {

        this.ring = ring;
        this.old = old;
    }

    public String toString() {

        return "Trying to place a ring of size " + ring + " on top of a ring of size " + old +
                " will crush the bottom ring!";
    }
}
