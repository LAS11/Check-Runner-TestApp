package checkrunner;

public class Check {
	
	private int[][] productsList;
	private double total;
	private double totalDiscounted;
	
	private int discount = 0;
	private int card = -1;
	private boolean isCardPresented = false;
	
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
		discount = CardsDB.getCardDiscount(card);
		calcTotal(discount);
	}
	
	//округление до 2-х знаков после запятой
	static double round(double t) {
		String totalStrRound = String.format("%.2f", t);
		totalStrRound = totalStrRound.replace(',', '.');
		return Double.parseDouble(totalStrRound);
	}
	
	private void calcTotal(int disc) {
		for (int i = 0; i < productsList.length; i++) {
			double productPrice = getProductPrice(i) * getProductQuantity(i);	
			
			if (getProductPromoStatus(i) == 1 && getProductQuantity(i) >= ProductsDB.getPromoCount()) {
				productPrice *= getPromoDiscountMultiplier();
			}
			total += productPrice;
		}
		
		total = round(total);
		
		if (disc != 0) {
			totalDiscounted = (double) total - (total * (disc/100.0));
			totalDiscounted = round(totalDiscounted);
		} else {
			totalDiscounted = total;
		}
	}
	
	String getProductName(int id) {
		return ProductsDB.getIdName(productsList[id][0]);
	}
	
	double getProductPrice(int id) {
		return ProductsDB.getIdPrice(productsList[id][0]);
	}
	
	int getProductPromoStatus(int id) {
		return ProductsDB.getIdPromoStatus(productsList[id][0]);
	}
	
	double getPromoDiscountMultiplier() {
		return ProductsDB.getPromoDiscountMultiplier();
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