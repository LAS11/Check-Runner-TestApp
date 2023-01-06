package checkrunner;

import java.io.*;

public class CheckBuilderDefault implements CheckBuilder  {
	
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
		System.out.printf("%3s  %-15s %16s %6s%n", headers[0], headers[1], 
													headers[2], headers[3]);
	}

	public void addItem(String[] s) {
		/*
			s[0] - количество товара
			s[1] - название товара
			s[2] - цена за единицу товара
			s[3] - цена за весь товар
			s[4] - является ли автор акционным
		*/

		String item = String.format("%3s     %-27s %-3s %6.02f", s[0], s[1], s[2], Double.parseDouble(s[3])).replace(',', '.');
		System.out.println(item);
		
		if (Integer.parseInt(s[4]) == 1 && Integer.parseInt(s[0]) >= ProductsDB.getPromoCount()) {
			double priceWithPromoDiscount = Double.parseDouble(s[3]) * ProductsDB.getPromoDiscountMultiplier();
			System.out.printf("Акция! 10шт товара = скидка -10%% %14s%n", priceWithPromoDiscount);
			System.out.println();
		}
	}

	public void addTax(String s) {
		System.out.println(s);
	}

	public void addTotalWithoutTax(String s) {
		String[] total = s.split(" ");
		String totalStr = String.format("%s %40.02f", total[0], Double.parseDouble(total[1])).replace(',', '.');
		System.out.println(totalStr);
	}

	public void addTaxTotal(String s) {
		System.out.println(s);
	}
	
	public void addTotalDiscounted(String s) {
		int dividerIndex = s.indexOf(":") + 1;
		double price = Double.parseDouble(s.substring(dividerIndex));
		String text = s.substring(0, dividerIndex);
		String totalStr = String.format("%s%20.02f", text, price).replace(',', '.');

		System.out.println(totalStr);
	}
	
	public void addDiscountCard(String s) {
		int dividerIndex = s.indexOf("№") + 1;
		
		int code = Integer.parseInt(s.substring(dividerIndex));
		String text = s.substring(0, dividerIndex);
		
		System.out.printf("%s%04d%n", text, code);
	}
	
	public void addDiscountPercent(String s) {
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