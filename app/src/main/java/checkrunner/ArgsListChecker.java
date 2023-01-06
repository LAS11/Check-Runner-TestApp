package checkrunner;

public class ArgsListChecker {
	
	private String[] args;
	
	public ArgsListChecker(String[] a) {
		args = a;
	}
	
	public boolean isArgsListEmpty() {
		if (args.length == 0) {
			return true;
		} else if (args.length == 1 && args[0].startsWith("card-") || args[0].startsWith("cards=") || args[0].startsWith("products=")) {
			return true;
		}
		return false;
	}
	
	public String getDatabasePath(String param) {
		String path = "";
		if (param != "" && param != " ") {
			for (String arg: args) {
				if (arg.startsWith(param + "=")) {
					path = arg.substring(arg.lastIndexOf("=") + 1);
				}
			}	
		}
		return path;
	}
	
	public int getParamAmount(String param) {
		int amount = 0;
		for (String arg: args) {
			if (arg.startsWith(param)) {
				amount++;
			}
		}
		return amount;
	}
	
	public int getLastDiscountCard() {
		int cardNum = -1;
		
		for (String arg: args) {
			if (arg.startsWith("card-")) {
				try {
					String cardNumString = arg.substring(arg.lastIndexOf("-") + 1);
					cardNum = Integer.parseInt(cardNumString);
				} catch (NumberFormatException e) {
					System.out.println("Код скидочной карты содержит недопустимые символы, она будет проигнорирована!");
					continue;
				}
			}
		}
		
		return cardNum;
	}
	
	public int[][] generateItemsList(int itemsSize) {
		if (args.length == 0) {
			int[][] items = {{-1, -1}};
			return items;
		} 
		
		int[][] items = new int[itemsSize][2];
		
		for (int i = 0, j = 0; i < args.length; i++) {
			if (!args[i].startsWith("card-") && !args[i].startsWith("cards=") && !args[i].startsWith("products=")) {
				String[] idQuantity = args[i].split("-");
				if (idQuantity.length == 2) {
					try {
						items[j][0] = Integer.parseInt(idQuantity[0]); //id
						items[j][1] = Integer.parseInt(idQuantity[1]); //quantity
						j++;
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Ошибка! Попытка добавить элемент в переполненный массив, проверьте код!");
						items[j] = new int[] {-1, -1};
						j++;
					} catch (NumberFormatException e) {
						System.out.println("Ошибка! Недопустимые символы в id и/или количестве товаров!");
						items[j] = new int[] {-1, -1};
						j++;
					}
				}
				else {
					System.out.println("Ошибка! В списке обнаружена странная пара параметров \"id-количество\", состоящая более чем из 2-х элементов!");
					items[j] = new int[] {-1, -1};
				}
			}
		}
		return items;
	}
	
}