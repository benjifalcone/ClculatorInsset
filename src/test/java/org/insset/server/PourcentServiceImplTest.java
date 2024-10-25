/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import static org.junit.Assert.*;


/**
 *
 * @author insset
 */
public class PourcentServiceImplTest {
    
    
    
    public void TestDivision_Valid() {
        //before
        System.out.println("Division_Valid");
        long dividende = 10L;
        long diviseur = 2L;
        PourcentServiceImpl instance = new PourcentServiceImpl();
        long expResult = 5;
        
        //when
        boolean result = instance.division(dividende, diviseur);
        
        //value
        assertEquals(expResult, result);  
        
    }
    
    public void TestDivision_byzero() {
        //before
        System.out.println("Division_Byzero");
        long dividende = 0L;
        long diviseur = 2L;
        PourcentServiceImpl instance = new PourcentServiceImpl();
        String expResult = "Impossible de diviser part 0";
        
        //when
        boolean result = instance.division(dividende, diviseur);
        
        //value
        assertEquals(expResult, result); 
        
    }
    
    public void TestRemise_Valid() {
        //before
        System.out.println("Remise_Valid");
        float prix = 25f;
        long remise = 43L;
        PourcentServiceImpl instance = new PourcentServiceImpl();
        float expResult = 10.75f;
        
        //when
        boolean result = instance.remise(prix, remise);
        
        //value
        assertEquals(expResult, result); 
        
    }
    
    public void TestRemise_SupCent() {
        //before
        System.out.println("Remise_SupCent");
        float prix = 50f;
        long remise = 102L;
        PourcentServiceImpl instance = new PourcentServiceImpl();
        String expResult = "Impossible d'avoir une remise superieur a 100%";
        
        //when
        boolean result = instance.remise(prix, remise);
        
        //value
        assertEquals(expResult, result); 
        
    }
    
    public void TestRemise_Float() {
        //before
        System.out.println("Remise_Float");
        float prix = 9.99f;
        long remise = 25L;
        PourcentServiceImpl instance = new PourcentServiceImpl();
        float expResult = 2.49f;
        
        //when
        boolean result = instance.Remise(prix, remise);
        
        //value
        assertEquals(expResult, result); 
        
    }
    
    /*public void TestRemise_Float_Remise() {
        //before
        System.out.println("Remise_Float_Remise");
        float prix = 15;
        float remise = 45.6f;
        PourcentServiceImpl instance = new PourcentServiceImpl();
        String expResult = "Impossible d'avoir une remise a virgule";
        
        //when
        boolean result = instance.Remise(prix, remise);
        
        //value
        assertEquals(expResult, result); 
        
    }*/
    
    public void TestRemise_Negative_Remise() {
        //before
        System.out.println("Remise_Negative_Remise");
        float prix = 15;
        long remise = -30;
        PourcentServiceImpl instance = new PourcentServiceImpl();
        String expResult = "Impossible d'avoir une remise negative";
        
        //when
        boolean result = instance.Remise(prix, remise);
        
        //value
        assertEquals(expResult, result); 
        
    }
    
    
    
}
