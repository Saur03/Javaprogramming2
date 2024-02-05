import java.util.Date;

public abstract class Vehicle {
    private String make;
    private String model;
    private int year;
    private String color;
    private double speed;
    private int maxGears;
    private int gear;
    public Vehicle(String make, String model, int year, String color, int maxGears) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.maxGears = maxGears;
    }

    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if(gear >= 1){
            this.speed = speed;
        }
        else {
            System.out.println("You are still in neutral");
        }
    }
    public int getMaxGears() {
        return maxGears;
    }
    public void setMaxGears(int maxGears) {
        this.maxGears = maxGears;
    }
    public int getGear() {
        return gear;
    }
    public void setGear(int gear) {
        this.gear = gear;
    }
    public abstract void gearUp();
    public abstract void gearDown();
    public abstract void speedUp();
    public abstract void slowDown();

    @Override
    public String toString() {
        return "The " + year + " " + make + " " + model + " is travelling at " + getSpeed() + "kmph";
    }
}
