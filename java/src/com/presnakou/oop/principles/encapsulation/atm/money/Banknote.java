package com.presnakou.oop.principles.encapsulation.atm.money;

import java.util.Objects;

public class Banknote {

    String name;
    int  amount;

    public Banknote(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banknote banknote = (Banknote) o;
        return amount == banknote.amount && Objects.equals(name, banknote.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
    }

    @Override
    public String toString() {
        return "Banknote{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
