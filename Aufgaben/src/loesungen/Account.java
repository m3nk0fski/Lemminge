package loesungen;

/*
 *  Copyright (C) 2022 Christian Knorr, Simon Lenz.
 *  All rights reserved.
 */


/**
 * Represents a bank account which is bound to a single owner and
 * identified by a unique id. While the owner may be changed the id
 * has to remain stable. 
 */
public class Account {

    private final int id;

    private Person owner;
    private double balance;


    public Account(int id, Person owner2) {
        this.id = id;
        this.owner = owner2;
    }


    public int getId() {
        return id;
    }


    public Person getOwner() {
        return owner;
    }


    public void setOwner(Person owner) {
        this.owner = owner;
    }


    public double getBalance() {
        return balance;
    }


    public void payin(double amount) {
        balance += amount;
    }


    /**
     * Pay out money from the account. The account is held without drawing
     * credit (ger: Dispositionskredit). If the current balance is smaller than
     * the amount to pay out the transaction is not performed and
     * <code>false</code> is returned.
     *
     * @param amount    The amount of money to be payed out
     * @return          <code>true</code> in case the transaction has been
     *                  successfully accomplished, <code>false</code> if the amount
     *                  exceeds the available balance
     */
    public boolean payout(double amount) {
        if (amount > balance) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }


    public boolean equals(Object obj) {
        // we use this simple test in this case as we expect to have unique ids,
        // two accounts using the same id would be a huge problem anyway
        return obj instanceof Account && ((Account) obj).id == id;
    }
}
