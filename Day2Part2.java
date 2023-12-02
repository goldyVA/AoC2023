import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day2Part2
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day2.txt"));
    	
    	while(scan.hasNextLine())
    	{
    		String temp = scan.nextLine();
    		list.add(temp);
    		
    	}
    }
    catch(Exception e) 
    {	
    }
    
    
    int GREEN = 13;
    int BLUE = 14;
    int RED = 12;
    long
    sum = 0;
    for(int i = 0; i < list.size(); i++)
    {
    	int red = 0;
    	int green = 0;
    	int blue = 0;
    	String x = list.get(i);
    	x=x.substring(x.indexOf(":")+2);
    	String temp = "";
    	for(int j = 0; j < x.length(); j++)
    	{
    		if(x.charAt(j) == ';')
    			temp+= ",";
    		else
    			temp+= x.charAt(j);
    	}
    		
    	String[] games = temp.split(", ");
    	
    	for(String y: games)
    	{
    		int count = Integer.parseInt(y.substring(0, y.indexOf(" ")));
    		String color = y.substring(y.indexOf(" ") + 1);
    		if(color.equals("red") && count > red)
    			red = count;
    		else if(color.equals("green") && count > green)
    			green = count;
    		else if(color.equals("blue") && count > blue)
    			blue = count;
    	}
    
    	long power = red * green * blue;
    	sum += power;
	
    }
    System.out.println(sum);
    
    
    
    

  }
}