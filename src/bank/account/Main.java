package bank.account;

import bank.account.BankAccount;

import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankAccount> accounts = new HashMap<>();

        while (!"End".equals(input)){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    int currentId = bankAccount.getId();
                    accounts.put(currentId, bankAccount);
                    System.out.println(String.format("Account ID%d created", currentId));

                    break;
                case "Deposit":
                    int idForDeposit = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);
                    String amountForPrint = tokens[2];

                    if (accounts.containsKey(idForDeposit)) {
                        accounts.get(idForDeposit).deposit(amount);

                        DecimalFormat output = new DecimalFormat();

                        System.out.println(String.format("Deposited %s to ID%d", amountForPrint, idForDeposit));
                    }else {
                        System.out.println("Account does not exist");
                    }

                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);

                    break;
                case "GetInterest":
                    int id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    if (accounts.containsKey(id)){
                        double currentInterest = accounts.get(id).getInterestRate(years);
                        System.out.println(String.format("%.2f", currentInterest));
                    }else {
                        System.out.println("Account does not exist");
                    }

                    break;

            }

            input = scanner.nextLine();
        }
    }
}
