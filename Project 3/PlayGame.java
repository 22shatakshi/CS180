import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * PlayGame class
 *
 * @author Shatakshi Singh
 * @version 10/25/2021
 */
public class PlayGame {
    public static ArrayList<String> shipPositions(String fileName) {
        char row = 'A';
        ArrayList<String> positions = new ArrayList<>();
        try {
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null)
                    break;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == 'H')
                        positions.add(String.valueOf(row) + (i + 1));      
                }
                row++;
            }
            br.close();
            return positions;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return positions;
    }
    public static String boardPattern(String fileName) {
        int th = 0;
        int mh = 0;
        int bh = 0;
        ArrayList<String> position = shipPositions(fileName);
        for (int i = 0; i < position.size(); i++) {
            char row = position.get(i).charAt(0);
            if (row == 'A' || row == 'B' || row == 'C')
                th++;
            if (row == 'D' || row == 'E' || row == 'F' || row == 'G')
                mh++;
            if (row == 'H' || row == 'I' || row == 'J')
                bh++;  
        }
        if (th > 8)
            return "Top Heavy";
        else if (mh > 8)
            return "Middle Heavy";
        else if (bh > 8)
            return "Bottom Heavy";
        else
            return "Scattered";
    }
    public static void main(String[] args) throws IOException {
        int playerOneHits = 0;
        int playerTwoHits = 0;
        int playerOneTurns = 0;
        int playerTwoTurns = 0;
        String playerOneBoardPattern = boardPattern("ShipPositionsPlayerOne.txt");
        String playerTwoBoardPattern = boardPattern("ShipPositionsPlayerTwo.txt");
        ArrayList<String> playerOne = shipPositions("ShipPositionsPlayerOne.txt");
        ArrayList<String> playerTwo = shipPositions("ShipPositionsPlayerTwo.txt");
        System.out.println("Hello, Welcome to Battleship!");
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Player 1 - Enter a row letter from A - J");
            String position = scan.nextLine();
            System.out.println("Player 1 - Enter a column number from 1 - 14");
            int column = scan.nextInt();
            scan.nextLine();
            position += String.valueOf(column);
            playerOneTurns++;
            int found = 0;
            for (int i = 0; i < playerTwo.size(); i++) {
                if (playerTwo.get(i).equals(position)) {
                    playerOneHits++;
                    playerTwo.remove(i);
                    System.out.println("Value:H");
                    found = 1;
                }
            }
            if (found == 0)
                System.out.println("Value:M");
            if (playerOneHits == 17)
                break;

            System.out.println("Player 2 - Enter a row letter from A - J");
            position = scan.nextLine();
            System.out.println("Player 2 - Enter a column number from 1 - 14");
            column = scan.nextInt();
            scan.nextLine();
            position += String.valueOf(column);
            playerTwoTurns++;
            found = 0;
            for (int i = 0; i < playerOne.size(); i++) {
                if (playerOne.get(i).equals(position)) {
                    playerTwoHits++;
                    playerOne.remove(i);
                    System.out.println("Value:H");
                    found = 1;
                }
            }
            if (found == 0)
                System.out.println("Value:M");
        } while (playerOneHits != 17 && playerTwoHits != 17);
        scan.close();
        if (playerOneHits == 17) {
            System.out.println("Enemy fleet destroyed, congratulations player 1!");
            GameLog gameLog = new GameLog(1, playerTwoHits, 
                playerOneTurns, playerOneBoardPattern, playerTwoBoardPattern);
            File f = new File("GameLog.txt");
            try {
                FileOutputStream fos = new FileOutputStream(f);
                PrintWriter pw = new PrintWriter(fos);
                pw.println(gameLog.toString());
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (playerTwoHits == 17) {
            System.out.println("Enemy fleet destroyed, congratulations player 2!");
            GameLog gameLog = new GameLog(2, playerOneHits, 
                playerTwoTurns, playerOneBoardPattern, playerTwoBoardPattern);
            File f = new File("GameLog.txt");
            try {
                FileOutputStream fos = new FileOutputStream(f);
                PrintWriter pw = new PrintWriter(fos);
                pw.println(gameLog.toString());
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}