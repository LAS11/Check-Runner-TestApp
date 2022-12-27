package checkrunner;

import java.io.*;

public class CheckWriter implements CheckBuilder  {
	
	public void addGreetingLine(String s, FileWriter fw) throws Exception {
		fw.write(s + "\n");
	}
	
	public void addCashReceiptTitle(String s, FileWriter fw) throws Exception {
		fw.write(s + "\n");
	}
	
	public void addStoreName(String s, FileWriter fw) throws Exception {
		fw.write(s + "\n");
	}
	
	public void addStoreAddress(String s, FileWriter fw) throws Exception {
		fw.write(s + "\n");
	}
	
	public void addIEData(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}
	
	public void addStorePhone(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}
	
	public void addCashierName(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}
	
	public void addDayPurchase(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}

	public void addTimePurchase(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}

	public void addHeaderList(String s, FileWriter fw) throws Exception  {
		String[] headers = s.split(" ");
		fw.write(headers[0] + " " + headers[1] + " " + headers[2] + " " + headers[3] + " " + "\n");
	}

	public void addItem(String[] s, FileWriter fw) throws Exception  {
		fw.write(s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + "\n");
	}

	public void addTax(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}

	public void addTotalWithoutTax(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}

	public void addTaxTotal(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}

	public void addEmptyLine(FileWriter fw) throws Exception  {
		fw.write("\n");
	}

	public void addDividerLine(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}
	
	public void addThanksLine(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}
}