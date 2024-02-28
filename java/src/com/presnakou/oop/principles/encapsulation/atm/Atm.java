package com.presnakou.oop.principles.encapsulation.atm;
/**
 * Создать класс, описывающий банкомат.
 * Банкомат задается тремя свойствами:
 * - количеством купюр номиналом 10, 20 и 50.
 * Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
 * Сделать методы для добавления денег в банкомат.
 * Сделать метод, снимающий деньги: он принимает сумму денег,
 * а возвращает булево значение - успешность выполнения операции.
 * При снятии денег метод должен распечатывать каким количеством купюр
 * какого номинала выдаётся сумма.
 * Сначала банкомат будет пытаться рассчитаться 50,
 * далее добавит недостающие 20, и только затем 10
 * (не нужно рассматривать более сложные варианты выдачи наличных,
 * чтобы не усложнять алгоритм).
 */

import java.util.Objects;

public class Atm {

    private static final int DENOMINATION_OF_TEN_DOLLAR_BILL = 10;
    private static final int DENOMINATION_OF_TWENTY_DOLLAR_BILL = 20;
    private static final int DENOMINATION_OF_FIFTY_DOLLAR_BILL = 50;
    private int numberOfTenDollarBills;
    private int numberOfTwentyDollarBills;
    private int numberOfFiftyDollarBills;

    public Atm(int numberOfTenDollarBills, int numberOfTwentyDollarBills, int numberOfFiftyDollarBills) {
        this.numberOfTenDollarBills = numberOfTenDollarBills;
        this.numberOfTwentyDollarBills = numberOfTwentyDollarBills;
        this.numberOfFiftyDollarBills = numberOfFiftyDollarBills;
    }

    public void addMoney(int numberOfTenDollarBills, int numberOfTwentyDollarBills, int numberOfFiftyDollarBills) {
        this.numberOfTenDollarBills += numberOfTenDollarBills;
        this.numberOfTwentyDollarBills += numberOfTwentyDollarBills;
        this.numberOfFiftyDollarBills += numberOfFiftyDollarBills;
    }

    public void addTenDollarBills(int numberOfTenDollarBills) {
        this.numberOfTenDollarBills += numberOfTenDollarBills;
    }

    public void addTwentyDollarBills(int numberOfTwentyDollarBills) {
        this.numberOfTwentyDollarBills += numberOfTwentyDollarBills;
    }

    public void addFiftyDollarBills(int numberOfFiftyDollarBills) {
        this.numberOfFiftyDollarBills += numberOfFiftyDollarBills;
    }

    public boolean getMoney(int amountOfMoney) {
        int currentNumberOfFiftyDollarBills = 0;
        int currentNumberOfTwentyDollarBills = 0;
        int currentNumberOfTenDollarBills = 0;

        if (getAmountOfMoney() - amountOfMoney < 0) {
            return false;
        }

        if (amountOfMoney / DENOMINATION_OF_FIFTY_DOLLAR_BILL > 0) {
            currentNumberOfFiftyDollarBills = amountOfMoney / DENOMINATION_OF_FIFTY_DOLLAR_BILL;
            currentNumberOfTwentyDollarBills = amountOfMoney % DENOMINATION_OF_FIFTY_DOLLAR_BILL
                    / DENOMINATION_OF_TWENTY_DOLLAR_BILL;
            currentNumberOfTenDollarBills = amountOfMoney % DENOMINATION_OF_FIFTY_DOLLAR_BILL
                    % DENOMINATION_OF_TWENTY_DOLLAR_BILL / DENOMINATION_OF_TEN_DOLLAR_BILL;
        } else if (amountOfMoney / DENOMINATION_OF_TWENTY_DOLLAR_BILL > 0) {
            currentNumberOfTwentyDollarBills = amountOfMoney / DENOMINATION_OF_TWENTY_DOLLAR_BILL;
            currentNumberOfTenDollarBills = amountOfMoney % DENOMINATION_OF_TWENTY_DOLLAR_BILL
                    / DENOMINATION_OF_TEN_DOLLAR_BILL;
        } else if (amountOfMoney / DENOMINATION_OF_TEN_DOLLAR_BILL > 0) {
            currentNumberOfTenDollarBills = amountOfMoney / DENOMINATION_OF_TEN_DOLLAR_BILL;
        } else {
            return false;
        }

        boolean result = (amountOfMoney - (currentNumberOfFiftyDollarBills * DENOMINATION_OF_FIFTY_DOLLAR_BILL +
                currentNumberOfTwentyDollarBills * DENOMINATION_OF_TWENTY_DOLLAR_BILL +
                currentNumberOfTenDollarBills * DENOMINATION_OF_TEN_DOLLAR_BILL) > 0);
        if (result) {
            this.numberOfFiftyDollarBills -= currentNumberOfFiftyDollarBills;
            this.numberOfTwentyDollarBills -= currentNumberOfTwentyDollarBills;
            this.numberOfTenDollarBills -= currentNumberOfTenDollarBills;
        }
        if (currentNumberOfFiftyDollarBills > 0) {
            printStatus(currentNumberOfFiftyDollarBills, DENOMINATION_OF_FIFTY_DOLLAR_BILL);
        }
        if (currentNumberOfTwentyDollarBills > 0) {
            printStatus(currentNumberOfTwentyDollarBills, DENOMINATION_OF_TWENTY_DOLLAR_BILL);
        }
        if (currentNumberOfTenDollarBills > 0) {
            printStatus(currentNumberOfTenDollarBills, DENOMINATION_OF_TEN_DOLLAR_BILL);
        }
        return result;
    }

    private void printStatus(int numberOfBills, int denomination) {
        System.out.println("номинал = " + denomination + " долларов, количество купюр = " + numberOfBills);
    }

    private int getAmountOfMoney() {
        return numberOfTenDollarBills * DENOMINATION_OF_TEN_DOLLAR_BILL +
                numberOfTwentyDollarBills * DENOMINATION_OF_TWENTY_DOLLAR_BILL +
                numberOfFiftyDollarBills * DENOMINATION_OF_FIFTY_DOLLAR_BILL;
    }

    public int getNumberOfTenDollarBills() {
        return numberOfTenDollarBills;
    }

    public void setNumberOfTenDollarBills(int numberOfTenDollarBills) {
        this.numberOfTenDollarBills = numberOfTenDollarBills;
    }

    public int getNumberOfTwentyDollarBills() {
        return numberOfTwentyDollarBills;
    }

    public void setNumberOfTwentyDollarBills(int numberOfTwentyDollarBills) {
        this.numberOfTwentyDollarBills = numberOfTwentyDollarBills;
    }

    public int getNumberOfFiftyDollarBills() {
        return numberOfFiftyDollarBills;
    }

    public void setNumberOfFiftyDollarBills(int numberOfFiftyDollarBills) {
        this.numberOfFiftyDollarBills = numberOfFiftyDollarBills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atm atm = (Atm) o;
        return numberOfTenDollarBills == atm.numberOfTenDollarBills && numberOfTwentyDollarBills == atm.numberOfTwentyDollarBills && numberOfFiftyDollarBills == atm.numberOfFiftyDollarBills;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfTenDollarBills, numberOfTwentyDollarBills, numberOfFiftyDollarBills);
    }

    @Override
    public String toString() {
        return "Atm{" +
                "number of ten dollar bills = " + numberOfTenDollarBills +
                ", number of twenty dollar bills = " + numberOfTwentyDollarBills +
                ", number of fifty dollar bills = " + numberOfFiftyDollarBills +
                '}';
    }
}
