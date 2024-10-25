/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author insset
 */
public class RomanConverterServiceImplTest {
    
    public RomanConverterServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /* --- Tests convertDateYears --- */
    
    /**
     * Test of convertDateYears method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertDateYears() {
        System.out.println("convertArabeToRoman");
        String nbr = "";
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "";
        String result = instance.convertDateYears(nbr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
        /* --- Tests convertArabeToRoman --- */

    /**
     * Test of convertArabeToRoman method, of class RomanConverterServiceImpl.
     * When every roman number is in increasing value order (I->V->X->L...)   
     */
    @Test
    public void testConvertArabeToRoman_inNumericOrder() {
        //Before
        System.out.println("convertDateYears_NumericOrder");
        Integer nbr = 12;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "XII";
        
        //When
        String result = instance.convertArabeToRoman(nbr);
        
        //Assert
        assertEquals(expResult, result);
    }
    
    /**
     * Test of convertArabeToRoman method, of class RomanConverterServiceImpl.
     * When every roman number is not necessary in increasing value order (I->V->X->L...)   
     */
    @Test
    public void testConvertArabeToRoman_inNonNumericOrder() {
        //Before
        System.out.println("convertDateYears_NonNumericOrder");
        Integer nbr = 49;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "IL";
        
        //When
        String result = instance.convertArabeToRoman(nbr);
        
        //Assert
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of convertArabeToRoman method, of class RomanConverterServiceImpl.
     * When every roman number is not necessary in increasing value order (I->V->X->L...)   
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConvertArabeToRoman_overLimitValue() {
        //Before
        System.out.println("convertDateYears_OverLimitValue");
        Integer nbr = 3207;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        
        //When
        String result = instance.convertArabeToRoman(nbr);
    }
    
    /**
     * Test of convertArabeToRoman method, of class RomanConverterServiceImpl.
     * When every roman number is not necessary in increasing value order (I->V->X->L...)   
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConvertArabeToRoman_underLimitValue() {
        //Before
        System.out.println("convertDateYears_OverLimitValue");
        Integer nbr = -14;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        
        //When
        String result = instance.convertArabeToRoman(nbr);
    }
    
}
