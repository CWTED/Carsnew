import java.awt.*;

/**
 * Specific car model, Saab95. Subclass to Cars. Imports java.awt.
 */

public class Saab95 extends Cars {
    /**
     * Boolean for the turbo function of the specific car model. Affects the speedFactor of the car.
     */
    private boolean turboOn;

    /**
     * Constructor for the Saab95
     */
    public Saab95() {
        super(2, 125, Color.red, "Saab95");
        this.turboOn = false;
        this.stopEngine();
    }

    /**
     * Sets the boolean value of turboOn to true. Effectively enables the turbo function of the car.
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Sets the boolean value of turboOn to false. Effectively disables turbo function of the car.
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Sets the speedFactor for this certain car model.
     * @return speedFactor for this certain car model. Result depends on whether turbo is on or off.
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}