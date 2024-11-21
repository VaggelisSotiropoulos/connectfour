package pack;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String symbol;
		Player P1 = new Player(); 
		Player P2 = new Player(); 
		Tableau table = new Tableau();
		java.util.Random random = new java.util.Random();
		
		System.out.println("Enter name Player 1: ");
		String name1 = in.nextLine();
		P1.setName(name1);
		
		System.out.println("Enter name Player 2 : ");
		String name2 = in.nextLine();
		P2.setName(name2);
		
		symbol =" ";
		while (!symbol.equals("x") && !symbol.equals("o"))
		{
		  System.out.println("Select prefered symbol for Player 1 (x or o): ");
		  symbol = in.nextLine();
		  P1.setSymbol(symbol);
		  System.out.println(symbol);
		}
		
		if (symbol.equals("x")) {
			System.out.println("Player 2 your symbol is o");
			P2.setSymbol("o");
		}else {
			System.out.println("Player 2 your symbol is x");
			P2.setSymbol("x");
		}
		
		System.out.println("Game Informations: ");
		System.out.println("Player 1: ");
		P1.printInfo();
		System.out.println("Player 2: ");
		P2.printInfo();

		int cols = 0;
		int rows = 0;
		
		System.out.println("Please select number of tableau columns and rows (between 4 and 15): ");
		
		while (cols<4 || cols>15) {
		  System.out.println("Number of columns: ");
		  cols = in.nextInt(); //στηλες
		}
		
		while (rows<4 || rows>15) {
		  System.out.println("Number of rows: ");
		  rows = in.nextInt(); //γραμμες
		}
		
		System.out.println("Number of Columns: " + cols);
		System.out.println("Number of Rows: " + rows);
		
		table.setCols(cols);
		table.setRows(rows);
		
		table.printTable();
		
		int tmp = random.nextInt(2) + 1;
		int sel = 0;
		int turn = 0;
		
		if (tmp == 1 ) {
			System.out.println("Player 1 is your turn! ");
			System.out.println("Pleas select column: ");
			do {
				 sel = in.nextInt();
				 if (sel<1 || sel>cols) {
					 System.out.println("Whoops! Out of bounds. Try again.");
				 }
			  symbol = P1.getSymbol();
		    }while (sel<1 || sel>cols);
			turn = 1;
			symbol = P1.getSymbol();
		}else if (tmp == 2) {
			
		 System.out.println("Player 2 is your turn! ");
		 System.out.println("Pleas select column: ");
		 do {
			 sel = in.nextInt();
			 if (sel<1 || sel>cols) {
				 System.out.println("Whoops! Out of bounds. Try again.");
			 }
		  symbol = P2.getSymbol();
	    }while (sel<1 || sel>cols);
		 turn = 2;
		 symbol = P2.getSymbol();
		}
		
		table.insertSymbol(sel, symbol);
		table.printTable();
		
		boolean flag = true;
		
		while (flag) {
			if (turn == 1) {
				 System.out.println("Player 2 is your turn! ");
				 System.out.println("Please select column: ");
				 do {
					 sel = in.nextInt();
					 if (sel<1 || sel>cols) {
						 System.out.println("Whoops! Out of bounds. Try again.");
					 }
				  symbol = P1.getSymbol();
			    }while (sel<1 || sel>cols);
				 symbol = P2.getSymbol();
				 table.insertSymbol(sel, symbol);
				 table.printTable();
				 turn = 2;
				 flag = table.checkWin();
			}else if(turn == 2) {
				System.out.println("Player 1 is your turn! ");
				System.out.println("Please select column: ");
				do {
					 sel = in.nextInt();
					 if (sel<1 || sel>cols) {
						 System.out.println("Whoops! Out of bounds. Try again.");
					 }
				  symbol = P1.getSymbol();
			    }while (sel<1 || sel>cols);
				  symbol = P1.getSymbol();
				  table.insertSymbol(sel, symbol);
				  table.printTable();
				  turn = 1;
				  flag = table.checkWin();
			}
		}
		
		if (turn == 1) {
			System.out.println("Congratulations " + P1.getName() +" you are the winner");
			table.printTable();
		}else if (turn == 2) {
			System.out.println("Congratulations " + P2.getName() +" you are the winner");
			table.printTable();
		}
		
	}

}
