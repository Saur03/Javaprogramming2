import java.util.Date;

public class Car extends Vehicle{
    private boolean seatBeltEngaged = true;
    private boolean airBagActive = true;
    public Car(String make, String model, int year, String color, int maxGears) {
        super(make, model, year, color, maxGears);
    }

    public void speedUp(){
        if(getGear() > 0) {
            int max = switch (getGear()) {
                case 0 -> 0;
                case 1 -> 15;
                case 2 -> 30;
                case 3 -> 45;
                case 4 -> 70;
                case 5 -> 80;
                default -> 250;
            };
            if (getSpeed() < max) {
                setSpeed(Math.min((getSpeed() + 5), max));
                System.out.println("You press down on the gas pedal,\n" +
                        "Your current speed is " + getSpeed());
            } else {
                System.out.println("You are at the max . You will need to shift into a higher gear");
            }
        }
        else {
            System.out.println("You are still in neutral");
        }
    }
    public void slowDown(){
        if(getGear() != 0) {
            int min = switch (getGear()) {
                case 1 -> 1;
                case 2 -> 11;
                case 3 -> 26;
                case 4 -> 41;
                case 5 -> 66;
                default -> 250;
            };
            if (getSpeed() != 0) {
                setSpeed(Math.max((getSpeed() - 10), min));
                System.out.println("You release the handle and slow down,\n" +
                        "Your current speed is " + getSpeed());
            } else {
                System.out.println("This is as slow as you can go. Shift down a gear");
            }
        }
    }

    public void gearUp(){
        if(getGear() < getMaxGears()){
            setGear(getGear() + 1);
            System.out.println("You use your clutch to gear up,\n" +
                    " The current gear is " + getGear());
        }
        else{
            System.out.println("You are at the highest gear");
        }
    }
    public void gearDown(){
        if(getGear() >= 1){
            setGear(getGear() -1 );
            System.out.println("You use your clutch to gear down,\n" +
                    "Your current gear is " + getGear());
        }
        else{
            System.out.println("You are in neutral");
        }
    }

    public boolean isSeatBeltEngaged() {
        return seatBeltEngaged;
    }

    public void setSeatBeltEngaged(boolean seatBeltEngaged) {
        this.seatBeltEngaged = seatBeltEngaged;
    }

    public boolean isAirBagActive() {
        return airBagActive;
    }

    public void setAirBagActive(boolean airBagActive) {
        this.airBagActive = airBagActive;
    }
}
