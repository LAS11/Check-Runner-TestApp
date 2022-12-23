package checkrunner;

class DirectorDefault {
	
	void printDefaultCheck(CheckBuilderDefault builder, Check check) {
		builder.printStoreName("ООО Магазин Дефолт");
		builder.printStoreAddress("ул. Пушкина д. Колотушкина");
		builder.printStorePhone("111-222-333");
		builder.printCashReceiptTitle("ПЛАТЁЖНЫЙ ДОКУМЕНТ");
		builder.printDividerLine("------------------------------------------------");
		builder.printHeaderList("КОЛ-ВО НАЗВАНИЕ ЦЕНА ИТОГО");
		
		for (int i = 0; i < check.getCheckItems().length; i++) {
			double totalForItems = check.getProductQuantity(i) * check.getProductPrice(i);
			String[] item = {Integer.toString(check.getProductQuantity(i)), check.getProductName(i), Double.toString(check.getProductPrice(i)), Double.toString(totalForItems)};
			builder.printItem(item);
		}
		
		builder.printDividerLine("------------------------------------------------");
		builder.printTotalWithoutTax("ИТОГО: " + Double.toString(check.getTotal()));
		builder.printThanksLine("СПАСИБО ЗА ПОКУПКУ!");
	}
}