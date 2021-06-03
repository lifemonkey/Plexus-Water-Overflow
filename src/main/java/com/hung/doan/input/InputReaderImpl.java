package com.hung.doan.input;

import com.hung.doan.handler.InputType;

import java.util.Scanner;

public class InputReaderImpl implements InputReader {

    // create new Scanner
    private Scanner scanner = new Scanner(System.in);
    private int counter = 0;

    public InputReaderImpl() {
        if (this.scanner == null) {
            this.scanner = new Scanner(System.in);
        }
    }

    public void closeInput() {
        scanner.close();
    }

    @Override
    public String readInput(String message, InputType inputType) {

        // print message to console
        System.out.print(message);

        // read value from scanner
        String value = scanner.nextLine();

        // verify input data, if not valid try again
        if (!verifyInput(value, inputType) && counter < 10) {
            readInput("Invalid value, please try again: ", inputType);
            // reset counter
            counter = 0;
        }

        return value;
    }

    public boolean verifyInput(String value, InputType inputType) {
        // to prevent infinitive loop
        counter++;

        // check if it is valid value
        if (value == null) {
            return false;
        }

        switch (inputType) {
            case INT:
                return isIntValue(value);
            case DOUBLE:
                return isDoubleValue(value);
            default:
                return true;
        }

    }

    private boolean isIntValue(String value) {

        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isDoubleValue(String value) {

        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

}
