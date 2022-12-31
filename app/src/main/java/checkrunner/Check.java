package checkrunner;

public class Check {
	
	private int[][] productsList;
	private double total;
	private double totalDiscounted;
	
	private int discount = 0;
	private int card = -1;
	private boolean isCardPresented = false;
	
	ProductDB productsDB = new ProductDB();
	CardDB cardsDB = new CardDB();
	
	public Check() {
		
	}
	
	public Check(int[][] i) {
		productsList = i;
		isCardPresented = false;
		card = -1;
		discount = 0;
		calcTotal(discount);
	}
	
	public Check(int[][] i, int c) {
		productsList = i;
		card = c;
		isCardPresented = true;
		discount = cardsDB.getCardDiscount(card);
		calcTotal(discount);
	}
	
	//округление до 2-х знаков после запятой
	private double round(double t) {
		String totalStrRound = String.format("%.2f", t);
		totalStrRound = totalStrRound.replace(',', '.');
		return Double.parseDouble(totalStrRound);
	}
	
	private void calcTotal(int disc) {
		for (int i = 0; i < productsList.length; i++) {
			total += getProductPrice(i) * getProductQuantity(i);
		}
		total = round(total);
		
		if (disc != 0) {
			System.out.println(totalDiscounted);
			totalDiscounted = (double) total - (total * (disc/100.0));
			totalDiscounted = round(totalDiscounted);
		} else {
			totalDiscounted = total;
		}
	}
	
	String getProductName(int id) {
		return productsDB.getIdName(productsList[id][0]);
	}
	double getProductPrice(int id) {
		return productsDB.getIdPrice(productsList[id][0]);
	}
	int getProductQuantity(int i) {
		return productsList[i][1];
	}
	
	boolean getCardPresence() {
		return isCardPresented;
	}
	
	int getDiscount() {
		return discount;
	}
	
	int getDiscountCard() {
		return card;
	}
	
	void printTotal() {
		System.out.println(total);
	}
	
	double getTotal() {
		return total;
	}
	
	double getTotalDiscounted() {
		return totalDiscounted;
	}
	
	void setCheckItems(int[][] i) {
		productsList = i;
	}
	
	void setCard(int c) {
		card = c;
	}
	
	int[][] getCheckItems() {
		return productsList;
	}
	
	
	
}