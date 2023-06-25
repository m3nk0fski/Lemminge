package loesungen;

/*
 *  Copyright (C) 2022 Christian Knorr, Simon Lenz.
 *  All rights reserved.
 */

import java.util.ArrayList;

public class Aufgabe17 {

    private final ArrayList<Account> accountList = new ArrayList<Account>();
    private int nextId = 20000000;


    private void printMainMenu() {
        System.out.println();
        System.out.println("= = = = = = = = = = = = =");
        System.out.println("=   Account Management  =");
        System.out.println("= = = = = = = = = = = = =");
        System.out.println();
        System.out.println("  1 - Show accounts");
        System.out.println("  2 - Create account");
        System.out.println("  3 - Select account");
        System.out.println("  4 - Exit");
        System.out.println();
    }


    private void printAccountMenu(Account account) {
        System.out.println();
        System.out.println("= = = = = = = = = = = = =");
        System.out.println("=   Account Operations  =");
        System.out.println("= = = = = = = = = = = = =");
        System.out.println();
        System.out.println("Selected account: " + account.getId());
        System.out.println("Owner:            " + account.getOwner());
        System.out.println();
        System.out.println("  1 - Show details");
        System.out.println("  2 - Pay in ");
        System.out.println("  3 - Pay out");
        System.out.println("  4 - Change owner");
        System.out.println("  5 - Return to Main Menu");
        System.out.println();
    }


    private int enterChoice(int min, int max) {
        int result;
        do {
            System.out.print("Enter your choice (" + min + "-" + max + "): ");
            result = SystemInReader.readInt();
        } while (result < min && result > max);
        return result;
    }


    private boolean isAccountPresent(Account account) {
        for (int i = 0; i < accountList.size(); i++) {
            Account ac = (Account) accountList.get(i);
            if (ac.equals(account)) {
                return true;
            }
        }

        return false;
    }


    private void addAccount(Account account) {
        if (!isAccountPresent(account)) {
            accountList.add(account);
        } else {
            System.out.println("Account does already exist. Not added.");
            System.out.println();
        }
    }


    private Person createOwner() {
        System.out.println();
        System.out.print("Enter owner's firstname: ");
        String fName = SystemInReader.readln();
        System.out.print("Enter owner's lastname: ");
        String lName = SystemInReader.readln();
        return new Person(fName, lName);
    }


    private void createAccount() {
        Person owner = createOwner();
        Account account = new Account(nextId++, owner);
        addAccount(account);
    }


    private void showAccounts() {
        System.out.println();
        System.out.println("= = = = = = = = = = = = = =");
        System.out.println("=   Current Account List  =");
        System.out.println("= = = = = = = = = = = = = =");
        System.out.println();
        System.out.println(accountList.size() + " account(s) available: ");
        System.out.println();
        for (int i = 0; i < accountList.size(); i++) {
            Account ac = (Account) accountList.get(i);
            System.out.println(i + " - ID: " + ac.getId() + ", Owner: " + ac.getOwner());
        }
        System.out.println();
    }


    private void showDetails(Account account) {
        System.out.println();
        System.out.println("= = = = = = = = = = = =");
        System.out.println("=   Account Details   =");
        System.out.println("= = = = = = = = = = = = ");
        System.out.println();
        System.out.println("  ID:       " + account.getId());
        System.out.println("  Owner:    " + account.getOwner());
        System.out.println("  Balance:  " + account.getBalance());
    }


    private void payin(Account account) {
        System.out.println();
        System.out.print("Enter amount to be paid in: ");
        double amount = SystemInReader.readDouble();
        account.payin(amount);
    }


    private void payout(Account account) {
        System.out.println();
        System.out.print("Enter amount to be paid out: ");
        double amount = SystemInReader.readDouble();
        boolean successful = account.payout(amount);
        if (!successful) {
            System.out.println("Account limit succeeded, operation cancelled.");
        }
    }


    private void changeOwner(Account account) {
        System.out.println();
        System.out.println("= = = = = = = = = =");
        System.out.println("=   Change Owner  =");
        System.out.println("= = = = = = = = = = ");
        Person owner = createOwner();
        account.setOwner(owner);
    }


    private void selectAccount() {
        showAccounts();
        System.out.print("Enter account number to be selected: ");
        int position = SystemInReader.readInt();
        Account selectedAccount = (Account) accountList.get(position);

        for (;;) {          // loop endlessly
            printAccountMenu(selectedAccount);
            int choice = enterChoice(1, 5);
            switch (choice) {
                case 1:
                    showDetails(selectedAccount);
                    break;
                case 2:
                    payin(selectedAccount);
                    break;
                case 3:
                    payout(selectedAccount);
                    break;
                case 4:
                    changeOwner(selectedAccount);
                    break;
                case 5:
                    return;
            }
        }
    }


    private void start() {
        for (;;) {          // loop endlessly
            printMainMenu();
            int choice = enterChoice(1, 4);
            switch (choice) {
                case 1:
                    showAccounts();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    selectAccount();
                    break;
                case 4:
                    return;
            }
        }
    }


    public static void main(String[] args) {
        Aufgabe17 prog = new Aufgabe17();
        prog.start();
    }
}
