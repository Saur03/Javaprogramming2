import java.util.Date;

public class Motorcycle extends Vehicle {

    private boolean saddleBagOn = true;
    private  boolean kickStandOut = true;
    public Motorcycle(String make, String model, int year, String color, int maxGears) {
        super(make, model, year, color, maxGears);
    }
    @Override
    public void gearUp() {
        if(getGear() < getMaxGears()){
            setGear(getGear() + 1);
            System.out.println("You use your hand to gear up,\n" +
                    " The current gear is " + getGear());
        }
        else{
            System.out.println("You are at the highest gear");
        }
    }

    @Override
    public void gearDown() {
        if(getGear() >= 1){
            setGear(getGear() -1 );
            System.out.println("You use the handle and grip the clutch," +
                    "\n You then use the pedal and shift gear \n" +
                    "Your current gear is " + getGear() + "\n" +
                    "You then release the clutch");
        }
        else{
            System.out.println("You are in neutral");
        }
    }

    @Override
    public void speedUp() {
        if(getGear() > 0) {
            int max = switch (getGear()) {
                case 0 -> 0;
                case 1 -> 10;
                case 2 -> 25;
                case 3 -> 40;
                case 4 -> 65;
                case 5 -> 75;
                default -> 250;
            };
            if (getSpeed() < max) {
                setSpeed(Math.min((getSpeed() + 5), max));
                System.out.println("You twist the handle and speed up,\n" +
                        "Your current speed is " + getSpeed());
            } else {
                System.out.println("You are at the max . You will need to shift into a higher gear");
            }
        }
        else{
            System.out.println("You are still in neutral");
        }
    }

    @Override
    public void slowDown() {
        if(getGear()!= 0) {
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
        else{
            System.out.println("You are still in neutral");
        }
    }

    public boolean isSaddleBagOn() {
        return saddleBagOn;
    }

    public void setSaddleBagOn(boolean saddleBagOn) {
        this.saddleBagOn = saddleBagOn;
    }

    public boolean isKickStandOut() {
        return kickStandOut;
    }

    public void setKickStandOut(boolean kickStandOut) {
        this.kickStandOut = kickStandOut;
    }
}
