package PayRoll;

public class Transac {
    private String type; // SALE / EXPENSE / SALARY
    private double amount;

    public Transac(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + " : " + amount;
    }
}