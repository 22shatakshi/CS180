/**
 * GameLog class
 *
 * @author Shatakshi Singh
 * @version 10/25/2021
 */
public class GameLog {
    private int winningPlayer;
    private int losingPlayerHits;
    private int numTurns;
    private String boardPatternOne;
    private String boardPatternTwo;
    public GameLog(int winningPlayer, int losingPlayerHits, int numTurns, 
        String boardPatternOne, String boardPatternTwo) {
        this.winningPlayer = winningPlayer;
        this.losingPlayerHits = losingPlayerHits;
        this.numTurns = numTurns;
        this.boardPatternOne = boardPatternOne;
        this.boardPatternTwo = boardPatternTwo;
    }
    public String toString() {
        String gameLog = "Battleship Game Log:\nWinning Player: Player " + winningPlayer;
        if (winningPlayer == 1)
            gameLog += "\nHits: " + 17 + " - " + losingPlayerHits;
        else
            gameLog += "\nHits: " + losingPlayerHits + " - " + 17;
        gameLog += "\nNumber of Turns To Win: " + numTurns;
        gameLog += "\nPlayer 1 Board Pattern: " + boardPatternOne;
        gameLog += "\nPlayer 2 Board Pattern: " + boardPatternTwo;
        return gameLog;
    }


}
