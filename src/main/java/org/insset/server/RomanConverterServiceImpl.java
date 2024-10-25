/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.TreeMap;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        //Implement your code
        return 3;
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        //On vérifie que la valeur soit entre 1 et 3000
        if (nbr > 3000 || nbr < 1) {
            throw new IllegalArgumentException("Le nombre doit être compris strictement entre 1 et 3000.");
        }
        return this.oneArabNumberToRoman(nbr);
    }
    
    
    private String oneArabNumberToRoman(Integer nbr) {
        //Création de la table de correspondance nombre Arabe - Romain
        TreeMap<Integer, String> romanArabMap = new TreeMap<Integer, String>();
        
        //Remplissage de 1 (I) à 1000 (M)
        romanArabMap.put(1000, "M");
        romanArabMap.put(900, "CM");
        romanArabMap.put(500, "D");
        romanArabMap.put(400, "CD");
        romanArabMap.put(100, "C");
        romanArabMap.put(90, "XC");
        romanArabMap.put(50, "L");
        romanArabMap.put(40, "XL");
        romanArabMap.put(10, "X");
        romanArabMap.put(9, "IX");
        romanArabMap.put(5, "V");
        romanArabMap.put(4, "IV");
        romanArabMap.put(1, "I");  
        
        //Création de la valeur d'arrivée et conversion
        String nbRoman = "";
        
        while(nbr > 0) {
            int nextValue = romanArabMap.floorKey(nbr);
            nbRoman += romanArabMap.get(nextValue);
            nbr -= nextValue;
        }
        
        return nbRoman;
    }

}
