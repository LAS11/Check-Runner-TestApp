package checkrunner;

import java.io.FileWriter;

interface CheckBuilder {
	default void addGreetingLine(String s) {
		System.out.println(s);
	}
	default void addCashReceiptTitle(String s) {
		System.out.println(s);
	}
	default void addStoreName(String s) {
		System.out.println(s);
	}
	default void addStoreAddress(String s) {
		System.out.println(s);
	}
	default void addStorePhone(String s)  {
		System.out.println(s);
	}
	
	default void addIEData(String s) {
		System.out.println(s);
	}
	default void addCashierName(String s) {
		System.out.println(s);
	}
	default void addDayPurchase(String s) {
		System.out.println(s);
	}
	default void addTimePurchase(String s) {
		System.out.println(s);
	}
	
	default void addHeaderList(String s) {
		System.out.println(s);
	}
	default void addItem(String[] s) {
		System.out.println(s);
	}
	default void addTax(String s) {
		System.out.println(s);
	}
	default void addTotalWithoutTax(String s) {
		System.out.println(s);
	}
	default void addTaxTotal(String s) {
		System.out.println(s);
	}
	default void addEmptyLine() {
		System.out.println();
	}
	default void addDividerLine(String s) {
		System.out.println(s);
	}
	default void addThanksLine(String s) {
		System.out.println(s);
	}

}