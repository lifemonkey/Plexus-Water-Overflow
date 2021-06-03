package com.hung.doan.handler;

import com.hung.doan.model.Glass;
import com.hung.doan.model.Triplet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WaterLevelImplUT {

    WaterLevel waterLevel;
    Triplet triplet;
    Glass glass;

    @BeforeEach
    public void init() {
        waterLevel = new WaterLevelImpl();
    }

    @AfterEach
    public void cleanup() {
        waterLevel = null;
    }

    @Test
    public void findWaterLevel_Test_InvalidInput() {

        glass = new Glass(1);

        // invalid row value, row
        triplet = new Triplet(1, 2, 2);
        Assertions.assertEquals(-1.0, waterLevel.findWaterLevel(triplet, glass), 0.0);
    }

    @Test
    public void findWaterLevel_Test() {

        glass = new Glass(1);

        // no water at all
        triplet = new Triplet(2, 1, 0);
        Assertions.assertEquals(0.0, waterLevel.findWaterLevel(triplet, glass), 0.0);
        // water fill up, for the case we go too deep
        triplet = new Triplet(2, 1, 10);
        Assertions.assertEquals(1.0, waterLevel.findWaterLevel(triplet, glass), 0.0);
        // test simple case
        triplet = new Triplet(2, 2, 2);
        Assertions.assertEquals(0.5, waterLevel.findWaterLevel(triplet, glass), 0.0);
    }

    @Test
    public void findWaterLevel_Test_BiggerCapacity() {

        glass = new Glass(2);

        // no water at all
        triplet = new Triplet(2, 1, 0);
        Assertions.assertEquals(0.0, waterLevel.findWaterLevel(triplet, glass), 0.0);
        // water fill up, for the case we go too deep
        triplet = new Triplet(2, 1, 10);
        Assertions.assertEquals(2.0, waterLevel.findWaterLevel(triplet, glass), 0.0);
        // test simple case
        triplet = new Triplet(2, 2, 2);
        Assertions.assertEquals(0.0, waterLevel.findWaterLevel(triplet, glass), 0.0);
    }
}
