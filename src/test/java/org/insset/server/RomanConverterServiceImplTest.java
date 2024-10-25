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
     * With valid value
     */
    @Test
    public void testConvertDateYears_validValue() {
        //Before
        System.out.println("convertDateYears_ValidValue");
        String nbr = "25/10/2024";
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "XXV/X/MMXXIV";
        
        //When
        String result = instance.convertDateYears(nbr);
        
        //Value
        assertEquals(expResult, result);
    }
    
    /**
     * Test of convertDateYears method, of class RomanConverterServiceImpl.
     * With a date with correct format but incorrect value
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConvertDateYears_invalidDate() {
        //Before
        System.out.println("convertDateYears_InvalidDate");
        String nbr = "32-10-2024";
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        
        //When
        String result = instance.convertDateYears(nbr);
    }
    
    /**
     * Test of convertDateYears method, of class RomanConverterServiceImpl.
     * With a different format than the one expected -> "dd/MM/yyyy"
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConvertDateYears_unexpectedDateFormat() {
        //Before
        System.out.println("convertDateYears_UnexpectedDateFormat");
        String nbr = "25-10-2024";
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        
        //When
        String result = instance.convertDateYears(nbr);
    }
    
    /**
     * Test of convertDateYears method, of class RomanConverterServiceImpl.
     * With a input that is not a date
     */
    @Test(expected=IllegalArgumentException.class)
    public void testConvertDateYears_nonDateInput() {
        //Before
        System.out.println("convertDateYears_NonDateInput");
        String nbr = "random string";
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        
        //When
        String result = instance.convertDateYears(nbr);
    }
    
        /* --- Tests convertArabeToRoman --- */

    /**
     * Test of convertArabeToRoman method, of class RomanConverterServiceImpl.
     * When every roman number is in increasing value order (I->V->X->L...)   
     */
    @Test
    public void testConvertArabeToRoman_inNumericOrder() {
        //Before
        System.out.println("convertArabeToRoman_NumericOrder");
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
        System.out.println("convertArabeToRoman_NonNumericOrder");
        Integer nbr = 49;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "XLIX";
        
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
        System.out.println("convertArabeToRoman_OverLimitValue");
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
        System.out.println("convertArabeToRoman_OverLimitValue");
        Integer nbr = -14;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        
        //When
        String result = instance.convertArabeToRoman(nbr);
    }
    
}
