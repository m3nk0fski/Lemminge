/*
 *  Copyright (C) 2022 Christian Knorr, Simon Lenz.
 *  All rights reserved.
 */

package loesungen;

import java.util.ArrayList;
import java.util.List;

public class MultiAccount extends Account {

    private final List<Person> owners;

    public MultiAccount(int id, Person[] owner) {
        super(id, null);
        owners = new ArrayList<Person>();
        for (int i = 0; i < owner.length; i++) {
            Person person = owner[i];
            owners.add(person);
        }
    }


    public Person[] getOwners() {
        Person[] result = new Person[owners.size()];
        for (int i = 0; i < owners.size(); i++) {
            result[i] = (Person) owners.get(i);
        }
        return result;
    }


    public void removeOwner(Person owner) {
        owners.remove(owner);
    }


    public void addOwner(Person owner) {
        owners.add(owner);
    }


    public Person getOwner() {
        return (Person) owners.get(0);
    }


    public void setOwner(Person owner) {
        throw new UnsupportedOperationException();
    }
}
