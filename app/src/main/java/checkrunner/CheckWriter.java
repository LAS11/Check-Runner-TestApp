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
	
	//TODO: цифры при выводе в файл не округляются, исправить
	public void addItem(String[] s, FileWriter fw) throws Exception  {
		/*
			s[0] - количество товара
			s[1] - название товара
			s[2] - цена за единицу товара
			s[3] - цена за весь товар
			s[4] - является ли автор акционным
		*/
		
		fw.write(s[0] + " " + s[1] + " " + s[2] + " " + s[3] + " " + "\n");
		if (s[4] == "1" && Integer.parseInt(s[0]) >= ProductsDB.getPromoCount()) {
			double priceWithPromoDiscount = Double.parseDouble(s[3]) * ProductsDB.getPromoDiscountMultiplier();
			fw.write("(акция! 10шт товара = скидка -10%: " + priceWithPromoDiscount + "\n");
		}
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
	
	public void addTotalDiscounted(String s, FileWriter fw) throws Exception {
		fw.write(s + "\n");
	}
	
	public void addDiscountCard(String s, FileWriter fw) throws Exception {
		fw.write(s + "\n");
	}
	
	public void addDiscountPercent(String s, FileWriter fw) throws Exception {
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