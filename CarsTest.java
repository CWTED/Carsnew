import java.awt.*;
import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    private final Cars c1 = new Volvo240();
    private final Saab95 c2 = new Saab95();

    @org.junit.jupiter.api.Test
    void startEngine() {
        c1.startEngine();
        c1.startEngine();
        assertTrue(c1.getCurrentSpeed() == 0.1);
    }

    @org.junit.jupiter.api.Test
    void stopEngine() {
        c1.startEngine();
        c1.gas(1);
        c1.stopEngine();
        assertTrue(c1.getCurrentSpeed() == 0);
    }

    @org.junit.jupiter.api.Test
    void move() {
        c1.setCurrentSpeed(5);
        assertEquals(5, c1.getCurrentSpeed()); // Takes in expected value and actual value and asserts if they are equal.
        c1.move();
        assertEquals(0, c1.getDeg());
        assertEquals(5, c1.getPosX());
        assertEquals(0, c1.getPosY());

    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        c1.setCurrentSpeed(1);
        c1.turnLeft();

    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        c1.turnRight();

    }

    @org.junit.jupiter.api.Test
    void gas() {
        c1.startEngine();
        assertEquals(0.1, c1.getCurrentSpeed());
        c1.gas(1);
        assertEquals(1.35, c1.getCurrentSpeed());
        while (c1.getCurrentSpeed() < c1.getEnginePower()) {
            c1.gas(1);
        }
        assertEquals(c1.getCurrentSpeed(), c1.getEnginePower());

        try {
            c1.gas(5);

        } catch (Exception InvalidParameterException) {
            assert(true);
        }
    }



    @org.junit.jupiter.api.Test
    void brake() {
        c1.startEngine();
        assertTrue(c1.getCurrentSpeed() == 0.1);
        c1.brake(2);
        assertTrue(c1.getCurrentSpeed() == 0.1);
        c1.brake(1);
        assertTrue(c1.getCurrentSpeed() == 0);
    }

    @org.junit.jupiter.api.Test
    void setTurboOn() {
        c2.startEngine();
        assertTrue(c2.getCurrentSpeed() == 0.1);
        c2.setTurboOn();
        c2.gas(1);
        assertTrue(c2.getCurrentSpeed() == 1.725);
    }

    @org.junit.jupiter.api.Test
    void setTurboOff() {
        c2.startEngine();
        assertTrue(c2.getCurrentSpeed() == 0.1);
        c2.setTurboOn();
        c2.setTurboOff();
        assertTrue(c2.speedFactor() == 1.25);

    }
}