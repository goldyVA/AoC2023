import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day4Part1
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day4.txt"));
    	
    	while(scan.hasNextLine())
    	{
    		String temp = scan.nextLine();
    		list.add(temp);
    		
    	}
    }
    catch(Exception e) 
    {	
    }
    
    int total = 0;
    for(String x: list)
    {
    	x = x.substring(x.indexOf(":")+1);
    	String first = x.substring(0,x.indexOf("|"));
    	String second = x.substring(x.indexOf("|")+1);
    	
    	String[] winners = first.split(" ");
    	String[] cards = second.split(" ");
 
    	for(int i = 0; i < winners.length; i++)
    	{
    		winners[i] = winners[i].trim();
    	}
    	for(int i = 0; i < cards.length; i++)
    	{
    		cards[i] = cards[i].trim();
    	}
    	
    	ArrayList<String> wins = new ArrayList<String>();
    	ArrayList<String> cars = new ArrayList<String>();
    	for(String y: winners)
    	{
    		if(y.length()>0)
    		{
    			wins.add(y);
    		}
    	}
    	for(String y: cards)
    	{
    		if(y.length()>0)
    			cars.add(y);
    	}
    	
    	
    	int count = 0;
    	for(String y: cars)
    	{
    		if(wins.contains(y))
    			count++;
    	}
    	System.out.println(count);
    	
    	if(count > 0)
    	{
    		total += Math.pow(2,count-1);
    	}
    	
    }
    
    System.out.println("Total: "+ total);
    
    

  }
}