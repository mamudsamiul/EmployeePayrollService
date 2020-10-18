package com.capgemini.employeepayrollservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO;
	}

	private List<EmployeePayrollData> employeeList;

	public EmployeePayrollService() {

	}

	public EmployeePayrollService(List<EmployeePayrollData> employeeList) {

		this.employeeList = employeeList;
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeeList = new ArrayList<>();
		EmployeePayrollService empService = new EmployeePayrollService(employeeList);
		Scanner sc = new Scanner(System.in);
		empService.readData(sc);
		empService.writeData(IOService.CONSOLE_IO);
	}

	private void readData(Scanner sc) {
		System.out.println("Enter ID: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Enter name: ");
		String name = sc.next();
		System.out.println("Enter Salary: ");
		Double salary = sc.nextDouble();
		employeeList.add(new EmployeePayrollData(id, name, salary));
	}

	public void writeData(IOService ioService) {
		if (ioService.equals(IOService.CONSOLE_IO))
			System.out.println("Writing Employee Payroll Data to Console\n" + employeeList);
		else if (ioService.equals(IOService.FILE_IO))
			new EmployeePayrollFileIOOperations().writeEmployeePayrollData(employeeList);
	}

	public long countEntries(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO))
			return new EmployeePayrollFileIOOperations().countNoOfEntries();
		return 0;
	}

	public void printData(IOService ioService) {
		new EmployeePayrollFileIOOperations().printEmployeePayrollData();
	}
}