package com.hung.doan.handler;

import com.hung.doan.model.Glass;
import com.hung.doan.model.Triplet;

public interface WaterLevel {

    double findWaterLevel(Triplet triplet, Glass glass);
}
