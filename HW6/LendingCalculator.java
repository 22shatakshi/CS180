import java.util.Scanner;

public class LendingCalculator {
    
    private static String welcomeMessage = "Welcome to the Lending Calculator!"; 
    private static String menu = "Menu";
    private static String initialMenu = "0. Quit\n1. Add a loan";
    private static String ongoingMenu = "0. Quit\n1. Modify Loan\n2. Calculate Total Interest";
    private static String exitMessage = "Thank you!";
    private static String durationMessage = "Enter the duration:";
    private static String rateMessage = "Enter the rate:";
    private static String amountMessage = "Enter the amount:"; 
    private static String amortizationPrompt = "Would you like to print the amortization schedule?"; 
    private static String amortizationMenu = "1. Yes\n2. No"; 
    private static String totalInterestMessage = "Total Interest: ";
    private static String errorMessage = "Error! Invalid input."; 

    public static void mainMenu(Scanner scan){
        String option;
        System.out.println(menu);
        System.out.println(initialMenu);
        option = scan.next();
        if (option.equals("0"))
            System.out.println(exitMessage);
        else if (option.equals("1"))
            innerMenu(scan);
        else
            System.out.println(errorMessage);
    }

    public static void innerMenu(Scanner scan){
        String option;
        int duration;
        double rate;
        double amount;
        System.out.println(durationMessage);
        duration = scan.nextInt();
        scan.nextLine();
        System.out.println(rateMessage);
        rate = scan.nextDouble();
        scan.nextLine();
        System.out.println(amountMessage);
        amount = scan.nextDouble();
        scan.nextLine();
        Loan loan = new Loan(duration, rate, amount);
        System.out.println(loan.toString());
        do {
            System.out.println(ongoingMenu);
            option = scan.nextLine();
            if (option.equals("0"))
                System.out.println(exitMessage);
            else if (option.equals("1")){
                System.out.println(durationMessage);
                duration = scan.nextInt();
                scan.nextLine();
                System.out.println(rateMessage);
                rate = scan.nextDouble();
                scan.nextLine();
                System.out.println(amountMessage);
                amount = scan.nextDouble();
                scan.nextLine();
                loan.setDuration(duration);
                loan.setRate(rate);
                loan.setAmount(amount);
                loan.calculateMonthlyPayment();
                System.out.println(loan.toString());
            } else if (option.equals("2"))
                amortization(scan, loan);
            else
                System.out.println(errorMessage);
        }while(!option.equals("0"));
    }

    public static void amortization(Scanner scan, Loan loan){
        String option;
        System.out.println(amortizationPrompt);
        System.out.println(amortizationMenu);
        option = scan.nextLine();
        if (option.equals("1")){
            loan.totalInterest(true);
            System.out.println(totalInterestMessage + String.format("%.2f",loan.totalInterest(false)));
        }
        else if (option.equals("2"))
            System.out.println(totalInterestMessage + String.format("%.2f",loan.totalInterest(false)));
        else
            System.out.println(errorMessage);
     }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(welcomeMessage);
        mainMenu(scan);      
    }
    
}
