import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class StatisticsClient {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        int option;
        String message;
        String host;

        JOptionPane.showMessageDialog(null, "Welcome to Statistics Calculations Program!", "Welcome",
                JOptionPane.INFORMATION_MESSAGE);
        // host = localhost , port = 2212
        do {
            host = JOptionPane.showInputDialog(null, "Enter host name: ", "Statistics Calculator",
                    JOptionPane.QUESTION_MESSAGE);
            if (host.equals(""))
                JOptionPane.showMessageDialog(null, "Host name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            if (host == null)
                return;

        } while (host.equals(""));
        String port = JOptionPane.showInputDialog(null, "Enter port number: ", "Statistics Calculator",
                JOptionPane.QUESTION_MESSAGE);
        int portNumber = Integer.parseInt(port);
        try {
            Socket socket = new Socket(host, portNumber);

            JOptionPane.showMessageDialog(null, "Connection Established!", "Statistics Calculator",
                    JOptionPane.INFORMATION_MESSAGE);
            do {
                boolean empty = false;
                do {
                    message = JOptionPane.showInputDialog(null, "Enter message: ", "Statistics Calculator",
                            JOptionPane.QUESTION_MESSAGE);
                    empty = false;
                    if (message == null || message.equals("")) {
                        JOptionPane.showMessageDialog(null, "Message cannot be empty!", "Statistics Calculator",
                                JOptionPane.ERROR_MESSAGE);
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
                /*
                 * while (true) { String next = reader.readLine(); System.out.println(next); if
                 * (next == null) break; statistics += "\n" + next;
                 * //System.out.println(statistics); }
                 */
                // System.out.println(statistics);

                JOptionPane.showMessageDialog(null, statistics, "Statistics Calculator",
                        JOptionPane.INFORMATION_MESSAGE);
                option = JOptionPane.showConfirmDialog(null, "Would you like to enter another message?",
                        "Statistics Calculator", JOptionPane.YES_NO_OPTION);
                // writer.close();
                // reader.close();
            } while (option == 0);
            JOptionPane.showMessageDialog(null, "Thank you for using statistics calculator!", "Statistics Calculator",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Error establishing connection!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}