package checkrunner;

import java.io.*;

class DirectorToFileDefault {
	
	void printDefaultCheck(CheckBuilderDefault builder, Check check, String path) throws Exception {
		
		FileWriter fw = new FileWriter(path);
		
		builder.writeStoreName("ООО Магазин Дефолт", fw);
		builder.writeStoreAddress("ул. Пушкина д. Колотушкина", fw);
		builder.writeStorePhone("111-222-333", fw);
		builder.writeCashReceiptTitle("ПЛАТЁЖНЫЙ ДОКУМЕНТ", fw);
		builder.writeDividerLine("------------------------------------------------", fw);
		builder.writeHeaderList("КОЛ-ВО НАЗВАНИЕ ЦЕНА ИТОГО", fw);
		
		for (int i = 0; i < check.getCheckItems().length; i++) {
			double totalForItems = check.getProductQuantity(i) * check.getProductPrice(i);
			String[] item = {Integer.toString(check.getProductQuantity(i)), check.getProductName(i), Double.toString(check.getProductPrice(i)), Double.toString(totalForItems)};
			builder.writeItem(item, fw);
		}
		
		builder.writeDividerLine("------------------------------------------------", fw);
		builder.writeTotalWithoutTax("ИТОГО: " + Double.toString(check.getTotal()), fw);
		builder.writeThanksLine("СПАСИБО ЗА ПОКУПКУ!", fw);
		
		fw.close();
	}
}