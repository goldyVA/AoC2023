import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files
import java.util.Map.Entry;

public class Day3Part2
{
	
	//numbers are 48 to 57 and . is 46
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> stars2 = new ArrayList<String>();
    HashMap<Integer, String> stars = new HashMap<Integer,String>();
    ArrayList<String> points = new ArrayList<String>();
    
    try 
    {
    	//Scanner scan = new Scanner(new File("day3practice.txt"));
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
    
 

   
    for(int r = 0; r < grid.length; r++)
    {
    	for(int c = 0; c < grid[r].length; c++)
    	{
    		if(isNumber(r,c,grid) && !touchesStar(r,c,grid).equals("-1"))
			{
    			String star = touchesStar(r,c,grid);
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
    			stars.put(Integer.parseInt(add), star);
    			stars2.add(add + " " + star);
    			points.add(star);
    			//sum+=Integer.parseInt(add);
				//System.out.println(add);
			}
    	}
    }
    
    System.out.println("stars"+stars);
    Collections.sort(points);
    System.out.println(points);
    for(int i = 0; i < points.size()-1; i++)
    {
    	if(!points.get(i).equals(points.get(i+1)))
    	{
    		points.remove(i);
    		i--;
    	}
    }
    points.remove(points.size()-1);
    System.out.println(points);
    long product = 0;
    long product2 = 0;
    for(int i = 0; i < points.size(); i++)
    {
    	String temp = points.get(i);
    	String values = points.get(i)+"    ";
    	long tempProduct = 1;
    	long tempProduct2 = 1;
    	for (Entry<Integer, String> entry : stars.entrySet()) 
        {
    		if(entry.getValue().equals(temp))
    		{
    			values+=""+entry.getKey()+ "and";
    			tempProduct*=entry.getKey();
    		}
        }
    	for(String x: stars2)
    	{
    		if(x.substring(x.indexOf(" ")+1).equals(temp))
    		{
    			tempProduct2*=Integer.parseInt(x.substring(0,x.indexOf(" ")));
    		}
    	}
    	System.out.println(tempProduct +"     " + values);
    	System.out.println(tempProduct2 +"     " + values);
    	product += tempProduct;
    	product2 += tempProduct2;
    }
    System.out.println(product);
    System.out.println(product2);
    System.out.println(points.size());
    
   
    		
    
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
  
  public static boolean isStar(int r, int c, char[][]x)
  {
	  return x[r][c] == '*';
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
  
  public static String touchesStar(int r, int c, char[][] x)
  {
	  if(r-1 >= 0 && r-1 < x.length && c-1 >= 0 && c-1 < x[r].length)
	  {
		  if(isStar(r-1,c-1,x))
			  return ""+(r-1)+","+(c-1);		  
	  }
	  if(r-1 >= 0 && r-1 < x.length && c >= 0 && c < x[r].length)
	  {
		  if(isStar(r-1,c,x))
			  return ""+(r-1)+","+(c);	  
		  }
	  if(r-1 >= 0 && r-1 < x.length && c+1 >= 0 && c+1 < x[r].length)
	  {
		  if(isStar(r-1,c+1,x))
			  return ""+(r-1)+","+(c+1);	  
	  }
	  if(r >= 0 && r < x.length && c-1 >= 0 && c-1 < x[r].length)
	  {
		  if(isStar(r,c-1,x))
			  return ""+(r)+","+(c-1);
	  }
	  if(r >= 0 && r < x.length && c+1 >= 0 && c+1 < x[r].length)
	  {
		  if(isStar(r,c+1,x))
			  return ""+(r)+","+(c+1);	  
	  }
	  if(r+1 >= 0 && r+1 < x.length && c-1 >= 0 && c-1 < x[r].length)
	  {
		  if(isStar(r+1,c-1,x))
			  return ""+(r+1)+","+(c-1);	  
	  }
	  if(r+1 >= 0 && r+1 < x.length && c >= 0 && c < x[r].length)
	  {
		  if(isStar(r+1,c,x))
			  return ""+(r+1)+","+(c);	  
	  }
	  if(r+1 >= 0 && r+1 < x.length && c+1 >= 0 && c+1 < x[r].length)
	  {
		  if(isStar(r+1,c+1,x))
			  return ""+(r+1)+","+(c+1);	  
	  }
	  return "-1";
  }
  
  
  
  
  
  
  
  
 
  
  
  
}