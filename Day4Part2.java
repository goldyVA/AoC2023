import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day4Part2
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    HashMap<Integer, Integer> matches = new HashMap<Integer, Integer>();
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
    for(int a = 0; a < list.size(); a++)
    {
    	
    	String x = list.get(a).substring(list.get(a).indexOf(":")+1);
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
    	
    	matches.put(a+1, count);
    	
    }
    
    System.out.println(matches);
    HashMap<Integer, Integer> cards = new HashMap<Integer,Integer>();
    for (int i : matches.keySet()) 
    {
    	  cards.put(i, 1);
    }
    System.out.println(cards);
    for(int i = 1; i <= list.size(); i++)
    {
    	int matchingNumbers = matches.get(i);
    	int currentCardsOfValue = cards.get(i);
    	for(int j = i +1; j < i + 1 + matchingNumbers; j++)
    	{
    		cards.replace(j,cards.get(j) + currentCardsOfValue);
    	}
    	
    	
    	
    }
    System.out.println(cards);
    
    int sum = 0;
    for (Integer i : cards.values()) 
    {
    	 sum+=i;
    }
    System.out.println(sum);
    
    

  }
}