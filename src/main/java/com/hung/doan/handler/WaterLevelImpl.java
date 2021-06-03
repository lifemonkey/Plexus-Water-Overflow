package com.hung.doan.handler;

import com.hung.doan.model.Glass;
import com.hung.doan.model.Triplet;

import java.util.LinkedList;
import java.util.Queue;

public class WaterLevelImpl implements WaterLevel {

    @Override
    public double findWaterLevel(Triplet triplet, Glass glass) {

        // validate triplet before do further step
        if (!triplet.isValidTriplet()) return -1.0;

        // no water at all
        if (triplet.noWater()) return 0.0;

        // stores how much amount of water present in every glass
        double glasses[][] = new double[triplet.getRow() + 1][2 * triplet.getRow() - 1];

        // using Queue to store Triplet
        Queue<Triplet> queue = new LinkedList<>();

        // first glass always be there
        queue.add(new Triplet(0, 0, triplet.getRemainWater()));

        // this while loop runs unless the queue is not empty
        while (!queue.isEmpty()) {
            // first we remove the Triplet from the queue
            Triplet curr = queue.remove();

            // go deeper than the given position is not needed
            if (curr.getRow() == triplet.getRow()) break;

            // fill up the glass by it's capacity
            if (glasses[curr.getRow()][curr.getCol()] != glass.getCapacity()) {
                // calculate the remaining capacity of water for curr glass
                double toBeTaken = glass.getCapacity() - glasses[curr.getRow()][curr.getCol()];

                // if the water amount to be taken is greater than remaining amount
                if (toBeTaken > curr.getRemainWater()) {
                    // then put all into current glass
                    glasses[curr.getRow()][curr.getCol()] += curr.getRemainWater();
                    // nothing left
                    curr.setRemainWater(0);
                } else {
                    glasses[curr.getRow()][curr.getCol()] += toBeTaken;
                    // deduct the remaining water amount
                    curr.deductRemainWater(toBeTaken);
                }
            }

            // if remain water is possible, pour it down,  so separate it to two below glasses
            if (curr.getRemainWater() != 0) {
                queue.add(curr.getDownLeft());
                queue.add(curr.getDownRight());
            }
        }

        // return the result for jth glass of ith row
        return glasses[triplet.getRow() - 1][triplet.getCol() - 1];
    }
}
