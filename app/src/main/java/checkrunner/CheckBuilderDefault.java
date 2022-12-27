package checkrunner;

import java.io.*;

class CheckBuilderDefault implements CheckBuilder  {
	
	public void addGreetingLine(String s) {
		System.out.printf("%30s\n", s);
	}
	
	public void addCashReceiptTitle(String s) {
		System.out.printf("%33s\n", s);
	}
	
	public void addStoreAddress(String s) {
		System.out.printf("%37s\n", s);
	}
	
	public void addStoreName(String s) {
		System.out.printf("%33s\n", s);
	}
	
	public void addStorePhone(String s) {
		System.out.printf("%29s\n", s);
	}
	
	public void addIEData(String s) {
		System.out.println(s);
	}
	
	public void addCashierName(String s) {
		System.out.println(s);
	}
	
	public void addDayPurchase(String s) {
		System.out.println(s);
	}

	public void addTimePurchase(String s) {
		System.out.println(s);
	}

	public void addHeaderList(String s) {
		String[] headers = s.split(" ");
		System.out.printf("%3s  %-15s %16s %6s%n", headers[0], headers[1], headers[2], headers[3]);
	}

	public void addItem(String[] s) {
		System.out.printf("%3s     %-27s %-3s %6s%n", s[0], s[1], s[2], s[3]);
	}

	public void addTax(String s) {
		System.out.println(s);
	}

	public void addTotalWithoutTax(String s) {
		String[] total = s.split(" ");
		System.out.printf("%s %40s%n", total[0], total[1]);
	}

	public void addTaxTotal(String s) {
		System.out.println(s);
	}

	public void addEmptyLine() {
		System.out.println("");
	}

	public void addDividerLine(String s) {
		System.out.println(s);
	}
	
	public void addThanksLine(String s) {
		System.out.printf("%33s%n", s);
	}
}