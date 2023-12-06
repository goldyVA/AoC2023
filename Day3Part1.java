import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day3Part1
{
	
	//numbers are 48 to 57 and . is 46
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day3.txt"));
    	
    	while(scan.hasNextLine())
    	{
    		String temp = scan.nextLine();
    		list.add(temp);
    		
    	}
    }
    catch(Exception e) 
    {	
    }
    
    char[][] grid = new char[list.size()][list.get(0).length()];
    for(int i = 0; i < list.size(); i++)
    {
    	for(int j = 0; j < list.get(i).length(); j++)
    		grid[i][j] = list.get(i).charAt(j);
    }
    
    /*
    for(int r = 0; r < grid.length; r++)
    {
    	for(int c = 0; c < grid[r].length; c++)
    	{
    		if(isNumber(r,c,grid))
			{
				System.out.println(getNumberSequence(r,c,grid));
				c+=getNumberSequenceLength(r,c,grid);
			}
 
    	}
    	
    }
    System.out.println();
    */
    int sum = 0;
    for(int r = 0; r < grid.length; r++)
    {
    	for(int c = 0; c < grid[r].length; c++)
    	{
    		if(isNumber(r,c,grid) && touchesSymbol(r,c,grid))
			{
    			while(c>0 && isNumber(r,c-1,grid))
    			{
    				c--;
    			}
    			String add = "";
    			while(c<grid[r].length && isNumber(r,c,grid))
    			{
    				add += "" + grid[r][c];
    				c++;
    			}
    			sum+=Integer.parseInt(add);
				//System.out.println(add);
			}
    	}
    }
    System.out.println("sum: " + sum);
   
    		
    
  }
  
  public static boolean isNumber(int r, int c, char[][] x)
  {
	  return (int)x[r][c] >= 48 && (int)x[r][c] <=57;
  }
  
  public static boolean isPeriod(int r, int c, char[][] x)
  {
	  return x[r][c] == '.';
  }
  
  public static boolean isSymbol(int r, int c, char[][]x)
  {
	  return !isNumber(r,c,x) && !isPeriod(r,c,x);
  }
  
  public static int getNumberSequenceLength(int r, int c, char[][] x)
  {
	  int count = 0;
	  
	  while(c < x[r].length && isNumber(r,c,x))
	  {
		  count++;
		  c++;
	  }
	  return count;
  }
  
  public static int getNumberSequence(int r, int c, char[][] x)
  {
	  String seq = "";
	  
	  while(c < x[r].length && isNumber(r,c,x))
	  {
		  seq+= ""+x[r][c];
		  c++;
	  }
	  return Integer.parseInt(seq);
  }
  
  public static boolean touchesSymbol(int r, int c, char[][] x)
  {
	  if(r-1 >= 0 && r-1 < x.length && c-1 >= 0 && c-1 < x[r].length)
	  {
		  if(isSymbol(r-1,c-1,x))
			  return true;		  
	  }
	  if(r-1 >= 0 && r-1 < x.length && c >= 0 && c < x[r].length)
	  {
		  if(isSymbol(r-1,c,x))
			  return true;		  
	  }
	  if(r-1 >= 0 && r-1 < x.length && c+1 >= 0 && c+1 < x[r].length)
	  {
		  if(isSymbol(r-1,c+1,x))
			  return true;		  
	  }
	  if(r >= 0 && r < x.length && c-1 >= 0 && c-1 < x[r].length)
	  {
		  if(isSymbol(r,c-1,x))
			  return true;		  
	  }
	  if(r >= 0 && r < x.length && c+1 >= 0 && c+1 < x[r].length)
	  {
		  if(isSymbol(r,c+1,x))
			  return true;		  
	  }
	  if(r+1 >= 0 && r+1 < x.length && c-1 >= 0 && c-1 < x[r].length)
	  {
		  if(isSymbol(r+1,c-1,x))
			  return true;		  
	  }
	  if(r+1 >= 0 && r+1 < x.length && c >= 0 && c < x[r].length)
	  {
		  if(isSymbol(r+1,c,x))
			  return true;		  
	  }
	  if(r+1 >= 0 && r+1 < x.length && c+1 >= 0 && c+1 < x[r].length)
	  {
		  if(isSymbol(r+1,c+1,x))
			  return true;		  
	  }
	  return false;
  }
  
  
  
  
  
 
  
  
  
}