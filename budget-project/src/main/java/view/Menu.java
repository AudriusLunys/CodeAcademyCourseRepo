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
                "3 - get all income records" + '\n' +
                "4 - get all expense records" + '\n' +
                "5 - delete income record by ID" + '\n' +
                "6 - delete expense record by ID" + '\n' +
                "7 - get balance" + '\n' +
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
                    budget.printIncomeList();
                    break;

                case 4:
                    budget.printExpensesList();
                    break;

                case 5:
                    budget.deleteIncomeRecordById();
                    break;

                case 6:
                    budget.deleteExpensesRecordById();
                    break;

                case 7:
                     printService.print("current balance: "+ budget.checkBalance() +" of money");
                    break;

                default:
                    System.out.println("something went wrong");
                    break;
            }
        } while (userChoice != 0);

    }

}


