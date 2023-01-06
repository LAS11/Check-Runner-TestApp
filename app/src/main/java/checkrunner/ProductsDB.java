package checkrunner;

import java.io.*;
import java.util.*;

public class ProductsDB {
		
	private static final int promoCount = 10;
	private static final int promoDiscount = 10; //в процентах
	private static final int lineLength = 3;
	
	private static File productsDatabase;
	private static Scanner productsScanner;
	private static String[][] products;
	
	//TODO: маркер переносится на первый взгляд корректно
	//но впоследствии он везде не проходит сравнение с "1"
	//для чего его приходится всюду преобразовывать в Int и обратно
	//разобраться, в чём дело
	public static boolean setProductsDatabase(String path) {
		if (path != "") {
			productsDatabase = new File(path);
			if (productsDatabase.exists() && productsDatabase.isFile()) {
				products = new String[countLines()][lineLength];
				try {
					productsScanner = new Scanner(new BufferedReader(new FileReader(productsDatabase)));
					int i = 0;
					while (productsScanner.hasNextLine()) {
						products[i][0] = "";
						
						//последними всегда идут маркер акционности товара
						//и его цена за единицу
						//остальное - имя
						String[] line = productsScanner.nextLine().split(" ");
						
						for (int j = 0; j < line.length - 2; j++) {
							products[i][0] += line[j] + " ";		
						}
						products[i][0] = products[i][0].substring(0, products[i][0].length() - 1);
						products[i][1] = line[line.length - 2];
						products[i][2] = line[line.length - 1];
						i++;
					}
				} catch(Exception e) {
					System.out.println(e);
				} 
				productsScanner.close();
				return true;
			}
		}

		products = new String[][] {
			{"Кукурузные хлопья", "3.99", "1"}, 
			{"Пакет молока", "1.27", "1"}, 
			{"Сметана", "1.64", "0"}, 
			{"Майонез", "2.22", "0"}, 
			{"Кетчуп", "1.99", "0"}, 
			{"Соевый соус", "2.34", "0"}, 
			{"Чай чёрный", "1.79", "1"}, 
			{"Чай зелёный", "1.89", "0"}, 
			{"Сливочное масло", "3.04", "0"}, 
			{"Пакет кефира", "1.34", "0"}, 
			{"Батон", "1.41", "0"}, 
			{"Хлеб чёрный", "0.99", "0"}, 
			{"Рис длиннозерновой", "3.29", "1"}, 
			{"Яйца куриные", "3.19", "1"}, 
			{"Пельмени", "2.99", "0"}, 
			{"Напиток газированный 0,33л", "1.27", "0"}, 
			{"Напиток газированный 0,5л", "1.61", "0"}, 
			{"Напиток газированный 1л", "2.19", "0"}, 
			{"Напиток газированный 1,5л", "2.99", "0"}, 
			{"Напиток газированный 2л", "3.49", "1"}, 
			{"Палочки кукурузные", "1.79", "0"}, 
			{"Пачка сигарет", "2.99", "0"}, 
			{"Печенье сдобное", "1.99", "0"}, 
			{"Печенье овсяное", "3.99", "1"}, 
			{"Печенье мучное", "2.45", "0"}, 
			{"Мука", "2.89", "0"}, 
			{"Чипсы", "3.49", "0"}, 
			{"Сухарики", "1.45", "0"}, 
			{"Картофель (1 кг)", "0.89", "1"}, 
			{"Шоколадный батончик", "1.12", "0"}, 
			{"Пачка макарон", "2.24", "1"}, 
			{"Сосиски", "4.09", "0"}, 
			{"Вафли", "2.49", "0"}, 
			{"Творог", "2.65", "0"}, 
			{"Конфеты карамельные", "1.79", "0"}, 
			{"Конфеты шоколадные", "1.87", "0"}, 
			{"Шоколад", "3.51", "0"}, 
			{"Сушки", "1.43", "0"}, 
			{"Крупа манная", "1.19", "1"}, 
			{"Овсяные хлопья", "0.99", "0"}, 
			{"Сгущёное молоко", "2.99", "0"}, 
			{"Сыр", "4.49", "0"}, 
			{"Мороженое", "2.34", "0"}, 
			{"Сок томатный", "1.99", "1"}, 
			{"Сок мультифруктовый", "2.99", "0"}, 
			{"Сок апельсиновый", "3.14", "0"}, 
			{"Сок яблочный", "3.19", "0"}, 
			{"Сок гранатовый", "5.46", "0"}
		};
		return false;
	}

	private static int countLines() {
		int linesAmount = 0;
		try {
			Scanner s = new Scanner(new BufferedReader(new FileReader(productsDatabase)));
			while(s.hasNextLine()) {
				linesAmount++;
				s.nextLine();
			}
			s.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return linesAmount;
	}



	static String getIdName(int id) {
		return products[id][0];
	}
	
	static double getIdPrice(int id) {
		return Double.parseDouble(products[id][1]);
	}
	
	static int getIdPromoStatus(int id) {
		return Integer.parseInt(products[id][2]);
	}
	
	static int getPromoCount() {
		return promoCount;
	}
	
	static double getPromoDiscountMultiplier() {
		return ((1 - ((double)promoDiscount/100)));
	}
	
}