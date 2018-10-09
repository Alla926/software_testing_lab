package main.by.bstu.testing.service.impl;

import main.by.bstu.testing.service.TriangleService;
import main.by.bstu.testing.service.validation.TriangleValidator;

public class TriangleServiceImpl implements TriangleService {
    @Override
    public boolean isTriangle(int sideA, int sideB, int sideC) {
        if (!TriangleValidator.checkForPositiveValues(sideA, sideB, sideC)) {
            throw new UnsupportedOperationException("Triangle's sides must be positive.");

        } else if (!TriangleValidator.checkForMaxValue(sideA, sideB, sideC)) {
            throw new UnsupportedOperationException("Triangle's sides must be less than max int value.");

        }
        return sideA < (sideB + sideC) && sideB < (sideA + sideC) && sideC < (sideA + sideB);

    }
}

