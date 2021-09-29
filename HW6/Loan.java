import java.lang.Math;

public class Loan {
    private int duration;
    private double rate;
    private double amount;
    private double monthlyPayment;

    public Loan(int duration, double rate, double amount) {
        this.duration = duration;
        this.rate = rate;
        this.amount = amount;
        this.monthlyPayment = calculateMonthlyPayment();
    }

    public int getDuration() {
        return duration;
    }

    public double getRate() {
        return rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double calculateMonthlyPayment() {
        double powerTerm = Math.pow(1 + rate / 12, duration);
        monthlyPayment = amount * (rate/12) * powerTerm / (powerTerm - 1);
        return monthlyPayment;
    }

    public double totalInterest(boolean output) {
        int paymentNumber = 0;
        double totalInterest = 0.00;
        double interest;
        double principal = monthlyPayment - rate/12;
        double remaining = amount;

        while (remaining > 0.00 && paymentNumber != duration) {
            interest = remaining * (rate / 12);
            totalInterest += interest;
            principal = monthlyPayment - interest;
            remaining -= principal;
            paymentNumber++;
            
            if (output) {
                System.out.println("Payment " + paymentNumber + " - Principal: " + String.format("%.2f",principal) + " - Interest: "
                + String.format("%.2f",interest) + " - Remaining: " + String.format("%.2f",remaining));
            }
        }
        return totalInterest;
    }

    public String toString() {
        String message = "Amount: " + String.format("%.2f",amount) + " - Rate: " + String.format("%.2f",rate) + 
        " - Duration: " + String.valueOf(duration) + " - Payment: " + String.format("%.2f",monthlyPayment) + ".";

        return message;
    }

}