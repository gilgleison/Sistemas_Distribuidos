import java.rmi.*; 
    
public class CalculatorServer  
{ 
    CalculatorServer() 
    { 
        try
        { 
            Calculator c = new CalculatorImple(); 
            Naming.rebind("CalcRMI", c); 
        }  
        catch (Exception e)  
        { 
            e.printStackTrace(); 
        } 
    } 
    public static void main(String[] args)  
    { 
        new CalculatorServer(); 
    } 
}   