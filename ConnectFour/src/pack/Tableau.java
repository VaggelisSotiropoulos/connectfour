package pack;


public class Tableau {
	
	private int cols;
	private int rows;
	private String[][] table;

	public Tableau(){
		 this.cols = 0;
	     this.rows = 0;
	     this.table = new String[0][0];
	}
	
	public void setCols(int aCols) {
		cols = aCols;
		initializeTable();
	}
	
	public void setRows(int aRows) {
		rows = aRows;
		initializeTable();
	}
	
			
	//create tableau
	private void initializeTable() {
        if (rows > 0 && cols > 0) {
            table = new String[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    table[i][j] = "-";
                }
            }
        }
    }
	
	public void printTable() {
		for (int i = 0;i < rows; i++) {
			for (int j = 0;j<cols; j++) {
				System.out.print(table[i][j] + "\t" );
			}
			System.out.println();
		}
	}
	
	public void insertSymbol(int sel, String aSymbol) {
		int flag = 0;
		for (int i = rows-1;i >= 0; i--) {
			
			if (flag == 1) {
				break;
			}else if (table[i][sel-1] == "-") {
					table[i][sel-1] = aSymbol;
					flag = 1;
			   }
			}
			
			
		}
	
	public boolean checkHorizontal() {
		for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= cols - 4; j++) { 
                
            	if (table[i][j] != "-") {
            		
            	
            	  if (table[i][j] == table[i][j + 1] &&
                      table[i][j] == table[i][j + 2] &&
                      table[i][j] == table[i][j + 3]) 
                  {
                      return true;
                  }
            	}
            
            }
        }
        return false;
	}
	
	public boolean checkVertical() {
		 for (int i = 0; i <= rows - 4; i++) { 
	            for (int j = 0; j < cols; j++) {
	                  
	            	if (table[i][j] != "-") {
	            		
	            	
	            	  if (table[i][j] == table[i + 1][j] &&
	                      table[i][j] == table[i + 2][j] &&
	                      table[i][j] == table[i + 3][j]) {
	                      return true;
	                  }
	            	}
	            }
	        }
	        return false;
	    }
	
	public boolean checkDiagonal() {
		
		for (int i = 0; i <= rows - 4; i++) { 
            for (int j = 0; j < cols; j++) { 

            	if (table[i][j] != "-") {
            		
               
            	
            	  if (j <= cols - 4 && 
                      table[i][j] == table[i + 1][j + 1] &&
                      table[i][j] == table[i + 2][j + 2] &&
                      table[i][j] == table[i + 3][j + 3]) {
                      return true;
                  }

                  if (j >= 3 && 
                      table[i][j] == table[i + 1][j - 1] &&
                      table[i][j] == table[i + 2][j - 2] &&
                      table[i][j] == table[i + 3][j - 3]) {
                      return true;
                  }
              }
           } 	
        }
        return false;
    }
		
	
	
	
	public boolean checkWin() {
		if (checkHorizontal() || checkVertical() || checkDiagonal()) {
			return false;
	}else {
		return true;
	}
	
	}
}
