import java.util.Scanner;

/**
 * A program that determines the price of a custom-made toy.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Homework 04 -- Challenge
 *
 * @author Shatakshi Singh
 * @version September 16, 2021
 */

public class ToySeller {

    private static String welcomeMessage = "Welcome to the Custom Toy Builder!\nOur store can custom-design " +
            "3 different types of toys.";
    private static String startMessage = "Which would you like to create? (Enter a number)\n" +
            "1. Superman figurine\n" +
            "2. Robotic cyclops\n" +
            "3. Cat-shaped lamp\n" +
            "4. EXIT";
    private static String endProgram = "Thanks for using the Custom Toy Builder!";

    private static String sizeQuestion = "What size toy would you like? (Enter S, M, or L)";
    private static String supermanQ1 = "Do you want Superman to talk? (Enter Y or N)";
    private static String supermanQ2 = "Do you want to add a cape? (Enter Y or N)";
    private static String roboticCyclopsQ1 = "Do you want the Robotic Cyclops to move? (Enter Y or N)";
    private static String roboticCyclopsQ2 = "What color eye do you want? (Enter 1, 2, or 3)\n" +
            "1. Red\n" +
            "2. Yellow\n" +
            "3. Blue";
    private static String catLampQ1 = "What color Cat-shaped Lamp do you want? (Enter 1, 2, 3, or 4)\n" +
            "1. Gold\n" +
            "2. Pink\n" +
            "3. Blue\n" +
            "4. No Color";
    private static String catLampQ2 = "Do you want the Cat-shaped Lamp to glow? (Enter Y or N)";

    private static String supermanCost = "Your Superman figurine costs";
    private static String roboticCyclopsCost = "Your Robotic Cyclops costs";
    private static String catLampCost = "Your Cat-shaped Lamp costs";


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalPrice = 0;

        System.out.println(welcomeMessage);
        System.out.println(startMessage);

        int toyChoice = scan.nextInt();
        String toySize = "";
        String answer1 = "";
        String answer2 = "";

        switch(toyChoice) {
            case 1:
            case 2:
            case 3: {
                System.out.println(sizeQuestion);
                toySize = scan.nextLine();
                break;
            }
            case 4: System.out.println(endProgram);
                break;
            default:
                System.out.println("Invalid input.");
        }

        if (toyChoice > 0 && toyChoice < 4) {
            if (toySize.equals('S')) {
                totalPrice += 5;
            } else if (toySize.equals('M')) {
                totalPrice += 10;                        
            } else if (toySize.equals('L')) {
                totalPrice += 15;
            }
            
            switch (toyChoice) {
                case 1:{
                    System.out.println(supermanQ1);
                    answer1 = scan.nextLine();
                    System.out.println(supermanQ2);
                    answer2 = scan.nextLine();
                    break;
                }
                case 2:{
                    System.out.println(roboticCyclopsQ1);
                    answer1 = scan.nextLine();
                    System.out.println(roboticCyclopsQ2);
                    answer2 = scan.nextLine();
                    break;
                }
                case 3:{
                    System.out.println(catLampQ1);
                    answer1 = scan.nextLine();
                    System.out.println(catLampQ2);
                    answer2 = scan.nextLine();
                    break;
                }
                default:
                    break;
            }
            if (toyChoice == 1) {
                if (answer1.equals("Y")) {
                    totalPrice += 8;
                } else if (answer1.equals("N")) {
                    totalPrice += 4;
                }
                
                if (answer2.equals("Y")) {
                    totalPrice += 5;
                } else if (answer2.equals("N")) {
                    totalPrice += 0;
                }
                System.out.printf("%s $%d!\n", supermanCost, totalPrice);   
            } else if (toyChoice == 2) {
                if (answer1.equals("Y")) {
                    totalPrice += 5;
                } else if (answer1.equals("N")) {
                    totalPrice += 3;
                }

                if (answer2.equals("1")) {
                    totalPrice += 5;
                } else if (answer2.equals("2")) {
                    totalPrice += 6;
                } else if (answer2.equals("3")) {
                    totalPrice += 7;
                }
                System.out.printf("%s $%d!\n", roboticCyclopsCost, totalPrice);
            } else if (toyChoice == 3) {
                if (answer1.equals("1")) {
                    totalPrice += 10;
                } else if (answer1.equals("2")) {
                    totalPrice += 7;
                } else if (answer1.equals("3")) {
                    totalPrice += 7;
                } else if (answer1.equals("4")) {
                    totalPrice += 5;
                }

                if (answer2.equals("Y")) {
                    totalPrice += 10;
                } else if (answer2.equals("N")) {
                    totalPrice += 0;
                }
                System.out.printf("%s $%d!\n", catLampCost, totalPrice);
            }

            System.out.println(endProgram);
        }

    }
}

