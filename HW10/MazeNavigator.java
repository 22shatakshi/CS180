import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * A Maze Navigator class that processes input
 * to navigate the maze.
 *
 * @author Shatakshi Singh
 * @version 10/29/2021
 */
public class MazeNavigator extends Thread {
    private static int currentColumn = 4;
    private static int currentRow = 4;
    private static int moveNumber = 0;
    private static boolean started = false;
    private static char[][] maze = new char[10][10];
    private int playerNumber;
    private String fileName;
    public static Object sync = new  Object();
    public MazeNavigator(int player, String fileName) {
        this.playerNumber = player;
        this.fileName = fileName;
    }
    public void printCurrentMaze() {
        for (int i = 0; i < 10; i++) {
            System.out.print("[");
            for (int j = 0; j < 10; j++) {
                if (i == currentRow && j == currentColumn)
                    maze[i][j] = 'X';
                else
                    maze[i][j] = ' ';
                if (j != 9)
                    System.out.print(maze[i][j] + ",");
                else
                    System.out.print(maze[i][j] + "]\n");   
            }
        }
    }
    public void run() {
        synchronized (sync) {
            if (!started) {
                System.out.println("Welcome! Initial Maze:");
                printCurrentMaze();
                started = true;
            }
        }
        ArrayList<Integer> moves = new ArrayList<>();
        try {
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String move = br.readLine();
                if (move == null)
                    break;
                moves.add(Integer.valueOf(move));
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < moves.size(); i++) {
            synchronized (sync) {
                moveNumber++;
                System.out.println("Move number: " + moveNumber);
                System.out.println("Player: " + playerNumber);
                if (moves.get(i).intValue() == 1) {
                    if (currentColumn ==  0) {
                        System.out.println("Move: Left");
                        currentColumn = 9;
                    } else {
                        System.out.println("Move: Left");
                        currentColumn--;
                    }
                } else if (moves.get(i).intValue() == 2) {
                    if (currentColumn ==  9) {
                        System.out.println("Move: Right");
                        currentColumn = 0;
                    } else {
                        System.out.println("Move: Right");
                        currentColumn++;
                    }
                } else if (moves.get(i).intValue() == 3) {
                    if (currentRow ==  0) {
                        System.out.println("Move: Up");
                        currentRow = 9;
                    } else {
                        System.out.println("Move: Up");
                        currentRow--;
                    }
                } else if (moves.get(i).intValue() == 4) {
                    if (currentColumn ==  9) {
                        System.out.println("Move: Down");
                        currentRow = 0;
                    } else {
                        System.out.println("Move: Down");
                        currentRow++;
                    }
                } else {
                    System.out.println("Move: Error, invalid input!");
                }
                printCurrentMaze();
            }
        }     

    }  
    public static void main(String[] args) {
        try {
            MazeNavigator[] mazeNavigators = {new MazeNavigator(1, "PlayerOneMoves.txt"),
                    new MazeNavigator(2, "PlayerTwoMoves.txt")}; 
    
            for (int i = 0; i < mazeNavigators.length; i++) {
                mazeNavigators[i].start();
            }
            for (int i = 0; i < mazeNavigators.length; i++) {
                mazeNavigators[i].join();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
    
}