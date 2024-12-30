import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le montant du prêt (principal) : ");
        double principal = scanner.nextDouble();

        System.out.print("Entrez le taux d'intérêt annuel (en %) : ");
        double annualInterestRate = scanner.nextDouble();

        System.out.print("Entrez la durée du prêt en années : ");
        int years = scanner.nextInt();

        double monthlyInterestRate = annualInterestRate / 100 / 12;

        int numberOfPayments = years * 12;

        double monthlyPayment = calculateMonthlyPayment(principal, monthlyInterestRate, numberOfPayments);

        double totalPayment = monthlyPayment * numberOfPayments;

        System.out.printf("Le paiement mensuel est : %.2f\n", monthlyPayment);

        System.out.printf("Le paiment totale est %.2f\n" , totalPayment);

        scanner.close();
    }

    public static double calculateMonthlyPayment(double principal, double monthlyInterestRate, int numberOfPayments) {
        return principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) /
               (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }
}