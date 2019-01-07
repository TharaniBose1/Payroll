package com.cg.payroll.beans;

public class Salary {
	private int basicSalary,hra,conveyenceAllowance,otherAllowance,personalAllowance,monthlyTax,epf,companyPf,gratuity,monthlygrossSalary,annualGrossSalary,yearlyTax,taxableAmount,netSalary;
public Salary() {
}
public Salary(int basicSalary, int epf, int companyPf) {
	super();
	this.basicSalary = basicSalary;
	this.epf = epf;
	this.companyPf = companyPf;
}
public int getBasicSalary() {
	return basicSalary;
}
public void setBasicSalary(int basicSalary) {
	this.basicSalary = basicSalary;
}
public int getEpf() {
	return epf;
}
public void setEpf(int epf) {
	this.epf = epf;
}
public int getCompanyPf() {
	return companyPf;
}
public void setCompanyPf(int companyPf) {
	this.companyPf = companyPf;
}
public int getHra() {
	return hra;
}
public void setHra(int hra) {
	this.hra = hra;
}
public int getConveyenceAllowance() {
	return conveyenceAllowance;
}
public void setConveyenceAllowance(int conveyenceAllowance) {
	this.conveyenceAllowance = conveyenceAllowance;
}
public int getOtherAllowance() {
	return otherAllowance;
}
public void setOtherAllowance(int otherAllowance) {
	this.otherAllowance = otherAllowance;
}
public int getPersonalAllowance() {
	return personalAllowance;
}
public void setPersonalAllowance(int personalAllowance) {
	this.personalAllowance = personalAllowance;
}

public int getTaxableAmount() {
	return taxableAmount;
}
public void setTaxableAmount(int taxableAmount) {
	this.taxableAmount = taxableAmount;
}
public int getMonthlyTax() {
	return monthlyTax;
}
public void setMonthlyTax(int monthlyTax) {
	this.monthlyTax = monthlyTax;
}
public int getYearlyTax() {
	return yearlyTax;
}
public void setYearlyTax(int yearlyTax) {
	this.yearlyTax = yearlyTax;
}
public int getGratuity() {
	return gratuity;
}
public void setGratuity(int gratuity) {
	this.gratuity = gratuity;
}
public int getMonthlygrossSalary() {
	return monthlygrossSalary;
}
public void setMonthlygrossSalary(int monthlygrossSalary) {
	this.monthlygrossSalary = monthlygrossSalary;
}
public int getAnnualGrossSalary() {
	return annualGrossSalary;
}
public void setAnnualGrossSalary(int annualGrossSalary) {
	this.annualGrossSalary = annualGrossSalary;
}
public int getNetSalary() {
	return netSalary;
}
public void setNetSalary(int netSalary) {
	this.netSalary = netSalary;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + annualGrossSalary;
	result = prime * result + basicSalary;
	result = prime * result + companyPf;
	result = prime * result + conveyenceAllowance;
	result = prime * result + epf;
	result = prime * result + gratuity;
	result = prime * result + hra;
	result = prime * result + monthlyTax;
	result = prime * result + monthlygrossSalary;
	result = prime * result + netSalary;
	result = prime * result + otherAllowance;
	result = prime * result + personalAllowance;
	result = prime * result + taxableAmount;
	result = prime * result + yearlyTax;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Salary other = (Salary) obj;
	if (annualGrossSalary != other.annualGrossSalary)
		return false;
	if (basicSalary != other.basicSalary)
		return false;
	if (companyPf != other.companyPf)
		return false;
	if (conveyenceAllowance != other.conveyenceAllowance)
		return false;
	if (epf != other.epf)
		return false;
	if (gratuity != other.gratuity)
		return false;
	if (hra != other.hra)
		return false;
	if (monthlyTax != other.monthlyTax)
		return false;
	if (monthlygrossSalary != other.monthlygrossSalary)
		return false;
	if (netSalary != other.netSalary)
		return false;
	if (otherAllowance != other.otherAllowance)
		return false;
	if (personalAllowance != other.personalAllowance)
		return false;
	if (taxableAmount != other.taxableAmount)
		return false;
	if (yearlyTax != other.yearlyTax)
		return false;
	return true;
}



}
