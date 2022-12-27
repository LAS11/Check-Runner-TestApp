package checkrunner;

class Check {
	
	private int[][] productsList;
	private double total;
	
	ProductsDB database = new ProductsDB();
	
	public Check(int[][] i) {
		productsList = i;
		calcTotal();
	}
	
	private void calcTotal() {
		for (int i = 0; i < productsList.length; i++) {
			this.total += getProductPrice(productsList[i][0]) * productsList[i][1];
		}
		String totalStrRound = String.format("%.2f", this.total);
		totalStrRound = totalStrRound.replace(',', '.');
		this.total = Double.parseDouble(totalStrRound);
	}
	
	double getProductPrice(int i) {
		return database.getIdPrice(i);
	}
	
	String getProductName(int i) {
		return database.getIdName(productsList[i][0]);
	}
	
	int getProductQuantity(int i) {
		return productsList[i][1];
	}
	
	void printTotal() {
		System.out.println(total);
	}
	
	double getTotal() {
		return this.total;
	}
	
	void setCheckItems(int[][] i) {
		productsList = i;
		calcTotal();
	}
	
	int[][] getCheckItems() {
		return productsList;
	}
	
	
	
}