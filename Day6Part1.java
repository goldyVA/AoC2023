import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day6Part1
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day6.txt"));
    	//Scanner scan = new Scanner(new File("day5.txt"));
    	
    	while(scan.hasNextLine())
    	{
    		String temp = scan.nextLine();
    		list.add(temp);
    		
    	}
    }
    catch(Exception e) 
    {	
    }
    
    int[] times = {38  ,   94   ,  79   ,  70};
    int[] distances = {241 ,  1549  , 1074 ,  1091};
   
   long product = 1;
   for(int i = 0; i < times.length; i++)
   {
	   int count = 0;
	   int time = times[i];
	   int distance = distances[i];
	   for(int j = 0; j <= time; j++)
	   {
		   int speed = j;
		   int release = time - speed;
		   int traveled = speed * release;
		   if(traveled > distance)
			   count++;
		   
	   }
	   product *= (long) count;   
   }
   System.out.println(product);
  } 
}