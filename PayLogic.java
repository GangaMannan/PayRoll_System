package PayRoll;

import java.time.LocalDate;
import java.util.ArrayList;

public class PayLogic {
    private ArrayList<Employee> employees;
    private FundMng fund;

    public PayLogic(FundMng fund) {
        this.employees = new ArrayList<>();
        this.fund = fund;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void removeEmployee(int empId) {
        employees.removeIf(emp -> emp.empId == empId);
    }

    public void listEmployees() {
        for (Employee emp : employees) {
            System.out.println(emp.empId + " - " + emp.getName());
        }
    }

    public void processSalary() {
        LocalDate today = LocalDate.now();

        if (today.getDayOfMonth() != 5) {
            System.out.println(" Salary can only be processed on 5th.");
            return;
        }

        double totalSalary = 0;
        for (Employee emp : employees) {
            totalSalary += emp.calculateSalary();
        }

        if (fund.getBalance() >= totalSalary) {
            fund.addSalaryExpense(totalSalary);
            System.out.println(" Salary Paid: ₹" + totalSalary);
        } else {
            System.out.println(" Insufficient funds!");
        }
    }
}
