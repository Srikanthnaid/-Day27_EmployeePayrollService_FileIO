package com.bridgelab;

import java.io.IOException;
import java.util.List;

public interface PayrollService {
	boolean writePayrollData(List<EmployPayrollData> employeeList) throws IOException;

	void readPayrollData() throws IOException;

	long countEntries() throws IOException;

}
