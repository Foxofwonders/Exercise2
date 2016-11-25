package nl.ai.ru.exercise2;

import java.io.IOException;
import java.util.ArrayList;

public class Exercise2
{
  public static void main(String [] arguments) throws IOException
  {
    ArrayList<Character> source=new ArrayList<Character>();
    ArrayList<Character> destination=new ArrayList<Character>();
    fill(source,"Alice was beginning to get very tired of sitting by her sister on the bank");
    int numberOfComparisons=removeDuplicates(source,destination);
    System.out.printf("Source: %s\n",source);
    System.out.printf("Destination: %s\n",destination);
    System.out.printf("%d comparisons made\n",numberOfComparisons);
  }
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
  private static void fill(ArrayList<Character> source, String string)
  {
    assert source!=null : "Source array should be initialized";
    for(int i=0;i<string.length();i++)
      source.add(i,string.charAt(i));
  }

}
