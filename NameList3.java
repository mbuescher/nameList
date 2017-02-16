import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class NameList3
{
  private List<String> nameList;
  
  // No-args constructor makes a blank list
  public NameList3()
  {
    nameList = new ArrayList<String>();
  }
  
  // Constructor that takes a List of Strings
  public NameList3(ArrayList<String> names)
  {
    nameList = names;
  }
  
  // Import the names from a text file
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
    Scanner kbd = new Scanner(System.in);
    String s;  
    
    for (int pos = 0; pos < nameList.size() - 1; pos++)
    {
      int minIndex = pos;
      for (int i = pos + 1; i < nameList.size(); i++)
        if (nameList.get(i).compareTo(nameList.get(minIndex)) < 0)
          minIndex = i;
    
      String temp = nameList.remove(minIndex);
      nameList.add (pos, temp);
    
      //nameList.add(pos, nameList.remove(i));
      
/*      printNames();
      System.out.print ("<ENTER> to see the next iteration.");
      s = kbd.nextLine();  */
    }
    
    kbd.close();
  }
  
  public ArrayList<String> randomList()
  {
    Scanner kbd = new Scanner(System.in);
    String dummy;

    ArrayList<String> oldList = new ArrayList<String>();
    ArrayList<String> newList = new ArrayList<String>();
    
    for (String s : nameList)         // copies the nameList into oldList
      oldList.add(s);
    
    while (oldList.size() > 0)
    {
      int n = (int)(Math.random() * oldList.size());
      String temp = oldList.remove(n);
      newList.add(temp);
      
      // Print both oldList and newList; get user input to continue
      System.out.println("oldList \t\tnewList");
      System.out.println("Size = " + oldList.size() + "\t\tSize = " + newList.size());
      System.out.println("------- \t\t-------");
      for (int i = 0; i < Math.max(oldList.size(), newList.size()); i++)
      {
        if (i < oldList.size())                          // if there are items still in oldList
          System.out.print(oldList.get(i) + "    \t\t");  // print that item
        else
          System.out.print("\t\t\t");                    // otherwise print blank space (tabs)
        
        if (i < newList.size())                          // if there are items still in newList
          System.out.println(newList.get(i));            // print that item
        else
          System.out.println();                          // otherwise just go to the next line
      }
      System.out.println("<ENTER> for the next iteration ...");
      dummy = kbd.nextLine();
    }
    
    kbd.close();
    return newList;
  }
  
  
  public static void main (String[] args)
  {
    NameList3 apcs = new NameList3();
    apcs.importNames();
    apcs.printNames();
    
//    apcs.sortNames();
    NameList3 randomly = new NameList3(apcs.randomList());
    randomly.printNames();
   
  }
  
}
    