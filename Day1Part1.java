import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day1Part1
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day1.txt"));
    	
    	while(scan.hasNextLine())
    	{
    		String temp = scan.nextLine();
    		list.add(temp);
    		
    	}
    }
    catch(Exception e) 
    {	
    }
    
    int sum = 0;
    for(String x: list)
    {
    	char first = ' ';
    	char second = ' ';
    	for(int i = 0; i < x.length(); i++)
    	{
    		if((int)x.charAt(i)<58)
    		{
    			first = x.charAt(i);
    			break;
    		}
    	}
    	for(int i = x.length()-1; i >=0; i--)
    	{
    		if((int)x.charAt(i)<58)
    		{
    			second = x.charAt(i);
    			break;
    		}
    	}
    	String combine = first +""+ second;
    	sum += Integer.parseInt(combine);
    		
    			
    }
    System.out.println(sum);
    
    
    

  }
}