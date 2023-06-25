package loesungen;

/*
 *  Copyright (C) 2022 Christian Knorr, Simon Lenz.
 *  All rights reserved.
 */

import java.util.ArrayList;

public class Aufgabe18 {

    private final ArrayList<MultiAccount> accountList = new ArrayList<MultiAccount>();
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


    private void printAccountMenu(MultiAccount account) {
        System.out.println();
        System.out.println("= = = = = = = = = = = = =");
        System.out.println("=   Account Operations  =");
        System.out.println("= = = = = = = = = = = = =");
        System.out.println();
        System.out.println("Selected account: " + account.getId());
        System.out.println("Owners:           " + getOwnerLine(account));
        System.out.println();
        System.out.println("  1 - Show details");
        System.out.println("  2 - Pay in ");
        System.out.println("  3 - Pay out");
        System.out.println("  4 - Edit owners");
        System.out.println("  5 - Return to Main Menu");
        System.out.println();
    }


    private void printOwnerMenu(MultiAccount account) {
        System.out.println();
        System.out.println("= = = = = = = = = = = =");
        System.out.println("=   Owner Operations  =");
        System.out.println("= = = = = = = = = = = =");
        System.out.println();
        System.out.println("Selected account: " + account.getId());
        System.out.println("Owners:           " + getOwnerLine(account));
        System.out.println();
        System.out.println("  1 - Show owners");
        System.out.println("  2 - Remove owner");
        System.out.println("  3 - Add owner");
        System.out.println("  4 - Return to Account Menu");
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


    private boolean isAccountPresent(MultiAccount account) {
        for (int i = 0; i < accountList.size(); i++) {
            MultiAccount ac = (MultiAccount) accountList.get(i);
            if (ac.equals(account)) {
                return true;
            }
        }

        return false;
    }


    private void addAccount(MultiAccount account) {
        if (!isAccountPresent(account)) {
            accountList.add(account);
        } else {
            System.out.println("Account does already exist. Not added.");
            System.out.println();
        }
    }


    private Person createOwner() {
        System.out.print("Enter owner's firstname: ");
        String fName = SystemInReader.readln();
        System.out.print("Enter owner's lastname: ");
        String lName = SystemInReader.readln();
        return new Person(fName, lName);
    }


    private void createAccount() {
        System.out.println();
        System.out.print("Enter number of owners: ");
        int ownerCount = SystemInReader.readInt();
        Person[] owners = new Person[ownerCount];
        for (int i = 0; i < owners.length; i++) {
            System.out.println();
            System.out.println("Owner no. " + (i + 1));
            owners[i] = createOwner();
        }
        MultiAccount account = new MultiAccount(nextId++, owners);
        addAccount(account);
    }


    private void showOwners(MultiAccount account) {
        System.out.println();
        System.out.println("= = = = = = = = = = = = =");
        System.out.println("=   Current Owner List  =");
        System.out.println("= = = = = = = = = = = = =");
        System.out.println();
        System.out.println("Account no.: " + account.getId());
        System.out.println();
        Person[] owners = account.getOwners();
        for (int i = 0; i < owners.length; i++) {
            Person owner = owners[i];
            System.out.println(i + " - " + owner.toString());
        }
    }


    private String getOwnerLine(MultiAccount account) {
        String result = new String();
        Person[] owners = account.getOwners();
        for (int i = 0; i < owners.length; i++) {
            Person owner = owners[i];
            if (i > 0) {
                result += ", ";
            }
            result += owner.toString();
        }
        return result;
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
            MultiAccount ac = (MultiAccount) accountList.get(i);
            System.out.println(i + " - ID: " + ac.getId() + ", Owners: " + getOwnerLine(ac));
        }
        System.out.println();
    }


    private void showDetails(MultiAccount account) {
        System.out.println();
        System.out.println("= = = = = = = = = = = =");
        System.out.println("=   Account Details   =");
        System.out.println("= = = = = = = = = = = = ");
        System.out.println();
        System.out.println("  ID:       " + account.getId());
        System.out.println("  Owners:   " + getOwnerLine(account));
        System.out.println("  Balance:  " + account.getBalance());
    }


    private void payin(MultiAccount account) {
        System.out.println();
        System.out.print("Enter amount to be paid in: ");
        double amount = SystemInReader.readDouble();
        account.payin(amount);
    }


    private void payout(MultiAccount account) {
        System.out.println();
        System.out.print("Enter amount to be paid out: ");
        double amount = SystemInReader.readDouble();
        boolean successful = account.payout(amount);
        if (!successful) {
            System.out.println("Account limit succeeded, operation cancelled.");
        }
    }


    private void removeOwner(MultiAccount account) {
        showOwners(account);
        System.out.println();
        System.out.print("Enter number of owner to be removed: ");
        int i = SystemInReader.readInt();
        Person toBeRemoved = account.getOwners()[i];
        account.removeOwner(toBeRemoved);
    }


    private void addOwner(MultiAccount account) {
        System.out.println();
        Person owner = createOwner();
        account.addOwner(owner);
    }


    private void editOwners(MultiAccount account) {
        for (;;) {          // loop endlessly
            printOwnerMenu(account);
            int choice = enterChoice(1, 4);
            switch (choice) {
                case 1:
                    showOwners(account);
                    break;
                case 2:
                    removeOwner(account);
                    break;
                case 3:
                    addOwner(account);
                    break;
                case 4:
                    return;
            }
        }
    }


    private void selectAccount() {
        showAccounts();
        System.out.print("Enter account number to be selected: ");
        int position = SystemInReader.readInt();
        MultiAccount selectedAccount = (MultiAccount) accountList.get(position);

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
                    editOwners(selectedAccount);
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
        Aufgabe18 prog = new Aufgabe18();
        prog.start();
    }
}
