/*
 *  Copyright (C) 2022 Christian Knorr, Simon Lenz.
 *  All rights reserved.
 */

package loesungen;

public class Person {

    private final String fName;
    private final String lName;

    public Person(String firstname, String lastname) {
        fName = firstname;
        lName = lastname;
    }


    public String getFirstname() {
        return fName;
    }


    public String getLastname() {
        return lName;
    }


    public String toString() {
        return fName + " " + lName;
    }


    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Person) {
            Person other = (Person) obj;
            return other.lName.equals(lName) && other.fName.equals(fName);
        } else {
            return false;
        }
    }
}
