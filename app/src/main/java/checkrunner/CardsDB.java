package checkrunner;

import java.io.*;
import java.util.*;

public class CardsDB {
	
	private static final int lineLength = 2;
	
	private static File cardsDatabase;
	private static Scanner cardsScanner;
	private static int cards[][];

	static int getCardDiscount(int cardNumCurr) {
		for (int i = 0; i < cards.length; i++) {
			if (cardNumCurr == cards[i][0]) {
				return cards[i][1];
			}
		}
		return 0;
	}
	
	public static boolean setCardsDatabase(String path) {
		if (path != "") {
			cardsDatabase = new File(path);
			if (cardsDatabase.exists() && cardsDatabase.isFile()) {
				cards = new int[countLines()][lineLength];
				try {
					cardsScanner = new Scanner(new BufferedReader(new FileReader(cardsDatabase)));
					int i = 0;
					while (cardsScanner.hasNextLine()) {
						cards[i][0] = cardsScanner.nextInt();
						cards[i][1] = cardsScanner.nextInt();
						i++;		
					}
				} catch(Exception e) {
					System.out.println(e);
				} 
				cardsScanner.close();
				return true;
			}
		}
		//{номер карты, процент скидки}
		cards = new int[][] {
			{2600, 4},
			{1031, 4}, 
			{8951, 4}, 
			{4730, 4}, 
			{89, 5}, 
			{3049, 5}, 
			{2984, 3}, 
			{4780, 3}, 
			{607, 5}, 
			{9064, 3}, 
			{7903, 3}, 
			{1289, 2}, 
			{4839, 1}, 
			{8487, 2}, 
			{3361, 4},
			{8451, 4}, 
			{7926, 5},
			{4448, 4}, 
			{6360, 3}, 
			{1036, 1}, 
			{1740, 5}, 
			{667, 2}, 
			{5234, 3}, 
			{2582, 1}, 
			{1205, 5}, 
			{8261, 3}, 
			{4919, 3}, 
			{8380, 3}, 
			{6111, 4},
			{5519, 2}, 
			{7945, 2}, 
			{227, 3}, 
			{5519, 4},
			{599, 1}, 
			{9763, 4}, 
			{4677, 2}, 
			{652, 3}, 
			{865, 5}, 
			{7810, 4}, 
			{9126, 3},
			{3722, 4}, 
			{7753, 1},
			{5661, 2}, 
			{1690, 5}, 
			{9292, 5}, 
			{6821, 1}, 
			{1552, 5}, 
			{1268, 5}, 
			{1488, 3}, 
			{3809, 2},
			{1205, 5},
			{8849, 4},
			{9440, 3},
			{6464, 5},
			{8602, 4},
			{9228, 5},
			{3274, 5},
			{3496, 2},
			{6745, 1},
			{9291, 3},
			{1286, 1},
			{5760, 1},
			{7847, 5},
			{354, 3},
			{5305, 5},
			{5742, 4},
			{3743, 2},
			{3309, 2},
			{2855, 3},
			{2226, 4},
			{374, 5},
			{4242, 2},
			{6815, 5},
			{8844, 1},
			{9000, 1},
			{4672, 2},
			{385, 3},
			{4834, 5},
			{7746, 7},
			{723, 5},
			{6970, 2},
			{6488, 3},
			{3001, 4},
			{6472, 4},
			{2205, 2},
			{1865, 3},
			{8932, 1},
			{174, 5},
			{6203, 3},
			{1499, 2},
			{9964, 4},
			{991, 2},
			{4911, 5},
			{2814, 4},
			{2250, 1},
			{6034, 4}
		};
		return false;
	}
	
	private static int countLines() {
		int linesAmount = 0;
		try {
			Scanner s = new Scanner(new BufferedReader(new FileReader(cardsDatabase)));
			while(s.hasNextLine()) {
				linesAmount++;
				s.nextLine();
			}
			s.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return linesAmount;
	}

}