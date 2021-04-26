import java.rmi.*; 
    
public class ChatServer  
{ 
    ChatServer() 
    { 
        try
        { 
            Chat c = new ChatImple(); 
            Naming.rebind("ChatRMI", c); 
            
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
    public static void main(String[] args)  
    { 
        new ChatServer(); 
    } 
}   