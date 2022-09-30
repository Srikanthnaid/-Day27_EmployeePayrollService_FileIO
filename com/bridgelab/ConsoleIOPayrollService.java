package com.bridgelab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ConsoleIOPayrollService implements PayrollService {

    @Override
    public boolean writePayrollData(List<EmployPayrollData> employList) {
        System.out.println("Given Employee Data is : " + employList);
        return false;
    }

    @Override
    public void readPayrollData() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc1.nextLine();
        System.out.println("Enter your Id: ");
        int id = sc1.nextInt();
        System.out.println("Enter your salary: ");
        double salary = sc1.nextDouble();
        employList = new ArrayList<>();
        EmployPayrollData empData = new EmployPayrollData(id, name, salary);
//    adding all employee data to the arraylist
        employList.add(empData);
    }

    @Override
    public long countEntries() throws IOException {
        return new FileIOPayrollService().countEntries();
    }
}