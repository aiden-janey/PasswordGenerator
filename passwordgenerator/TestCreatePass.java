/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgenerator;

/**
 *
 * @author Aiden Janey
 */
public class TestCreatePass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CreatePass c = new CreatePass();
        
        c.passwdLength("Short");
        
        int r = 0;
        
        String result = null, expResult = "5555555555";
        
        while(!(expResult.equals(result)))
        {
            result = c.withSpecial();
            r++;
        }
        System.out.println(r + " attempts");
    }
    
}
