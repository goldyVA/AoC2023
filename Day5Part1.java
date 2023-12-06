import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day5Part1
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day5.txt"));
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
    
    String[] s = list.get(0).substring(list.get(0).indexOf(" ")+1).split(" ");
 
    
    ArrayList<String> seedToSoil = new ArrayList<String>();
    ArrayList<String> soilToFertilizer = new ArrayList<String>();
    ArrayList<String> fertilizerToWater = new ArrayList<String>();
    ArrayList<String> waterToLight = new ArrayList<String>();
    ArrayList<String> lightToTemperature = new ArrayList<String>();
    ArrayList<String> temperatureToHumidity = new ArrayList<String>();
    ArrayList<String> humidityToLocation = new ArrayList<String>();
    
    
    for(int i = findStart(list,"seed-to-soil map:")+1; i < findNextEmpty(list,findStart(list,"seed-to-soil map:")); i++)
    {
    	seedToSoil.add(list.get(i));
    }
    for(int i = findStart(list,"soil-to-fertilizer map:")+1; i < findNextEmpty(list,findStart(list,"soil-to-fertilizer map:")); i++)
    {
    	soilToFertilizer.add(list.get(i));
    }
    for(int i = findStart(list,"fertilizer-to-water map:")+1; i < findNextEmpty(list,findStart(list,"fertilizer-to-water map:")); i++)
    {
    	fertilizerToWater.add(list.get(i));
    }
    for(int i = findStart(list,"water-to-light map:")+1; i < findNextEmpty(list,findStart(list,"water-to-light map:")); i++)
    {
    	waterToLight.add(list.get(i));
    }
    for(int i = findStart(list,"light-to-temperature map:")+1; i < findNextEmpty(list,findStart(list,"light-to-temperature map:")); i++)
    {
    	lightToTemperature.add(list.get(i));
    }
    for(int i = findStart(list,"temperature-to-humidity map:")+1; i < findNextEmpty(list,findStart(list,"temperature-to-humidity map:")); i++)
    {
    	temperatureToHumidity.add(list.get(i));
    }
    for(int i = findStart(list,"humidity-to-location map:")+1; i < list.size(); i++)
    {
    	humidityToLocation.add(list.get(i));
    }
    /*
    System.out.println(seedToSoil);
    System.out.println(soilToFertilizer);
    System.out.println(fertilizerToWater);
    System.out.println(waterToLight);
    System.out.println(lightToTemperature);
    System.out.println(temperatureToHumidity);
    System.out.println(humidityToLocation);
    */
    
   long min = Long.MAX_VALUE;
    for(String x: s)
    {
    	long seedNumber = Long.parseLong(x);
    	long soilNumber = getCorrespond(seedToSoil, seedNumber);
        long fertilizerNumber = getCorrespond(soilToFertilizer, soilNumber);
        long waterNumber = getCorrespond(fertilizerToWater, fertilizerNumber);
        long lightNumber = getCorrespond(waterToLight, waterNumber);
        long temperatureNumber = getCorrespond(lightToTemperature, lightNumber);
        long humidityNumber = getCorrespond(temperatureToHumidity, temperatureNumber);
        long locationNumber = getCorrespond(humidityToLocation, humidityNumber);
        if(locationNumber < min)
        	min = locationNumber;
        
        
    }
    System.out.println(min);

    

  }
  
  public static int findStart(ArrayList<String> l, String x)
  {
	  for(int i = 0; i <l.size(); i++) 
	  {
		  if(l.get(i).equals(x))
			  return i;
	  }
	  return -1;
  }
  public static int findNextEmpty(ArrayList<String> l, int start)
  {
	  for(int i = start; i <l.size(); i++) 
	  {
		  if(l.get(i).equals(""))
			  return i;
	  }
	  return -1;
  }
  
  public static long getCorrespond(ArrayList<String> list, long value)
  {
	  for(int i = 0; i < list.size(); i++)
	  {
		  String[] temp = list.get(i).split(" ");
		  long destinationStart = Long.parseLong(temp[0]);
		  long sourceStart = Long.parseLong(temp[1]);
		  long range = Long.parseLong(temp[2]);
		  //System.out.println(destinationStart);
		  //System.out.println(sourceStart);
		  //System.out.println(range);
		  
		  if(value >= sourceStart && value < sourceStart + range)
		  {
			  long difference = value - sourceStart;
			  return destinationStart + difference;  
		  }
	  }
	  return value;
  }
  
  
  
}