package com.hung.doan.model;

import lombok.*;

import java.util.LinkedList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Triplet {

    private int row;
    private int col;
    private double remainWater;

    public void deductRemainWater(double remainWater) {
        this.remainWater -= remainWater;
    }

    public boolean isValidTriplet() {
        return row > 0 && col > 0 && row >= col;
    }

    public boolean noWater() {
        return remainWater <= 0;
    }

    public Triplet getDownLeft() {
        return new Triplet(row + 1, col, remainWater / 2.0);
    }

    public Triplet getDownRight() {
        return new Triplet(row + 1, col + 1, remainWater / 2.0);
    }
}
