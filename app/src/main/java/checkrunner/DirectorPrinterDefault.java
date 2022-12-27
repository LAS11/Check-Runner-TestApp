package checkrunner;

public class DirectorPrinterDefault {
	
	public void printDefaultCheck(CheckBuilderDefault builder, Check check) {
		builder.addStoreName("ООО Магазин Дефолт");
		builder.addStoreAddress("ул. Пушкина д. Колотушкина");
		builder.addStorePhone("111-222-333");
		builder.addCashReceiptTitle("ПЛАТЁЖНЫЙ ДОКУМЕНТ");
		builder.addDividerLine("------------------------------------------------");
		builder.addHeaderList("КОЛ-ВО НАЗВАНИЕ ЦЕНА ИТОГО");
		
		for (int i = 0; i < check.getCheckItems().length; i++) {
			double totalForItems = check.getProductQuantity(i) * check.getProductPrice(i);
			String[] item = {Integer.toString(check.getProductQuantity(i)), check.getProductName(i), 
											Double.toString(check.getProductPrice(i)), Double.toString(totalForItems)};
			builder.addItem(item);
		}
		
		builder.addDividerLine("------------------------------------------------");
		builder.addTotalWithoutTax("ИТОГО: " + Double.toString(check.getTotal()));
		builder.addThanksLine("СПАСИБО ЗА ПОКУПКУ!");
	}
}