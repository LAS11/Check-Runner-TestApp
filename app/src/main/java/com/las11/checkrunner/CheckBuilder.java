package com.las11.checkrunner;

import java.io.FileWriter;

interface CheckBuilder {
	void writeGreetingLine(String s, FileWriter fw) throws Exception;
	void writeCashReceiptTitle(String s, FileWriter fw) throws Exception;
	
	void writeStoreName(String s, FileWriter fw) throws Exception;
	void writeStoreAddress(String s, FileWriter fw) throws Exception;
	void writeStorePhone(String s, FileWriter fw) throws Exception;
	
	void writeIEData(String s, FileWriter fw) throws Exception;
	void writeCashierName(String s, FileWriter fw) throws Exception;
	void writeDayPurchase(String s, FileWriter fw) throws Exception;
	void writeTimePurchase(String s, FileWriter fw) throws Exception;
	
	void writeHeaderList(String s, FileWriter fw) throws Exception;
	void writeItem(String[] s, FileWriter fw) throws Exception;
	void writeTax(String s, FileWriter fw) throws Exception;
	void writeTotalWithoutTax(String s, FileWriter fw) throws Exception;
	void writeTaxTotal(String s, FileWriter fw) throws Exception;
	
	void writeEmptyLine(FileWriter fw) throws Exception;
	void writeDividerLine(String s, FileWriter fw) throws Exception;
	void writeThanksLine(String s, FileWriter fw) throws Exception;
	
	void printGreetingLine(String s);
	void printCashReceiptTitle(String s);
	
	void printStoreName(String s);
	void printStoreAddress(String s);
	void printStorePhone(String s);
	
	void printIEData(String s);
	void printCashierName(String s);
	void printDayPurchase(String s);
	void printTimePurchase(String s);
	
	void printHeaderList(String s);
	void printItem(String[] s);
	void printTax(String s);
	void printTotalWithoutTax(String s);
	void printTaxTotal(String s);
	
	void printEmptyLine();
	void printDividerLine(String s);
	void printThanksLine(String s);
	
}