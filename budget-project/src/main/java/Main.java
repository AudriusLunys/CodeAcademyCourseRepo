import model.IncomeRecord;
import service.Budget;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      Budget budget = new Budget();
      IncomeRecord i1 = budget.addIncomeRecord();
      IncomeRecord[] ir =  budget.addRecordToIncomeList(i1);
        System.out.println(budget.getIncomeRecord(ir));






       //Scanner scanner = new Scanner(System.in);
      //  IncomeRecord incomeRecord = new IncomeRecord();
      //  String date=scanner.nextLine();
      //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      //  LocalDate localDate = LocalDate.parse(date,formatter);
     //   incomeRecord.setIncomeDate(localDate);

      //  System.out.println(incomeRecord.toString());





    }
}
