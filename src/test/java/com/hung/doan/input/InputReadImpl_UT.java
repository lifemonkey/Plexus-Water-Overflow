package com.hung.doan.input;

import com.hung.doan.handler.InputType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputReadImpl_UT {

    InputReaderImpl inputReader;

    @BeforeEach
    public void init() {
        inputReader = new InputReaderImpl();
    }

    @AfterEach
    public void cleanup() {
        inputReader.closeInput();
    }

    @Test
    public void verifyInput_Test() {

        Assertions.assertFalse(inputReader.verifyInput("abc", InputType.INT));
        Assertions.assertTrue(inputReader.verifyInput("1", InputType.INT));
        Assertions.assertFalse(inputReader.verifyInput("1.0", InputType.INT));

        Assertions.assertTrue(inputReader.verifyInput("1.0", InputType.DOUBLE));
        Assertions.assertTrue(inputReader.verifyInput("1", InputType.DOUBLE));
        Assertions.assertFalse(inputReader.verifyInput("abc", InputType.DOUBLE));

        Assertions.assertTrue(inputReader.verifyInput("abc", InputType.STRING));
        Assertions.assertFalse(inputReader.verifyInput(null, InputType.STRING));

    }

}
