package com.las11.checkrunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArgsListCheckerTest {
	String[][][] argsList = {
		{"3-1 4-5 card-1234 2-5 1-0 6-6 card- 7-1 8-0 9-3 card-1d4 0-0".split(" ")}, 		//0
		{"3-1 4-5 2-5 1-0 6-6 card-0001 card-4569 7-1 8-0 9-3 card-1234 0-0".split(" ")},	//1
		{"card-4568 3-1 4-5 2-5 1-0 6-6 7-1 8-0 9-3 card-12344 0-0".split(" ")}, 			//2
		{"3-1 4-5 card-3332 2-5 1-0 6-6 7-1 8-0 9-3".split(" ")}, 							//3
		{"3-1 4-5 2-5 1-0 6-6 7-1 card-1258 8-0".split(" ")}, 								//4
		{"3-1 4-5 card-0500 2-5 1-0 6-6 7-1".split(" ")}, 									//5
		{"3-1 4-5 2-5 1-0 6-6 card-4212".split(" ")}, 										//6
		{"3-1 4-5 card-0444 2-5 1-0 6-6 card-1213".split(" ")}, 							//7
		{"3-1 4-5 2-5 card-7788 1-0 6-6-4 card-0444".split(" ")}, 							//8
		{"1-2 3-4 5-6 1-0 6-6b".split(" ")},												//9
		{" ".split(" ")}																	//10
	};
	
	@Test
	public void testIsArgsListEmpty() {
		ArgsListChecker argsTest0 = new ArgsListChecker(argsList[0][0]);
		assertEquals(false, argsTest0.isArgsListEmpty(), "the args is not empty");
		
		ArgsListChecker argsTest1 = new ArgsListChecker(argsList[1][0]);
		assertEquals(false, argsTest1.isArgsListEmpty(), "the args is not empty");
		
		ArgsListChecker argsTest2 = new ArgsListChecker(argsList[2][0]);
		assertEquals(false, argsTest2.isArgsListEmpty(), "the args is not empty");
		
		ArgsListChecker argsTest3 = new ArgsListChecker(argsList[3][0]);
		assertEquals(false, argsTest3.isArgsListEmpty(), "the args is not empty");
		
		ArgsListChecker argsTest4 = new ArgsListChecker(argsList[4][0]);
		assertEquals(false, argsTest4.isArgsListEmpty(), "the args is not empty");
		
		ArgsListChecker argsTest5 = new ArgsListChecker(argsList[5][0]);
		assertEquals(false, argsTest5.isArgsListEmpty(), "the args is not empty");
		
		ArgsListChecker argsTest6 = new ArgsListChecker(argsList[6][0]);
		assertEquals(false, argsTest6.isArgsListEmpty(), "the args is not empty");
		
		ArgsListChecker argsTest7 = new ArgsListChecker(argsList[7][0]);
		assertEquals(false, argsTest7.isArgsListEmpty(), "the args is not empty");
		
		ArgsListChecker argsTest8 = new ArgsListChecker(argsList[8][0]);
		assertEquals(false, argsTest8.isArgsListEmpty(), "the args is not empty");
		
		ArgsListChecker argsTest9 = new ArgsListChecker(argsList[9][0]);
		assertEquals(false, argsTest9.isArgsListEmpty(), "the args is not empty");
		
		ArgsListChecker argsTest10 = new ArgsListChecker(argsList[10][0]);
		assertEquals(true, argsTest10.isArgsListEmpty(), "the args is empty");			
	}
	
	@Test
	public void testGetAmountOfDiscountCards() {
		ArgsListChecker argsTest0 = new ArgsListChecker(argsList[0][0]);
		assertEquals(3, argsTest0.getAmountOfDiscountCards(), "there are 3 cards (even if some of them are wrong)");
		
		ArgsListChecker argsTest1 = new ArgsListChecker(argsList[1][0]);
		assertEquals(3, argsTest1.getAmountOfDiscountCards(), "there are 3 cards");
		
		ArgsListChecker argsTest2 = new ArgsListChecker(argsList[2][0]);
		assertEquals(2, argsTest2.getAmountOfDiscountCards(), "there are 2 cards");
		
		ArgsListChecker argsTest3 = new ArgsListChecker(argsList[3][0]);
		assertEquals(1, argsTest3.getAmountOfDiscountCards(), "there is 1 card");
		
		ArgsListChecker argsTest4 = new ArgsListChecker(argsList[4][0]);
		assertEquals(1, argsTest4.getAmountOfDiscountCards(), "there is 1 card");
		
		ArgsListChecker argsTest5 = new ArgsListChecker(argsList[5][0]);
		assertEquals(1, argsTest5.getAmountOfDiscountCards(), "there is 1 card");
		
		ArgsListChecker argsTest6 = new ArgsListChecker(argsList[6][0]);
		assertEquals(1, argsTest6.getAmountOfDiscountCards(), "there is 1 card");
		
		ArgsListChecker argsTest7 = new ArgsListChecker(argsList[7][0]);
		assertEquals(2, argsTest7.getAmountOfDiscountCards(), "there are 2 cards");
		
		ArgsListChecker argsTest8 = new ArgsListChecker(argsList[8][0]);
		assertEquals(2, argsTest8.getAmountOfDiscountCards(), "there are 2 cards");
		
		ArgsListChecker argsTest9 = new ArgsListChecker(argsList[9][0]);
		assertEquals(0, argsTest9.getAmountOfDiscountCards(), "there is 0 no cards");
		
		ArgsListChecker argsTest10 = new ArgsListChecker(argsList[10][0]);
		assertEquals(0, argsTest10.getAmountOfDiscountCards(), "there is 0 no cards");
	}

	@Test
	public void testGetLastDiscountCard() {
		int cardNum = -1;
		ArgsListChecker argsTest0 = new ArgsListChecker(argsList[0][0]);
		assertThrows(NumberFormatException.class, () -> {
			argsTest0.getLastDiscountCard();
		}, "NumberFormatException was expected");
		
		cardNum = 1234;
		ArgsListChecker argsTest1 = new ArgsListChecker(argsList[1][0]);
		assertEquals(cardNum, argsTest1.getLastDiscountCard(), "card-1234");
		
		cardNum = 12344;
		ArgsListChecker argsTest2 = new ArgsListChecker(argsList[2][0]);
		assertEquals(cardNum, argsTest2.getLastDiscountCard());
		
		cardNum = 3332;
		ArgsListChecker argsTest3 = new ArgsListChecker(argsList[3][0]);
		assertEquals(cardNum, argsTest3.getLastDiscountCard(), "card-12344");
		
		cardNum = 1258;
		ArgsListChecker argsTest4 = new ArgsListChecker(argsList[4][0]);
		assertEquals(cardNum, argsTest4.getLastDiscountCard(), "card-1258");
		
		cardNum = 500;
		ArgsListChecker argsTest5 = new ArgsListChecker(argsList[5][0]);
		assertEquals(cardNum, argsTest5.getLastDiscountCard(), "card-500 ~ card-0500");
		
		cardNum = 4212;
		ArgsListChecker argsTest6 = new ArgsListChecker(argsList[6][0]);
		assertEquals(cardNum, argsTest6.getLastDiscountCard(), "card-4212");
		
		cardNum = 1213;
		ArgsListChecker argsTest7 = new ArgsListChecker(argsList[7][0]);
		assertEquals(cardNum, argsTest7.getLastDiscountCard(), "card-1213");
		
		cardNum = 444;
		ArgsListChecker argsTest8 = new ArgsListChecker(argsList[8][0]);
		assertEquals(cardNum, argsTest8.getLastDiscountCard(), "card-444 ~ card-0444");
		
		cardNum = -1;
		ArgsListChecker argsTest9 = new ArgsListChecker(argsList[9][0]);
		assertEquals(cardNum, argsTest9.getLastDiscountCard(), "there is no card");
		
		cardNum = -1;
		ArgsListChecker argsTest10 = new ArgsListChecker(argsList[10][0]);
		assertEquals(cardNum, argsTest10.getLastDiscountCard(), "there is no card");
		
	}
	
	@Test
	public void testGenerateItemsList() {
		
		ArgsListChecker argsTest0 = new ArgsListChecker(argsList[0][0]);
		int[][] itemsTest0 = {{3, 1},{4, 5},{2, 5},{1, 0},{6, 6},{7, 1},{8, 0},{9, 3},{0, 0}};
		int itemsSize0 = argsList[0][0].length - argsTest0.getAmountOfDiscountCards();
		assertArrayEquals(itemsTest0, argsTest0.generateItemsList(itemsSize0));
		
		ArgsListChecker argsTest1 = new ArgsListChecker(argsList[1][0]);
		int[][] itemsTest1 = {{3, 1},{4, 5},{2, 5},{1, 0},{6, 6},{7, 1},{8, 0},{9, 3},{0, 0}};
		int itemsSize1 = argsList[1][0].length - argsTest1.getAmountOfDiscountCards();
		assertArrayEquals(itemsTest1, argsTest1.generateItemsList(itemsSize1));
		
		ArgsListChecker argsTest2 = new ArgsListChecker(argsList[2][0]);
		int[][] itemsTest2 = {{3, 1},{4, 5},{2, 5},{1, 0},{6, 6},{7, 1},{8, 0},{9, 3},{0, 0}};
		int itemsSize2 = argsList[2][0].length - argsTest2.getAmountOfDiscountCards();
		assertArrayEquals(itemsTest2, argsTest2.generateItemsList(itemsSize2));
		
		ArgsListChecker argsTest3 = new ArgsListChecker(argsList[3][0]);
		int[][] itemsTest3 = {{3, 1},{4, 5},{2, 5},{1, 0},{6, 6},{7, 1},{8, 0},{9, 3}};
		int itemsSize3 = argsList[3][0].length - argsTest3.getAmountOfDiscountCards();
		assertArrayEquals(itemsTest3, argsTest3.generateItemsList(itemsSize3));
		
		ArgsListChecker argsTest4 = new ArgsListChecker(argsList[4][0]);
		int[][] itemsTest4 = {{3, 1},{4, 5},{2, 5},{1, 0},{6, 6},{7, 1},{8, 0}};
		int itemsSize4 = argsList[4][0].length - argsTest4.getAmountOfDiscountCards();
		assertArrayEquals(itemsTest4, argsTest4.generateItemsList(itemsSize4));
		
		ArgsListChecker argsTest5 = new ArgsListChecker(argsList[5][0]);
		int[][] itemsTest5 = {{3, 1},{4, 5},{2, 5},{1, 0},{6, 6},{7, 1}};
		int itemsSize5 = argsList[5][0].length - argsTest5.getAmountOfDiscountCards();
		assertArrayEquals(itemsTest5, argsTest5.generateItemsList(itemsSize5));
		
		ArgsListChecker argsTest6 = new ArgsListChecker(argsList[6][0]);
		int[][] itemsTest6 = {{3, 1},{4, 5},{2, 5},{1, 0},{6, 6}};
		int itemsSize6 = argsList[6][0].length - argsTest6.getAmountOfDiscountCards();
		assertArrayEquals(itemsTest6, argsTest6.generateItemsList(itemsSize6));
		
		ArgsListChecker argsTest7 = new ArgsListChecker(argsList[7][0]);
		int[][] itemsTest7 = {{3, 1},{4, 5},{2, 5},{1, 0},{6, 6}};
		int itemsSize7 = argsList[7][0].length - argsTest7.getAmountOfDiscountCards();
		assertArrayEquals(itemsTest7, argsTest7.generateItemsList(itemsSize7));
		
		ArgsListChecker argsTest8 = new ArgsListChecker(argsList[8][0]);
		int[][] itemsTest8 = {{3, 1},{4, 5},{2, 5},{1, 0},{-1, -1}};
		int itemsSize8 = argsList[8][0].length - argsTest8.getAmountOfDiscountCards();
		assertArrayEquals(itemsTest8, argsTest8.generateItemsList(itemsSize8));
		
		ArgsListChecker argsTest9 = new ArgsListChecker(argsList[9][0]);
		int itemsSize9 = argsList[9][0].length - argsTest9.getAmountOfDiscountCards();
		assertThrows(NumberFormatException.class, () -> {
			argsTest9.generateItemsList(itemsSize9);
		}, "NumberFormatException was expected");
		
		ArgsListChecker argsTest10 = new ArgsListChecker(argsList[10][0]);
		int[][] itemsTest10 = {{-1, -1}};
		int itemsSize10 = argsList[10][0].length - argsTest10.getAmountOfDiscountCards();
		assertArrayEquals(itemsTest10, argsTest10.generateItemsList(itemsSize10));			
	}
	
}