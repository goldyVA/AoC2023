import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.math.BigInteger;
import java.util.*; // Import the Scanner class to read text files

public class Day6Part2
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
 
    int times = 38947970;
    BigInteger distances = new BigInteger("241154910741091");
   
   int count = 0;
   for(int i = 0; i < times; i++)
   {
	   long speed = (long)i;
	   long release = times - speed;
	   
	   BigInteger trav = new BigInteger(""+speed);
	   trav = trav.multiply(new BigInteger(""+release));
	   long traveled = speed * release;
	   if(distances.subtract(new BigInteger(""+traveled)).compareTo(new BigInteger("0"))<0)
	   {
		   count++;
	   } 
   }
   System.out.println(count);  
  }  
}