
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
      /*  System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
        */

        Scanner scanner = new Scanner(System.in);
        //int amountWater = 200, amountMilk = 50, amountCoffee = 15;
        int suppOfWater = 400, suppOfMilk = 540, suppOfCoffee = 120, cash = 550;
        int[][] coffee = {{250 , 0 , 16, 4} , {350, 75, 20, 7} , {200 , 100, 12, 6}};
        String[] coffeeNames = {"espresso" , "latte" , "cappuccino"};
        int amountCups = 9;
        int realAmountOfCups = 0;
        String action;
        int check = 0;
        String tmp;

        while(true){
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.nextLine();
            System.out.println();

            switch (action){
                case "remaining":
                    System.out.printf("The coffee machine has:\n" +
                            "%d ml of water\n" +
                            "%d ml of milk\n" +
                            "%d g of coffee beans\n" +
                            "%d disposable cups\n" +
                            "$%d of money\n", suppOfWater ,suppOfMilk, suppOfCoffee, amountCups, cash);
                    break;

                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    suppOfWater += scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    suppOfMilk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    suppOfCoffee += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    amountCups += scanner.nextInt();
                    scanner.nextLine();
                    break;

                case "buy":
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

                    break;

                case "take":
                    System.out.printf("I gave you %d$", cash);
                    cash = 0;
                    break;


                case "exit":
                    check = 1;
                    break;
            }

            if(check == 1){
                break;
            }

            System.out.println();
        }

        /*System.out.println("The coffee machine has:\n" +
                "400 ml of water\n" +
                "540 ml of milk\n" +
                "120 g of coffee beans\n" +
                "9 disposable cups\n" +
                "$550 of money");
        System.out.println();
        System.out.println("Write action (buy, fill, take):");
        String action = scanner.nextLine();
        switch (action){
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                int typeOfCoffee = scanner.nextInt();
                switch (typeOfCoffee){
                    case 1:
                        suppOfWater -= 250; suppOfCoffee -=16; cash += 4; amountCups--;
                        break;
                    case 2:
                        suppOfWater -= 350; suppOfMilk -= 75; suppOfCoffee -=20; cash += 7; amountCups--;
                        break;
                    case 3:
                        suppOfWater -= 200; suppOfMilk -= 100; suppOfCoffee -=12; cash += 6; amountCups--;
                        break;
                }
                break;

            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                suppOfWater += scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                suppOfMilk += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                suppOfCoffee += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee you want to add:");
                amountCups += scanner.nextInt();
                break;

            case "take":
                System.out.println("I gave you 550$");
                cash = 0;
                break;
        }

        System.out.println();

        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money", suppOfWater ,suppOfMilk, suppOfCoffee, amountCups, cash);
        */
        /*  System.out.println("Write how many ml of water the coffee machine has:");
        suppOfWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        suppOfMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        suppOfCoffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        amountCups = scanner.nextInt();
        while(true){
            suppOfWater -= amountWater;
            suppOfMilk -= amountMilk;
            suppOfCoffee -= amountCoffee;
            if(suppOfWater >= 0 && suppOfMilk >= 0 && suppOfCoffee >=0){
                realAmountOfCups++;
            }else{
                break;
            }
        }


        String output = amountCups == realAmountOfCups? "Yes, I can make that amount of coffee ":
                amountCups > realAmountOfCups? String.format("No, I can make only %d cup(s) of coffee", realAmountOfCups):
                        String.format("Yes, I can make that amount of coffee (and even %d more than that)", realAmountOfCups-amountCups);
        System.out.println(output);
         */

        /*  System.out.println("Write how many cups of coffee you will need: ");
        amountCups = scanner.nextInt();
        String output = String.format("For %d cups of coffee you will need: \n " +
                "%d ml of water\n" + "%d ml of milk\n"
                + "%d g of coffee beans", amountCups, amountWater*amountCups,
                amountMilk*amountCups, amountCoffee*amountCups);
        System.out.println(output);
        */
    }
}
