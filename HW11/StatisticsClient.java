import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class StatisticsClient {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        int option;
        String message;
        String host;

        showMessage("Welcome to Statistics Calculations Program!", "Welcome");
        // host = localhost , port = 2212
        do {
            host = inputMethod("Enter host name: ");
            if (host == null) {
                exitMessage();
                return;
            }
            if (host.equals(""))
                errorMessage("Host name cannot be empty!");
        } while (host.equals(""));
        String port = inputMethod("Enter port number: ");

        try {
            int portNumber = Integer.parseInt(port);
            Socket socket = new Socket(host, portNumber);
            showMessage("Connection Established!", "Statistics Calculator");
            do {
                boolean empty = false;
                do {
                    message = inputMethod("Enter message: ");
                    empty = false;
                    if (message == null) {
                        exitMessage();
                        return;
                    }
                    if (message.equals("")) {
                        errorMessage("Message cannot be empty!");
                        empty = true;
                    }
                } while (empty);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                writer.write(message);
                writer.println();
                writer.flush();

                String statistics = reader.readLine() + "\n";
                statistics += reader.readLine() + "\n";
                statistics += reader.readLine() + "\n";
                statistics += reader.readLine() + "\n";
                statistics += reader.readLine() + "\n";
                statistics += reader.readLine();
                showMessage(statistics, "Statistics Calculator");
                option = confirmMethod("Would you like to enter another message?");
            } while (option == 0);
            exitMessage();
            return;
        } catch (NumberFormatException e) {
            errorMessage("Error establishing connection!\nUser entered incorrect format of port number!");
            return;
        } catch (UnknownHostException e) {
            errorMessage("Error establishing connection!\nUnknown Host!");
            return;
        }
    }

    public static int confirmMethod(String question) {
        int choice = JOptionPane.showConfirmDialog(null, question, "Statistics Calculator", JOptionPane.YES_NO_OPTION);
        return choice;
    }

    public static String inputMethod(String question) {
        String input = JOptionPane.showInputDialog(null, question, "Statistics Calculator",
                JOptionPane.QUESTION_MESSAGE);
        return input;
    }

    public static void showMessage(String text, String title) {
        JOptionPane.showMessageDialog(null, text, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void exitMessage() {
        JOptionPane.showMessageDialog(null, "Thank you for using statistics calculator!", "Statistics Calculator",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void errorMessage(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
}