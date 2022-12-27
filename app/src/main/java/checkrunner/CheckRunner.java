package checkrunner;

public class CheckRunner {
    public static void main(String[] args) throws Exception{
		
		ArgsListChecker argsChecker = new ArgsListChecker(args);
		if (argsChecker.isArgsListEmpty()) {
			System.out.println("The list is empty!");
			System.exit(-1);
		} 
		
		int cardNum = argsChecker.getLastDiscountCard();
		int itemsSize = args.length - argsChecker.getAmountOfDiscountCards();
		int items[][] = argsChecker.generateItemsList(itemsSize);
		
		Check check = new Check(items);
		
		CheckBuilderDefault builder = new CheckBuilderDefault();
		DirectorPrinterDefault printer = new DirectorPrinterDefault();
		printer.printDefaultCheck(builder, check);
		
		String path = "D://check.txt";
		CheckWriter writer = new CheckWriter();
		DirectorWriterDefault directorFile = new DirectorWriterDefault();
		directorFile.printDefaultCheck(writer, check, path);

    }
	
}