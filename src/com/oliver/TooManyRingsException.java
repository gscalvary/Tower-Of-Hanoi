package com.oliver;

public class TooManyRingsException extends Exception {

    int maxSize;

    TooManyRingsException(int maxSize) {

        this.maxSize = maxSize;
    }

    public String toString() {

        return "The most strings that may be stored on this stake is " + maxSize + "!";
    }
}
