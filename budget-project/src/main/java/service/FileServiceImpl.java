package service;

import model.ExpensesRecord;
import model.IncomeRecord;
import model.Record;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FileServiceImpl implements FileService {
    private String FILE_PATH = "src/budgetFile.csv";
    private Budget budget = new Budget();

    @Override
    public void writeDataToFile(Map<Integer, Record> recordList) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        recordList.forEach((integer, record) -> {
            try {
                bufferedWriter.write(integer.toString());
                bufferedWriter.write(",");
                if (record instanceof ExpensesRecord) {
                    BigDecimal moneyAmmount = record.getAmount().negate();
                    bufferedWriter.write(moneyAmmount.toString());
                }
                bufferedWriter.write(",");
                bufferedWriter.write(record.getRecordDate().toString());
                bufferedWriter.write(",");
                bufferedWriter.write(record.getRecordDescription());
                bufferedWriter.write(",");
                if (record instanceof ExpensesRecord) {
                    bufferedWriter.write((((ExpensesRecord) record).getExpenseCategory()));
                }
                if (record instanceof IncomeRecord) {
                    bufferedWriter.write((((IncomeRecord) record).getIncomeCategory()));
                }
                bufferedWriter.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bufferedWriter.close();
    }

    public Map<Integer, Record> readDataFromFile() throws IOException {
        Map<Integer, Record> recordList = budget.getRecords();
        FileReader fileReader = new FileReader(FILE_PATH);
        String line = "";
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            try {
                String[] values = line.split(",");
                Integer id = Integer.valueOf(values[0]);
                BigDecimal amountOfMoney = BigDecimal.valueOf(Long.parseLong(values[1]));
                LocalDate date = LocalDate.parse(values[2]);
                String description = values[3];
                String category = values[4];
                if (amountOfMoney.longValue() < 0) {
                    Record record = new ExpensesRecord(amountOfMoney.abs(), date, description, category);
                    recordList.put(id, record);
                } else {
                    Record record = new IncomeRecord(amountOfMoney, date, description, category);
                    recordList.put(id, record);
                }

            } catch (NumberFormatException ex) {

            }
        }
        bufferedReader.close();
        return recordList;
    }
}


