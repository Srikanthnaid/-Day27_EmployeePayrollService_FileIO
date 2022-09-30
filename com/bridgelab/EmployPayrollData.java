package com.bridgelab;

public class EmployPayrollData {
	private int id;
	private String name;
	private double salary;

	public EmployPayrollData(int id2, double salary2, String name2) {
	}

	public EmployPayrollData(int id, String name, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployPayrollData{" + "Id=" + id + ", Name='" + name + '\'' + ", Salary=" + salary + '}';
	}
}