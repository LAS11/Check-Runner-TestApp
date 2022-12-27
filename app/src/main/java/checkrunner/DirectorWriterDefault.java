package checkrunner;

import java.io.*;

class DirectorWriterDefault {
	
	void printDefaultCheck(CheckWriter writer, Check check, String path) throws Exception {
		
		FileWriter fw = new FileWriter(path);
		
		writer.addStoreName("ООО Магазин Дефолт", fw);
		writer.addStoreAddress("ул. Пушкина д. Колотушкина", fw);
		writer.addStorePhone("111-222-333", fw);
		writer.addCashReceiptTitle("ПЛАТЁЖНЫЙ ДОКУМЕНТ", fw);
		writer.addDividerLine("------------------------------------------------", fw);
		writer.addHeaderList("КОЛ-ВО НАЗВАНИЕ ЦЕНА ИТОГО", fw);
		
		for (int i = 0; i < check.getCheckItems().length; i++) {
			double totalForItems = check.getProductQuantity(i) * check.getProductPrice(i);
			String[] item = {Integer.toString(check.getProductQuantity(i)), check.getProductName(i), Double.toString(check.getProductPrice(i)), Double.toString(totalForItems)};
			writer.addItem(item, fw);
		}
		
		writer.addDividerLine("------------------------------------------------", fw);
		writer.addTotalWithoutTax("ИТОГО: " + Double.toString(check.getTotal()), fw);
		writer.addThanksLine("СПАСИБО ЗА ПОКУПКУ!", fw);
		
		fw.close();
	}
}