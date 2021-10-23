import java.util.Scanner;

/**
 * A simple BaseballScores class
 *
 * @author Shatakshi Singh
 * @version 09/22/2021
 */
public class BaseballScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter Team One Name:");
        String teamOne = scanner.nextLine();
        System.out.println("Enter Team Two Name:");
        String teamTwo = scanner.nextLine();
        System.out.println("Enter Inning Scores:");
        String scores = scanner.nextLine();


        scanner.close();

        // The scores for each inning are calculated and stored in the variables below. 
        int currentScoreIndex = 0;
        int teamOneInningOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningOne = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningTwo = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningThree = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningThree = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningFour = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningFour = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningFive = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningFive = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningSix = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningSix = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningSeven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningSeven = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        currentScoreIndex += 3;
        int teamOneInningEight = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningEight = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));


        currentScoreIndex += 3;
        int teamOneInningNine = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));
        currentScoreIndex += 3;
        int teamTwoInningNine = Integer.parseInt(scores.substring(currentScoreIndex, currentScoreIndex + 2));

        int[] teamOneScore = {teamOneInningOne, teamOneInningTwo, teamOneInningThree, teamOneInningFour, 
            teamOneInningFive, teamOneInningSix, teamOneInningSeven, teamOneInningEight, teamOneInningNine};
        int[] teamTwoScore = {teamTwoInningOne, teamTwoInningTwo, teamTwoInningThree, teamTwoInningFour, 
            teamTwoInningFive, teamTwoInningSix, teamTwoInningSeven, teamTwoInningEight, teamTwoInningNine};
        int teamOneTotal = 0;
        int teamTwoTotal = 0;
        for(int i = 0; i < 9; i++){
            teamOneTotal += teamOneScore[i];
            teamTwoTotal += teamTwoScore[i];
        }
        if (teamOneTotal > teamTwoTotal)
            System.out.println("The winner is: " + teamOne +(teamOneTotal-teamTwoTotal));
        else
            System.out.println("The winner is: " + teamTwo +(teamTwoTotal-teamOneTotal));
        System.out.println(teamOne + " scored " + teamOneTotal + " points.");
        System.out.println(teamTwo + " scored " + teamTwoTotal + " points.");

        String teamOneLog = "";
        String teamTwoLog = "";
        int teamOnePerfectInnings = 0;
        int teamTwoPerfectInnings = 0; 
        for (int i = 0; i < 9; i++){
            if (teamOneScore[i] > teamTwoScore[i]){
                teamOneLog += "W-";
                teamTwoLog += "L-";
            } else if (teamOneScore[i] < teamTwoScore[i]){
                teamOneLog += "L-";
                teamTwoLog += "W-";
            } else {
                teamOneLog += "T-";
                teamTwoLog += "T-";
            }

            if (teamOneScore[i] != 0 && teamTwoScore[i] == 0)
                teamOnePerfectInnings++;
            else if (teamOneScore[i] == 0 && teamTwoScore[i] != 0)
                teamTwoPerfectInnings++;           
        }
        System.out.println(teamOne + " Game Log: " + teamOneLog.substring(0,teamOneLog.length() - 1));
        System.out.println(teamTwo + " Game Log: " + teamTwoLog.substring(0,teamOneLog.length() - 1));
        System.out.println(teamOne + " Perfect Innings: " + teamOnePerfectInnings);
        System.out.println(teamTwo + " Perfect Innings: " + teamTwoPerfectInnings);
    }
}
