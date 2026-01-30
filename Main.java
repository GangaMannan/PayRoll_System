package PayRoll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FundMng fund = new FundMng(3000000);
        PayLogic payroll = new PayLogic(fund);

        int choice;

        do {
            System.out.println("\n------ COMPANY PAYROLL SYSTEM ------");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. View Employees");
            System.out.println("4. Add Sale");
            System.out.println("5. Add Expense");
            System.out.println("6. View Transactions");
            System.out.println("7. View Company Balance");
            System.out.println("8. Process Salary");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("1. Full-Time Employee");
                    System.out.println("2. Part-Time Employee");
                    int type = sc.nextInt();

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    if (type == 1) {
                        System.out.print("Enter Monthly Salary: ");
                        double salary = sc.nextDouble();
                        payroll.addEmployee(new FT_Emp(id, name, salary));
                    } else {
                        System.out.print("Enter Hours Worked: ");
                        int hours = sc.nextInt();
                        System.out.print("Enter Hourly Rate: ");
                        double rate = sc.nextDouble();
                        payroll.addEmployee(new PT_Emp(id, name, hours, rate));
                    }

                    System.out.println(" Employee Added");
                    break;

                case 2:
                    System.out.print("Enter Employee ID to Remove: ");
                    int removeId = sc.nextInt();
                    payroll.removeEmployee(removeId);
                    System.out.println(" Employee Removed");
                    break;

                case 3:
                    payroll.listEmployees();
                    break;

                case 4:
                    System.out.print("Enter Sale Amount: ");
                    fund.addIncome(sc.nextDouble());
                    System.out.println(" Sale Added");
                    break;

                case 5:
                    System.out.print("Enter Expense Amount: ");
                    fund.addExpense(sc.nextDouble());
                    System.out.println(" Expense Added");
                    break;

                case 6:
                    System.out.println("\n--- Transactions ---");
                    for (Transac t : fund.getTransactions()) {
                        System.out.println(t);
                    }
                    break;

                case 7:
                    System.out.println(" Company Balance: " + fund.getBalance());
                    break;

                case 8:
                    payroll.processSalary();
                    break;

                case 0:
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("******Invalid Choice******");
            }

        } while (choice != 0);

        sc.close();
    }
}
