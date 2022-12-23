package checkrunner;

import checkrunner.CheckBuilder;
import java.io.*;

class CheckBuilderDefault implements CheckBuilder  {
	
	public void printGreetingLine(String s) {
		System.out.printf("%30s\n", s);
	}
	
	public void printCashReceiptTitle(String s) {
		System.out.printf("%33s\n", s);
	}
	
	public void printStoreAddress(String s) {
		System.out.printf("%37s\n", s);
	}
	
	public void printStoreName(String s) {
		System.out.printf("%33s\n", s);
	}
	
	public void printStorePhone(String s) {
		System.out.printf("%29s\n", s);
	}
	
	public void printIEData(String s) {
		System.out.println(s);
	}
	
	public void printCashierName(String s) {
		System.out.println(s);
	}
	
	public void printDayPurchase(String s) {
		System.out.println(s);
	}

	public void printTimePurchase(String s) {
		System.out.println(s);
	}

	public void printHeaderList(String s) {
		String[] headers = s.split(" ");
		System.out.printf("%3s  %-15s %16s %6s%n", headers[0], headers[1], headers[2], headers[3]);
	}

	public void printItem(String[] s) {
		System.out.printf("%3s     %-27s %-3s %6s%n", s[0], s[1], s[2], s[3]);
	}

	public void printTax(String s) {
		System.out.println(s);
	}

	public void printTotalWithoutTax(String s) {
		String[] total = s.split(" ");
		System.out.printf("%s %40s%n", total[0], total[1]);
	}

	public void printTaxTotal(String s) {
		System.out.println(s);
	}

	public void printEmptyLine() {
		System.out.println("");
	}

	public void printDividerLine(String s) {
		System.out.println(s);
	}
	
	public void printThanksLine(String s) {
		System.out.printf("%33s%n", s);
	}
	
	public void writeGreetingLine(String s, FileWriter fw) throws Exception {
		fw.write(s + "\n");
	}
	
	public void writeCashReceiptTitle(String s, FileWriter fw) throws Exception {
		fw.write(s + "\n");
	}
	
	public void writeStoreName(String s, FileWriter fw) throws Exception {
		fw.write(s + "\n");
	}
	
	public void writeStoreAddress(String s, FileWriter fw) throws Exception {
		fw.write(s + "\n");
	}
	
	public void writeIEData(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}
	
	public void writeStorePhone(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}
	
	public void writeCashierName(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}
	
	public void writeDayPurchase(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}

	public void writeTimePurchase(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}

	public void writeHeaderList(String s, FileWriter fw) throws Exception  {
		String[] headers = s.split(" ");
		fw.write(headers[0] + " " + headers[1] + " " + headers[2] + " " + headers[3] + " " + "\n");
	}

	public void writeItem(String[] s, FileWriter fw) throws Exception  {
		fw.write(s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + "\n");
	}

	public void writeTax(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}

	public void writeTotalWithoutTax(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}

	public void writeTaxTotal(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}

	public void writeEmptyLine(FileWriter fw) throws Exception  {
		fw.write("\n");
	}

	public void writeDividerLine(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}
	
	public void writeThanksLine(String s, FileWriter fw) throws Exception  {
		fw.write(s + "\n");
	}
	
	
}