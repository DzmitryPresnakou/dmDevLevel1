package com.presnakou.cycles;

/**
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 * <p>
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 * <p>
 * Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
 */
public class Task3 {

    private final static int MONTH_IN_YEAR = 12;

    public static void main(String[] args) {

        double salary = 600;
        double salaryIncrease = 400;

        int salaryIncreasePeriodMonth = 6;

        double expenses = 300;
        double investmentPercent = 10;
        double profitPercent = 2;

        int targetPeriodYear = 3;
        int targetPeriodMonth = 2;
        int targetNumberOfMonths = getPeriodInMonth(targetPeriodYear, targetPeriodMonth);

        double privateAccount = getAccount(targetNumberOfMonths, salary, salaryIncrease, salaryIncreasePeriodMonth,
                expenses, investmentPercent);
        double brokerAccount = getBrokerAccount(targetNumberOfMonths, salary, salaryIncrease, salaryIncreasePeriodMonth,
                investmentPercent, profitPercent);

        System.out.println("На своем счету за " + targetPeriodYear + " года и " + targetPeriodMonth + " месяца Ваня будет иметь: " + privateAccount + "$");
        System.out.println("На счету брокера за " + targetPeriodYear + " года и " + targetPeriodMonth + " месяца Ваня будет иметь: " + brokerAccount + "$");

    }

    private static double getBrokerAccount(int targetNumberOfMonths, double salary, double salaryIncrease,
                                           int salaryIncreasePeriodMonth, double investmentPercent, double profitPercent) {
        int currentMonth = 1;
        double result = 0;
        while (currentMonth <= targetNumberOfMonths) {
            salary += (currentMonth > 0 && currentMonth % salaryIncreasePeriodMonth == 0) ? salaryIncrease : 0;
            result += salary * investmentPercent / 100;
            result += (currentMonth > 1) ? result * profitPercent / 100 : 0;
            currentMonth++;
        }

        return result;
    }

    private static double getAccount(int targetNumberOfMonths, double salary, double salaryIncrease,
                                     int salaryIncreasePeriodMonth, double expenses, double investmentPercent) {
        int currentMonth = 1;
        double result = 0;

        while (currentMonth <= targetNumberOfMonths) {
            salary += (currentMonth > 0 && currentMonth % salaryIncreasePeriodMonth == 0) ? salaryIncrease : 0;
            result += getMonthlyDeposit(salary, expenses, investmentPercent);
            currentMonth++;
        }
        return result;
    }

    private static double getMonthlyDeposit(double salary, double expenses, double investmentPercent) {
        return salary - expenses - salary * investmentPercent / 100;
    }

    private static int getPeriodInMonth(int year, int month) {
        return month + year * MONTH_IN_YEAR;
    }
}
