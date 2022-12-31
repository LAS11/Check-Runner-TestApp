import checkrunner.ArgsListChecker;
import checkrunner.Check;
import checkrunner.CheckBuilderDefault;
import checkrunner.CheckWriter;
import checkrunner.DirectorPrinterDefault;
import checkrunner.DirectorWriterDefault;

public class CheckRunner {
    public static void main(String[] args) throws Exception{
		
		
		ArgsListChecker argsChecker = new ArgsListChecker(args);
		if (argsChecker.isArgsListEmpty()) {
			System.out.println("The list is empty!");
			System.exit(-1);
		}
		
		Check check;
		int amountCards = argsChecker.getAmountOfDiscountCards();
		int itemsSize = args.length - amountCards;
		int items[][] = argsChecker.generateItemsList(itemsSize);
		
		if (amountCards != 0) {
			int cardNum = argsChecker.getLastDiscountCard();
			check = new Check(items, cardNum);
		} else {
			check = new Check(items);
		}
		
		CheckBuilderDefault builder = new CheckBuilderDefault();
		DirectorPrinterDefault printer = new DirectorPrinterDefault();
		printer.printDefaultCheck(builder, check);
		
		/*
		String path = "D://check.txt";
		CheckWriter writer = new CheckWriter();
		DirectorWriterDefault directorFile = new DirectorWriterDefault();
		directorFile.printDefaultCheck(writer, check, path);
		*/

    }
	
}