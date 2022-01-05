import java.util.*;

class CoffeeMachine {


    Scanner scanner;

    int suppOfWater = 400, suppOfMilk = 540, suppOfCoffee = 120, cash = 550, amountCups = 9;
    int[][] coffee = {{250 , 0 , 16, 4} , {350, 75, 20, 7} , {200 , 100, 12, 6}};
    String[] coffeeNames = {"espresso" , "latte" , "cappuccino"};

    state status;

    String action;

    public CoffeeMachine() {
        status = state.MAIN_MENU;
        scanner = new Scanner(System.in);
    }

    enum state {
        MAIN_MENU, BUY, FILL, TAKE, REMAINING;
    }


    public int input(){
        switch (status) {
            case MAIN_MENU:
                action = writeAction();
                switch (action) {
                    case "buy":
                        status = state.BUY;
                        break;

                    case "fill":
                        status = state.FILL;
                        break;

                    case "take":
                        status = state.TAKE;
                        break;

                    case "remaining":
                        status = state.REMAINING;
                        break;

                    case "exit":
                        return 0;
                }
                break;

            case BUY:
                buy();
                break;

            case FILL:
                fill();
                break;

            case REMAINING:
                remaining();
                break;

            case TAKE:
                take();
                break;

            default:
                status = state.MAIN_MENU;
                return 1;
        }

        System.out.println();
        return 1;
    }


    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String number = scanner.nextLine();
        switch (number){
            case "back":
                break;

            case "1":
                if(suppOfWater - coffee[0][0] < 0){
                    System.out.println("Sorry, not enough water!");
                    //scanner.nextLine();
                    break;
                }
                if(suppOfCoffee - coffee[0][2] < 0){
                    System.out.println("Sorry, not enough coffee beans!");
                    //scanner.nextLine();
                    break;
                }

                if(amountCups - 1 < 0){
                    System.out.println("Sorry, not enough cups!");
                    //scanner.nextLine();
                    break;
                }

                //scanner.nextLine();

                suppOfWater -= coffee[0][0];
                suppOfMilk -= coffee[0][1];
                suppOfCoffee -= coffee[0][2];
                cash += coffee[0][3];
                amountCups--;

                System.out.println("I have enough resources, making you a coffee!");
                break;

            case "2":
                if(suppOfWater - coffee[1][0] < 0){
                    System.out.println("Sorry, not enough water!");
                    //scanner.nextLine();
                    break;
                }

                if(suppOfMilk - coffee[1][1] < 0){
                    System.out.println("Sorry, not enough milk!");
                    //scanner.nextLine();
                    break;
                }

                if(suppOfMilk - coffee[1][2] < 0){
                    System.out.println("Sorry, not enough coffee beans!");
                    //scanner.nextLine();
                    break;
                }

                if(amountCups - 1 < 0){
                    System.out.println("Sorry, not enough cups!");
                    //scanner.nextLine();
                    break;
                }


                //scanner.nextLine();

                suppOfWater -= coffee[1][0];
                suppOfMilk -= coffee[1][1];
                suppOfCoffee -= coffee[1][2];
                cash += coffee[1][3];
                amountCups--;

                System.out.println("I have enough resources, making you a coffee!");
                break;


            case "3":
                if(suppOfWater - coffee[2][0] < 0){
                    System.out.println("Sorry, not enough water!");
                    //scanner.nextLine();
                    break;
                }

                if(suppOfMilk - coffee[2][1] < 0){
                    System.out.println("Sorry, not enough milk!");
                    //scanner.nextLine();
                    break;
                }

                if(suppOfMilk - coffee[2][2] < 0){
                    System.out.println("Sorry, not enough coffee beans!");
                    //scanner.nextLine();
                    break;
                }

                if(amountCups - 1 < 0){
                    System.out.println("Sorry, not enough cups!");
                    //scanner.nextLine();
                    break;

                }

                //scanner.nextLine();

                suppOfWater -= coffee[2][0];
                suppOfMilk -= coffee[2][1];
                suppOfCoffee -= coffee[2][2];
                cash += coffee[2][3];
                amountCups--;

                System.out.println("I have enough resources, making you a coffee!");
                break;

        }

        status = state.MAIN_MENU;
    }

    public void fill() {
        System.out.println("Write how many ml of water you want to add:");
        suppOfWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        suppOfMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        suppOfCoffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        amountCups += scanner.nextInt();
        scanner.nextLine();
        status = state.MAIN_MENU;
    }

    public void take() {
        System.out.printf("I gave you %d$", cash);
        cash = 0;
        status = state.MAIN_MENU;
    }

    public void remaining() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n", suppOfWater ,suppOfMilk, suppOfCoffee, amountCups, cash);
        status = state.MAIN_MENU;
    }

    public String writeAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return scanner.nextLine();
    }

}

public class Main {

    public static void main(String[] args){
        CoffeeMachine machino = new CoffeeMachine();
        while (machino.input() != 0) {

        }
    }

}
