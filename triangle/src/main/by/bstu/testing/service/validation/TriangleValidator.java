package main.by.bstu.testing.service.validation;

public class TriangleValidator {
    public static boolean checkForPositiveValues(int sideA, int sideB, int sideC){
        return sideA > 0 && sideB > 0 && sideC > 0;
    }

    public static boolean checkForMaxValue(int sideA, int sideB, int sideC){
        return sideA < Integer.MAX_VALUE  && sideB < Integer.MAX_VALUE && sideC < Integer.MAX_VALUE;
    }

}
