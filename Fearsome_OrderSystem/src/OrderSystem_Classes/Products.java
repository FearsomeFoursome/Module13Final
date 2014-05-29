/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderSystem_Classes;

/**
 *
 * @author Gregory
 */
public class Products {
    
    private int ProductID;
    private String ProductName;
    private String ProductDescription;
    private int Weight;
    private double Price;
    
    // Constructor
    
    public Products (int ProdID, String ProdName, String ProdDesc, int ProdWeight, double ProdPrice) {
        
        ProductID = ProdID;
        ProductName = ProdName;
        ProductDescription = ProdDesc;
        Weight = ProdWeight;
        Price = ProdPrice;
    }
}
