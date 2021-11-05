import java.util.Scanner;

public class StatisticsCalculator {
    private String message;

    public StatisticsCalculator(String message) {
        this.message = message;
    }

    public int messageLength() {
        return message.length();
    }

    public int numWords() {
        return message.split(" ").length;
    }

    public int punctuations() {
        int punct = 0;
        for (int i = 0; i < messageLength(); i++) {
            if (message.charAt(i) != ' ' && !Character.isDigit(message.charAt(i))
                    && !Character.isAlphabetic(message.charAt(i)))
                punct++;
        }
        return punct;
    }

    public int countWithoutSpaces() {
        int count = 0;
        for (int i = 0; i < messageLength(); i++) {
            if (message.charAt(i) != ' ')
                count++;
        }
        return count;
    }

    // TODO need to make digit count print correctly
    public int[] digitCount() {
        int[] digits = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < messageLength(); i++) {
            if (Character.isDigit(message.charAt(i))) {
                for (int j = 0; j < digits.length; j++) {
                    int digit = Character.getNumericValue(message.charAt(i));
                    if (digit == j)
                        digits[j]++;
                }
            }
        }
        return digits;
    }
    // TODO need to claculate last stastics claculator

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter text message to get statistics");
        String text = scan.nextLine();
        StatisticsCalculator test = new StatisticsCalculator(text);
        System.out.println(test.numWords());
        System.out.println(test.messageLength());
        System.out.println(test.countWithoutSpaces());
        System.out.println(test.punctuations());
        System.out.println(test.digitCount());
    }
} 
