import java.util.Scanner;
public class Simulator {
    public static void main(String[] args) {
        boolean endGame = false;

        Vehicle[] vehicles = new Vehicle[]{
                new Car("Ford", "Mustang",
                        1990, "color",4),
                new Motorcycle("Honda","cbr600rr",
                        2006, "red", 4),
                new Motorcycle("Suzuki","gsxr1100",
                        2008, "blue", 5)};

        System.out.println("Welcome to the motorcycle game:\n" +
                "Please pick a vehicle:\n" +
                "0)" + vehicles[0].getMake() + "\n" +
                "1)" + vehicles[1].getMake() + "\n" +
                "2)" + vehicles[2].getMake());

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();//0,1,2
        int gameChoice = 0;

        do{
            System.out.println("What would you like to do?\n" +
                    "1) speed up\n" +
                    "2) slow down\n" +
                    "3) gear up\n" +
                    "4) gear down\n" +
                    "5) Describe vehicle\n"+
                    "6) quit game");

            gameChoice = input.nextInt();
            switch (gameChoice){
                case 1:
                    vehicles[choice].speedUp();
                    break;
                case 2:
                    vehicles[choice].slowDown();
                    break;
                case 3:
                    vehicles[choice].gearUp();
                    break;
                case 4:
                    vehicles[choice].gearDown();
                    break;
                case 5:
                    System.out.println(vehicles[choice]);
                    break;
                case 6:
                    endGame = true;
                    break;
            }
        }while(!endGame);
    }
}
