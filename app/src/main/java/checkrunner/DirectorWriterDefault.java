package checkrunner;

import java.io.*;

public class DirectorWriterDefault {
	
	public void printDefaultCheck(CheckWriter writer, Check check, String path) throws Exception {
		
		FileWriter fw = new FileWriter(path);
		
		writer.addStoreName("ООО Магазин Дефолт", fw);
		writer.addStoreAddress("ул. Пушкина д. Колотушкина", fw);
		writer.addStorePhone("111-222-333", fw);
		writer.addCashReceiptTitle("ПЛАТЁЖНЫЙ ДОКУМЕНТ", fw);
		writer.addDividerLine("------------------------------------------------", fw);
		writer.addHeaderList("КОЛ-ВО НАЗВАНИЕ ЦЕНА ИТОГО", fw);
		
		for (int i = 0; i < check.getCheckItems().length; i++) {
			double totalForItems = check.getProductQuantity(i) * check.getProductPrice(i);
			
			String[] item = {Integer.toString(check.getProductQuantity(i)), 
								check.getProductName(i), 
								Double.toString(check.getProductPrice(i)), 
								Double.toString(totalForItems), 
								check.getProductPromoStatus(i)
							};
			writer.addItem(item, fw);
		}
		
		writer.addDividerLine("------------------------------------------------", fw);
		writer.addTotalWithoutTax("ИТОГО: " + Double.toString(check.getTotal()), fw);
		
		if (check.getCardPresence()) {
			writer.addDividerLine("------------------------------------------------", fw);	
			writer.addDiscountCard("ПРЕДЪЯВЛЕНА СКИДОЧНАЯ КАРТА №" + check.getDiscountCard(), fw);
			writer.addTotalDiscounted("ИТОГО (С УЧЁТОМ СКИДКИ " + check.getDiscount() + "%): " + Double.toString(check.getTotalDiscounted()), fw);
			writer.addDividerLine("------------------------------------------------", fw);	
		}
		
		writer.addThanksLine("СПАСИБО ЗА ПОКУПКУ!", fw);
		fw.close();
	}
}