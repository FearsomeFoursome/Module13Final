

package MenuSelection;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Benny
 */
public class Menu {
    @SuppressWarnings({"empty-statement", "IncompatibleEquals"})
    public static void main(String[] args) {
    // Local variable
   String swValue = "";          ;
       
    

     //Display menu graphics
    
  Menu2 selection = new Menu2();
       
                BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
              
        //Run the program until user enters "4"
        
        try
        {
           
            
            while (!"5".equals(selection.Choice()))
            {
                
            
            if("5".equals(selection.Choice()))         // user enters "4"
                continue;
            
    System.out.println("============================");
    System.out.println("|   Olympic Pride Store    |");
    System.out.println ("Hello James, Welcome to Olympic Store");
    System.out.println("============================");
    System.out.println("| Options:                 |");
    System.out.println("|        1. Log IN         |");
    System.out.println("|        2. VIEW CATALOG   |");
    System.out.println("|        3. VIEW CART      |");
    System.out.println("|        4. UPDATE ORDER   |");
    System.out.println("|        5. EXIT           |"); 
    System.out.println("============================");
    System.out.println(" Select option: ");
  selection.readSelection( brin.readLine());
    // Switch construct
    switch (swValue) {
    case "1":
      System.out.println("LOG IN selected");
      System.out.println("Hello James");
      System.out.println(("\n How Are you?"));
      break;
    case "2":
      System.out.println("VIEW CATALOG selected");
      System.out.println("============================");
     break;
    case "3":
      System.out.println("VIEW CART selected");
      break;
    case "4" :
        System.out.println("UPDATE ORDER selected");
        break;
    case "5" :
        System.out.println("Exit");
        break;
    default:
     // System.out.println("Invalid selection");
        
            selection.readSelection( brin.readLine());
                      // user enters "4"
                if("5".equals(selection.Choice()))        
                    continue;
    }
            }
        }
catch (IOException | NumberFormatException e) 
            {
                System.out.println ("Error:" + e);
            }       // end catch
        
    }}



