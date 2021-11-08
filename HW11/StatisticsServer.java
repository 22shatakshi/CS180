import java.io.*;
import java.net.*;

public class StatisticsServer {

    public static int messageLength(String message) {
        return message.length();
    }

    public static int numWords(String message) {
        return message.split(" ").length;
    }

    public static int punctuations(String message) {
        int punct = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != ' ' && !Character.isDigit(message.charAt(i))
                    && !Character.isAlphabetic(message.charAt(i)))
                punct++;
        }
        return punct;
    }

    public static int countWithoutSpaces(String message) {
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != ' ')
                count++;
        }
        return count;
    }

    public static String digitCount(String message) {
        int[] digits = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < message.length(); i++) {
            if (Character.isDigit(message.charAt(i))) {
                for (int j = 0; j < digits.length; j++) {
                    int digit = Character.getNumericValue(message.charAt(i));
                    if (digit == j)
                        digits[j]++;
                }
            }
        }
        String count = "";
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 0)
                count += String.valueOf(i) + "-" + String.valueOf(digits[i]) + '\n';
        }
        return count;
    }

    public static String alphaCount(String message) {
        int[] alphabets = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < message.length(); i++) {
            if (Character.isAlphabetic(message.charAt(i))) {
                for (int j = 0; j < alphabets.length; j++) {
                    char alpha = message.charAt(i);
                    if (alpha == (char) (j + 'a'))
                        alphabets[j]++;
                    else if (alpha == (char) (j + 'A'))
                        alphabets[j]++;
                }
            }
        }
        String count = "";
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] > 0)
                count += (char) (i + 'a') + "-" + String.valueOf(alphabets[i]) + '\n';
        }
        return count;

    }

    public static String statisticsString(String message) {
        String string = "Length of message: " + messageLength(message) + "\n";
        string += "Number of words: " + numWords(message) + "\n";
        string += "Number of punctuation marks: " + punctuations(message) + "\n";
        string += "Character count without spaces: " + countWithoutSpaces(message) + "\n";
        if (digitCount(message).equals(""))
            string += "Message doesn't contain any digits\n";
        else
            string += "Digit Count: " + "\n" + digitCount(message);
        if (alphaCount(message).equals(""))
            string += "Message doesn't contain any alphabets\n";
        else
            string += "Alphabet Count: " + "\n" + alphaCount(message);
        return string;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2212);
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        String message = reader.readLine();
        String response = statisticsString(message);
        System.out.println(response);
        writer.write(response);
        writer.println();
        writer.flush();
        writer.close();
        reader.close();

    }

}