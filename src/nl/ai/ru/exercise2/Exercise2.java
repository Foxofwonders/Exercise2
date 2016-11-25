package nl.ai.ru.exercise2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Exercise2
{
  public static void main(String [] arguments) throws IOException
  {
    ArrayList<Character> source=new ArrayList<Character>();
    ArrayList<Character> destination=new ArrayList<Character>();
    readFromFile(source, "AliceSorted.txt");
    
    int numberOfComparisons=removeSortedDuplicates(source,destination);
//    System.out.printf("Source: %s\n",source);
//    System.out.printf("Destination: %s\n",destination);
    System.out.printf("%d comparisons made\n",numberOfComparisons);
  }
  
  private static void readFromFile(ArrayList<Character> source, String fileName) throws IOException
  {
	  FileInputStream input = new FileInputStream (fileName);
	  int c;
	  while ((c =input.read())>=0)
	  {
		  source.add((char) c);
	  }
  }
  
  /* 1.2
   * Runtime complexity O(n^2) with n the number of elements of the first Arraylist argument.
   * 
   * In this case n is the number of elements in source.
   * For each element of the source, the for-loop runs once (making the order O(n)). When it does so, it executes 'addWithoutDuplicates',
   * which compares the given character to every other character in the arraylist also O(n).
   * Because it executes O(n) times O(n), the total run-time order is O(n)*O(n)=O(n^2).
   * 
   * 1.3
   * Reduce the order of run-time complexity
   * 
   * If the ArrayList is sorted in alphabetic order, it is not necessary to compare the element of the source 
   * to every element of the destination ArrayList, but just the last one. Thus a if-statement is totally sufficient 
   * and the other loop, which caused the O(n^2) order is not needed anymore. Hence the order is now O(n).
   * 
   */
/**
 * Copies Characters from source array to destination array, without duplicates
 * @param source
 * @param destination
 * @return number of comparisons made
 */
  private static int removeDuplicates(ArrayList<Character> source, ArrayList<Character> destination)
  {
    assert source!=null : "Source array should be initialized";
    assert destination!=null : "Destination array should be initialized";
    int numberOfComparisons=0;
    for(int i=0;i<source.size();i++)
      numberOfComparisons+=addWithoutDuplicates(source.get(i),destination);
    return numberOfComparisons;
  }
  
  /**
   * Copies Characters from sorted source array to destination array, without duplicates
   * @param sortedSource
   * @param destination
   * @return number of comparisons made
   */
    private static int removeSortedDuplicates(ArrayList<Character> sortedSource, ArrayList<Character> destination)
    {
      assert sortedSource!=null : "Source array should be initialized";
      assert destination!=null : "Destination array should be initialized";
      int numberOfComparisons=0;
      int pos = 0;
      destination.add(sortedSource.get(pos));
      for(int i=0;i<sortedSource.size();i++) 
    	  // checks for each element of the source ArrayList, if it is equal to the last element of the destination ArrayList 
    	  
      {
    	numberOfComparisons++;
        if(sortedSource.get(i)!=destination.get(pos))
        	// if it is not the same, then the element is not in the destination ArrayList yet, so we add it now
        { 
        	destination.add(sortedSource.get(i));
        	pos++;
        }
      }   
      return numberOfComparisons;
    }
    

  /**
   * Copy a character to the destination array, without duplicates
   * @param character
   * @param destination
   * @return number of comparisons made
   */
  private static int addWithoutDuplicates(Character character, ArrayList<Character> destination)
  {
    assert destination!=null : "Destination array should be initialized";
    int i=0;
    while(i<destination.size() && destination.get(i)!=character)
      i++;
    if(i==destination.size())
      destination.add(character);
    return i;
  }
  
  /**
   * Fills the source character array with the contents of the specified string
   * @param source
   * @param string
   */
//  private static void fill(ArrayList<Character> source, String string)
//  {
//    assert source!=null : "Source array should be initialized";
//    for(int i=0;i<string.length();i++)
//      source.add(i,string.charAt(i));
//  }
//
}
