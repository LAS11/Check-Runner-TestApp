package checkrunner;

import java.io.*;

public class CheckWriter implements CheckBuilder  {
	
	public void addGreetingLine(String s, FileWriter fw) throws Exception {
		String greetings = String.format("%30s\n", s);
		fw.write(greetings);
	}
	
	public void addCashReceiptTitle(String s, FileWriter fw) throws Exception {
		String title = String.format("%33s\n", s);
		fw.write(title);
	}
	
	public void addStoreName(String s, FileWriter fw) throws Exception {
		String storeName = String.format("%33s\n", s);
		fw.write(storeName);
	}
	
	public void addStoreAddress(String s, FileWriter fw) throws Exception {
		String address = String.format("%37s\n", s);
		fw.write(address);
	}
	
	public void addIEData(String s, FileWriter fw) throws Exception  {
		String IEData = String.format("%s\n", s);
		fw.write(IEData);
	}
	
	public void addStorePhone(String s, FileWriter fw) throws Exception  {
		String phone = String.format("%29s\n", s);
		fw.write(phone);
	}
	
	public void addCashierName(String s, FileWriter fw) throws Exception  {
		String cashierName = String.format("%s\n", s);
		fw.write(cashierName);
	}
	
	public void addDayPurchase(String s, FileWriter fw) throws Exception  {
		String dayOfPurchase = String.format("%s\n", s);
		fw.write(dayOfPurchase);
	}

	public void addTimePurchase(String s, FileWriter fw) throws Exception  {
		String timeOfPurchase = String.format("%s\n", s);
		fw.write(timeOfPurchase);
	}

	public void addHeaderList(String s, FileWriter fw) throws Exception  {
		String[] headers = s.split(" ");
		String head = String.format("%3s  %-15s %16s %6s\n", headers[0], headers[1], 
															headers[2], headers[3]);
		fw.write(head);
	}
	
	public void addItem(String[] s, FileWriter fw) throws Exception  {
		/*
			s[0] - количество товара
			s[1] - название товара
			s[2] - цена за единицу товара
			s[3] - цена за весь товар
			s[4] - является ли автор акционным
		*/
		String item = String.format("%3s     %-27s %-3s %6.02f\n", s[0], s[1], s[2], Double.parseDouble(s[3])).replace(',', '.');
		fw.write(item);
		
		if (Integer.parseInt(s[4]) == 1 && Integer.parseInt(s[0]) >= ProductsDB.getPromoCount()) {
			double priceWithPromoDiscount = Double.parseDouble(s[3]) * ProductsDB.getPromoDiscountMultiplier();
			String promo = String.format("Акция! 10шт товара = скидка -10%% %14.05s\n\n", priceWithPromoDiscount);
			fw.write(promo);
		}
	}

	public void addTax(String s, FileWriter fw) throws Exception  {
		String tax = String.format("%s\n", s);
		fw.write(tax);
	}

	public void addTotalWithoutTax(String s, FileWriter fw) throws Exception  {
		String[] total = s.split(" ");
		String totalStr = String.format("%s %40.02f\n", total[0], Double.parseDouble(total[1])).replace(',', '.');
		fw.write(totalStr);
	}

	public void addTaxTotal(String s, FileWriter fw) throws Exception  {
		String taxTotal = String.format("%s\n", s);
		fw.write(taxTotal);
	}
	
	public void addTotalDiscounted(String s, FileWriter fw) throws Exception {
		int dividerIndex = s.indexOf(":") + 1;
		double price = Double.parseDouble(s.substring(dividerIndex));
		String text = s.substring(0, dividerIndex);
		String totalStr = String.format("%s%20.02f\n", text, price).replace(',', '.');
		
		fw.write(totalStr);
	}
	
	public void addDiscountCard(String s, FileWriter fw) throws Exception {
		int dividerIndex = s.indexOf("№") + 1;
		
		int code = Integer.parseInt(s.substring(dividerIndex));
		String text = s.substring(0, dividerIndex);
		
		String discountCard = String.format("%s%04d\n", text, code);
		
		fw.write(discountCard);
	}
	
	public void addDiscountPercent(String s, FileWriter fw) throws Exception {
		String discountPercent = String.format("%s\n", s);
		fw.write(discountPercent);
	}

	public void addEmptyLine(FileWriter fw) throws Exception  {
		fw.write("\n");
	}

	public void addDividerLine(String divider, FileWriter fw) throws Exception  {
		fw.write(divider + "\n");
	}
	
	public void addThanksLine(String s, FileWriter fw) throws Exception  {
		String thanks = String.format("%33s\n", s);
		fw.write(thanks);
	}
}