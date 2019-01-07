package com.cg.payroll.services;
import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
public interface PayrollServices {
int acceptAssociateDetails(int yearlyInvestmentUnder80C, String firstName, String lastName, String department,
		String designation, String pancard, String emailId, Salary salary, BankDetails bankDetails);
int  calculateNetSalary(int associateID)throws AssociateDetailsNotFoundException;
Associate getAssociateDetails(int associateID)throws AssociateDetailsNotFoundException;
 List<	Associate> getAllAssociatesDetails();
}
