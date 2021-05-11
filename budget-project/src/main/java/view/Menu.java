package view;

import model.ExpensesRecord;
import model.IncomeRecord;
import service.Budget;
import service.PrintService;

import java.util.Scanner;

public class Menu {

    private PrintService printService = new PrintService();
    private Budget budget = new Budget();
    private Scanner scanner = new Scanner(System.in);


    private void displayMenu() {
        printService.print("**** Budget App Menu ***" + '\n' +
                "1 - add income" + '\n' +
                "2 - add expense" + '\n' +
                "3 - get income record by id" + '\n' +
                "4 - get expense record by id" + '\n' +
                "0 - exit program " + '\n' +
                "please enter your choice "
        );
    }

    public void run() {

        int userChoice;
        do {
            displayMenu();
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    IncomeRecord incomeRecord = budget.addIncomeRecord();
                    budget.addRecordToIncomeList(incomeRecord);
                    break;

                case 2:
                    ExpensesRecord expensesRecord = budget.addExpenseRecord();
                    budget.addRecordToExpensesList(expensesRecord);
                    break;

                case 3:
                    System.out.println(budget.getIncomeRecordByIndex());
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println(budget.getExpensesRecordByIndex());
                    scanner.nextLine();
                    break;

            }
        } while (userChoice != 0);

    }

}


