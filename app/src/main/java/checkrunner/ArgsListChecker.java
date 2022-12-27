package checkrunner;

public class ArgsListChecker {
	
	private String[] args;
	
	public ArgsListChecker(String[] a) {
		args = a;
	}
	
	public boolean isArgsListEmpty() {
		return (args.length == 0) ? true : false;
	}
	
	public int getAmountOfDiscountCards() {
		int cardsAmount = 0;
		for (String arg: args) {
			if (arg.startsWith("card-")) {
				cardsAmount++;
			}
		}
		return cardsAmount;
	}
	
	public int getLastDiscountCard() {
		int cardNum = -1;
		
		for (String arg: args) {
			if (arg.startsWith("card-")) {
				String cardNumString = arg.substring(arg.lastIndexOf("-") + 1);
				//если номер карточки будет не числом - генерирование чека прекратится из-за возникшей ошибки
				cardNum = Integer.parseInt(cardNumString);
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
			if (!args[i].startsWith("card-")) {
				String[] idQuantity = args[i].split("-");
				if (idQuantity.length == 2) {
					//если пара id-quantity будет состоять не из чисел - генерирование чека прекратится из-за возникшей ошибки
					try {
						items[j][0] = Integer.parseInt(idQuantity[0]);
						items[j][1] = Integer.parseInt(idQuantity[1]);
						j++;
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Error! Can't fit an item into the array of items, check the code!");
						items[j] = new int[] {-1, -1};
						j++;
					}
				}
				else {
					System.out.println("Error! There is a strange pair id-price consists more than of 2 items in the list!");
					items[j] = new int[] {-1, -1};
				}
			}
		}
		return items;
	}
	
}