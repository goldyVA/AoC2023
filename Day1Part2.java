import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day1Part2
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    String[] nums = {"1","2","3","4","5","6","7","8","9","one","two","three","four","five","six","seven","eight","nine"};
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
    	int firstIndex=Integer.MAX_VALUE;
    	int lastIndex=-1;
    	String a = "";
    	String b = "";
    	for(String y : nums)
    	{
    		if(x.indexOf(y) != -1 && x.indexOf(y)<firstIndex)
    		{
    			firstIndex = x.indexOf(y);
    		}
    		if(x.lastIndexOf(y) != -1 && x.lastIndexOf(y)>lastIndex)
    		{
    			lastIndex = x.lastIndexOf(y);
    		}
    	}
    	for(String y : nums)
    	{
    		if(x.indexOf(y)==firstIndex)
    			a = y;
    		if(x.lastIndexOf(y) == lastIndex)
    			b = y;
    	}
    	int num1=0;
    	int num2=0;
    	switch(a)
    	{
    	case "one":
    		num1 = 1;
    		break;
    	case "1":
    		num1 = 1;
    		break;
    	case "two":
    		num1 = 2;
    		break;
    	case "2":
    		num1 = 2;
    		break;
    	case "three":
    		num1 = 3;
    		break;
    	case "3":
    		num1 = 3;
    		break;
    	case "four":
    		num1 = 4;
    		break;
    	case "4":
    		num1 = 4;
    		break;
    	case "five":
    		num1 = 5;
    		break;
    	case "5":
    		num1 = 5;
    		break;
    	case "six":
    		num1 = 6;
    		break;
    	case "6":
    		num1 = 6;
    		break;
    	case "seven":
    		num1 = 7;
    		break;
    	case "7":
    		num1 = 7;
    		break;
    	case "eight":
    		num1 = 8;
    		break;
    	case "8":
    		num1 = 8;
    		break;
    	case "nine":
    		num1 = 9;
    		break;
    	case "9":
    		num1 = 9;
    		break;
    	}
    	switch(b)
    	{
    	case "one":
    		num2 = 1;
    		break;
    	case "1":
    		num2 = 1;
    		break;
    	case "two":
    		num2 = 2;
    		break;
    	case "2":
    		num2 = 2;
    		break;
    	case "three":
    		num2 = 3;
    		break;
    	case "3":
    		num2 = 3;
    		break;
    	case "four":
    		num2 = 4;
    		break;
    	case "4":
    		num2 = 4;
    		break;
    	case "five":
    		num2 = 5;
    		break;
    	case "5":
    		num2 = 5;
    		break;
    	case "six":
    		num2 = 6;
    		break;
    	case "6":
    		num2 = 6;
    		break;
    	case "seven":
    		num2 = 7;
    		break;
    	case "7":
    		num2 = 7;
    		break;
    	case "eight":
    		num2 = 8;
    		break;
    	case "8":
    		num2 = 8;
    		break;
    	case "nine":
    		num2 = 9;
    		break;
    	case "9":
    		num2 = 9;
    		break;
    	}
    	
    	int value = Integer.parseInt(num1+""+num2);
    	sum+=value;
    	
    }
    System.out.println(sum);
    
    
    

  }
}