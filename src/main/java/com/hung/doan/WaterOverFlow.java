package com.hung.doan;

import com.hung.doan.handler.InputType;
import com.hung.doan.handler.WaterLevel;
import com.hung.doan.handler.WaterLevelImpl;
import com.hung.doan.input.InputReader;
import com.hung.doan.input.InputReaderImpl;
import com.hung.doan.model.Glass;
import com.hung.doan.model.Triplet;

import java.io.IOException;

class WaterOverFlow {

    public static void main(String[] args) throws IOException {

        while (true) {
            InputReader inputReader = new InputReaderImpl();

            String row = inputReader.readInput("Please entered i'th row: ", InputType.INT);
            String col = inputReader.readInput("Please entered j'th glass: ", InputType.INT);
            String totalWater = inputReader.readInput("Please entered total water amount: ", InputType.INT);

            Triplet triplet = new Triplet().builder()
                    .row(Integer.parseInt(row))
                    .col(Integer.parseInt(col))
                    .remainWater(Integer.parseInt(totalWater))
                    .build();

            String capacity = inputReader.readInput("Enter glass capacity: ", InputType.INT);
            Glass glass = new Glass().builder()
                    .capacity(Integer.parseInt(capacity))
                    .build();

            WaterLevel waterLevel = new WaterLevelImpl();
            StringBuilder result = new StringBuilder();
            result.append("Water level of ")
                    .append(col)
                    .append("'th glass at row ")
                    .append(row)
                    .append(" is: ")
                    .append(waterLevel.findWaterLevel(triplet, glass));

            System.out.println(result);


            String stay = inputReader.readInput("Do you want to continue(y/n): ", InputType.STRING);
            if (stay.equalsIgnoreCase("n") || stay.equalsIgnoreCase("no")) {
                inputReader.closeInput();
                break;
            }
        }
    }

}
