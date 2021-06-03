package com.hung.doan.input;

import com.hung.doan.handler.InputType;

public interface InputReader {

    void closeInput();

    String readInput(String message, InputType inputType);

}
