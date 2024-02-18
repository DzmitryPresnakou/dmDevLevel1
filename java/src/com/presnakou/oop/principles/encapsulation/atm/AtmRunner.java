package com.presnakou.oop.principles.encapsulation.atm;

public class AtmRunner {

    public static void main(String[] args) {
        Atm atm = new Atm(20, 20, 20);
        atm.getMoney(180);
    }
}
