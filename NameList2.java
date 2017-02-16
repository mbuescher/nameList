import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class NameList2
{
  private List<String> nameList;
  
  public NameList2()
  {
    nameList = new ArrayList<String>();
  }
  
  public void importNames()
  {
    // open the file
    File file = new File("names.txt");
    Scanner input = null;
    try
    {
        input = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
        System.out.println("*** Cannot open the text file ***");
        System.exit(1);        // quit the program
    } 

    // read the names from the file, one per line
    while (input.hasNextLine())
      nameList.add(input.nextLine());
    input.close();
  }
 
  // prints the list of names
  public void printNames()
  {
    for (String name : nameList)
      System.out.println (name);
    System.out.println ("Size: " + nameList.size());
  }
  
  
  public void sortNames ()
  {
    // find the first name
    int minIndex = 0;
    for (int i = 1; i < nameList.size(); i++)
      if (nameList.get(i).compareTo(nameList.get(minIndex)) < 0)
        minIndex = i;
    
    String temp = nameList.remove(minIndex);
    nameList.add (0, temp);
    
    //nameList.add(0, nameList.remove(i));
  }
  
  
  public static void main (String[] args)
  {
    NameList2 apcs = new NameList2();
    apcs.importNames();
    apcs.printNames();
    
    apcs.sortNames();
    apcs.printNames();
   
  }
  
}
    