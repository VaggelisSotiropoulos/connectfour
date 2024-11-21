package pack;

public class Player {
	private String name;
	private String symbol;
	
	public Player() {
		
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSymbol(String aSymbol) {
		symbol = aSymbol;
	} 
	
	public String getSymbol() {
		return symbol;
	}
	
	public void printInfo(){
		
		System.out.println("Name: " + name);
		System.out.println("Symbol: " + symbol);
	}

}
