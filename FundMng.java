package PayRoll;

import java.util.ArrayList;

public class FundMng {
    private double balance;
    private ArrayList<Transac> transactions;

    public FundMng(double initialBalance) {
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public void addIncome(double amount) {
        balance += amount;
        transactions.add(new Transac("SALE", amount));
    }

    public void addExpense(double amount) {
        balance -= amount;
        transactions.add(new Transac("EXPENSE", amount));
    }

    public void addSalaryExpense(double amount) {
        balance -= amount;
        transactions.add(new Transac("SALARY", amount));
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transac> getTransactions() {
        return transactions;
    }
}
