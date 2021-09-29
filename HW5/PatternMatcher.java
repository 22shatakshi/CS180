import java.util.Scanner;

public class PatternMatcher {
    
    public static void main(String[] args) {
        
        String chooseLevel = "Choose Level Difficulty:" +
                "\n1. Easy\n2. Medium\n3. Hard";
        String startNumber = "Enter a number to start the pattern:";
        String nextThree = "Enter the next 3 numbers in the pattern:";
        String congratulations = "Congrats! Your answer was correct!";
        String sorry = "Sorry! Your answer was incorrect!";
        String again = "Play Game Again? (y/n)";
        String ending = "Ending Pattern Matcher...";
        Scanner scan = new Scanner(System.in);
        int option;
        String overallOption;        
        //TODO: write your code below
        do{   
            do{
                System.out.println(chooseLevel);
                option = scan.nextInt();
                scan.nextLine();
            }while(option > 3 || option < 1);

            System.out.println(startNumber);
            int start = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:{
                    System.out.println(nextThree);
                    for(int i = 0; i < 4; i++){
                        System.out.print(start + " ");
                        start += 2;
                    }
                    break;
                }
                case 2:{
                    System.out.println(nextThree);
                    for(int i = 0; i < 4; i++){
                        System.out.print(start + " ");
                        start *= 4;
                    }
                    break;
                }
                case 3:{
                    System.out.println(nextThree);
                    for (int i = 0; i < 4; i++) {
                        System.out.print(start*start + 1 + " ");
                        start++;
                    }
                    break;
                }
            }
            System.out.println();
            int answer1 = scan.nextInt();
            scan.nextLine();
            int answer2 = scan.nextInt();
            scan.nextLine();
            int answer3 = scan.nextInt();
            scan.nextLine();
            switch(option){
                case 1:{
                    if(answer1 == start)
                        start += 2;
                    else{
                        System.out.println(sorry);
                        break;
                    }
                    if(answer2 == start)
                        start += 2;
                    else{
                        System.out.println(sorry);
                        break;
                    }
                    if(answer3 == start)
                        System.out.println(congratulations);
                    else{
                        System.out.println(sorry);
                        break;
                    }
                    break;
                }
                case 2:{
                    if(answer1 == start)
                        start *=4 ;
                    else{
                        System.out.println(sorry);
                        break;
                    }
                    if(answer2 == start)
                        start *= 4;
                    else{
                        System.out.println(sorry);
                        break;
                    }
                    if(answer3 == start)
                        System.out.println(congratulations);
                    else{
                        System.out.println(sorry);
                        break;
                    }
                    break;
                }
                case 3:{
                    if(answer1 == (start*start + 1))
                        start++;
                    else{
                        System.out.println(sorry);
                        break;
                    }
                    if(answer2 == (start*start + 1))
                        start++;
                    else{
                        System.out.println(sorry);
                        break;
                    }
                    if(answer3 == (start*start + 1))
                        System.out.println(congratulations);
                    else{
                        System.out.println(sorry);
                        break;
                    }
                    break;
                }
            }
            System.out.println(again);
            overallOption = scan.nextLine();
            if(overallOption.equals("n"))
                System.out.println(ending);

        }while(overallOption.equals("y"));
    }
}
