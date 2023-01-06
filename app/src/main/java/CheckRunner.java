import checkrunner.ArgsListChecker;
import checkrunner.Check;
import checkrunner.CheckBuilderDefault;
import checkrunner.CheckWriter;
import checkrunner.DirectorPrinterDefault;
import checkrunner.DirectorWriterDefault;
import checkrunner.CardsDB;
import checkrunner.ProductsDB;

public class CheckRunner {
    public static void main(String[] args) throws Exception{
		
		ArgsListChecker argsChecker = new ArgsListChecker(args);
		if (argsChecker.isArgsListEmpty()) {
			System.out.println("The list is empty!");
			System.exit(-1);
		}
		
		//"1-3 5-6 7-9 card-1234 cards=D:\Check-Runner-TestApp\cards.txt products=D:\Check-Runner-TestApp\products.txt"
		
		int itemsSize = args.length - argsChecker.getParamAmount("card-") - argsChecker.getParamAmount("cards=") - argsChecker.getParamAmount("products=");
		int items[][] = argsChecker.generateItemsList(itemsSize);
		
		String cardDatabasePath = argsChecker.getDatabasePath("cards");
		if (cardDatabasePath != "") {
			System.out.println("Обнаружен путь к базе данных скидочных карт...");
			if (CardsDB.setCardsDatabase(cardDatabasePath) == false) {
				System.out.print("Файл с БД карт не был обнаружен.");
			}
			else {
				System.out.println("Файл с БД обнаружен, данные из него будут использованы при проверке скидочных карт.");
			}
		} 
		else {
			System.out.println("Использую БД карт по умолчанию.");
			CardsDB.setCardsDatabase("");
		}
		
		String productsDatabasePath = argsChecker.getDatabasePath("products");
		if (productsDatabasePath != "") {
			System.out.println("Обнаружен путь к базе данных продуктов...");
			if (ProductsDB.setProductsDatabase(productsDatabasePath) == false) {
				System.out.print("Файл с БД продуктов не был обнаружен, проверьте правильность указанного ввода.");
			}
			else {
				System.out.println("Файл с БД обнаружен, данные из него будут использованы при оценивании продуктов.");
			}
		} 
		else {
			System.out.println("Использую БД продуктов по умолчанию.");
			ProductsDB.setProductsDatabase("");
		} 
		
		Check check;
		if (argsChecker.getParamAmount("card-") != 0) {
			int cardNum = argsChecker.getLastDiscountCard();
			check = new Check(items, cardNum);
		} else {
			check = new Check(items);
		}
		
		CheckBuilderDefault builder = new CheckBuilderDefault();
		DirectorPrinterDefault printer = new DirectorPrinterDefault();
		printer.printDefaultCheck(builder, check);
		
		
		String path = "check.txt"; //чек сохранится в папке, где хранится программа
		CheckWriter writer = new CheckWriter();
		DirectorWriterDefault directorFile = new DirectorWriterDefault();
		directorFile.printDefaultCheck(writer, check, path);
    }
	
}