package dev.lpa;

public class FinalVariableExample {

    final int x = 10;
    final int y;

    FinalVariableExample() {
        y = 20;
    }

    void printValues() {
        System.out.println("x = " + x + ", y = " + y);
    }
}
