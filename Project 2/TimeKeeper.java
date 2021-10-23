import java.util.Scanner;

public class TimeKeeper {
    
    private static String welcomePrompt = "Welcome to the TimeKeeper application!";
    private static String invalidInput = "Invalid input. Please try again.";
    private static String enterLabCapacity = "Enter the capacity for Lab ";
    private static String enterLabLocation = "Enter the location for Lab "; 
    private static String labLocationPrompt = "Enter the location of the lab:"; 
    private static String reservationTimePrompt = "Enter the time of the reservation:"; 
    private static String reservationNamePrompt = "Enter the name of the reservation:";
    private static String reservationEnrollmentPrompt = "Enter the expected enrollment:"; 
    private static String reservationNameUpdate = "Enter the updated name of the reservation:";
    private static String reservationEnrollmentUpdate = "Enter the updated enrollment:"; 
    private static String totalCapacity = "Total Capacity: ";
    private static String totalUtilization = "Total Utilization: ";
    private static String availableSeats = "Available seats: "; 
    
    
    private static String initializeMenu = "1. Initialize Application\n" +
                                        "2. Exit";
    private static String ongoingMenu = "1. View Current Lab Schedule\n" +
                                "2. List Labs by Availability\n" +
                                "3. List Labs by Reservation\n" +
                                "4. Add a Reservation\n" +
                                "5. Remove a Reservation\n" +
                                "6. Modify a Reservation\n" +
                                "7. Calculate Statistics\n" +
                                "8. Exit";
    private static String statisticsMenu = "1. Total Capacity\n" +
                                            "2. Total Utilization\n" +
                                            "3. Available seats\n" +
                                            "4. Return to main menu";
    private static String exitMessage = "Thank you for using TimeKeeper!";
    
    public static void main(String[] args) {
        System.out.println(welcomePrompt);
        Scanner scan = new Scanner(System.in);
        int capacity;
        String location;
        int choice1;
        int choice2;
        int choice3;
        do {
            System.out.println(initializeMenu);
            choice1 = scan.nextInt();
            scan.nextLine();
            if (choice1 < 1 || choice1 > 2)
                System.out.println(invalidInput);
        } while(choice1 < 1 || choice1 > 2);  

        if (choice1 == 1) {
            System.out.println(enterLabCapacity + "1:");
            capacity = scan.nextInt();
            scan.nextLine();
            System.out.println(enterLabLocation + "1:");
            location = scan.nextLine();
            Lab labOne = new Lab(capacity, location);
            System.out.println(enterLabCapacity + "2:");
            capacity = scan.nextInt();
            scan.nextLine();
            System.out.println(enterLabLocation + "2:");
            location = scan.nextLine();
            Lab labTwo = new Lab(capacity, location);
            System.out.println(enterLabCapacity + "3:");
            capacity = scan.nextInt();
            scan.nextLine();
            System.out.println(enterLabLocation + "3:");
            location = scan.nextLine();
            Lab labThree = new Lab(capacity, location);
            LabManager labManager = new LabManager(labOne, labTwo, labThree);
            
            do {
                System.out.println(ongoingMenu);
                choice2 = scan.nextInt();
                scan.nextLine();
                switch(choice2) {
                    case 1: System.out.println(labOne.toString() + "\n" + labTwo.toString() + "\n" 
                        + labThree.toString());
                        break;
                    case 2: System.out.println("Lab One\n" + labOne.listAvailabilities());
                        System.out.println("Lab Two\n" + labTwo.listAvailabilities());
                        System.out.println("Lab Three\n" + labThree.listAvailabilities());
                        break;
                    case 3: System.out.println("Lab One\n" + labOne.listReservations());
                        System.out.println("Lab Two\n" + labTwo.listReservations());
                        System.out.println("Lab Three\n" + labThree.listReservations());
                        break;
                    case 4: System.out.println(labLocationPrompt);
                        location = scan.nextLine();
                        System.out.println(reservationTimePrompt);
                        String time = scan.nextLine();
                        System.out.println(reservationNamePrompt);
                        String name = scan.nextLine();
                        System.out.println(reservationEnrollmentPrompt);
                        capacity = scan.nextInt();
                        scan.nextLine();
                        System.out.println(labManager.addReservation(location, time, name, capacity));
                        break;
                    case 5: System.out.println(labLocationPrompt);
                        location = scan.nextLine();
                        System.out.println(reservationTimePrompt);
                        time = scan.nextLine();
                        System.out.println(labManager.removeReservation(location, time));
                        break;
                    case 6: System.out.println(labLocationPrompt);
                        location = scan.nextLine();
                        System.out.println(reservationTimePrompt);
                        time = scan.nextLine();
                        System.out.println(reservationNameUpdate);
                        name = scan.nextLine();
                        System.out.println(reservationEnrollmentUpdate);
                        capacity = scan.nextInt();
                        scan.nextLine();
                        System.out.println(labManager.modifyReservation(location, time, name, capacity));
                        break;
                    case 7: do{
                            System.out.println(statisticsMenu);
                            choice3 = scan.nextInt();
                            scan.nextLine();
                            switch(choice3) {
                                case 1: System.out.println(totalCapacity + labManager.calculateTotalCapacity());
                                    break;
                                case 2: System.out.printf(totalUtilization + "%.2f\n",labManager.calculateTotalUtilization());
                                    break;
                                case 3: System.out.println(availableSeats + labManager.calculateAvailableSeats());
                                    break;
                                case 4: break;
                                default: System.out.println(invalidInput);
                                    break;
                            }
                        }while(choice3 != 4);
                        break;

                    case 8: System.out.println(exitMessage);
                        break;
                    default: System.out.println(invalidInput);
                        break;
                }
            }while(choice2 != 8);

        }

        else
            System.out.println(exitMessage);


        
    }

    
}