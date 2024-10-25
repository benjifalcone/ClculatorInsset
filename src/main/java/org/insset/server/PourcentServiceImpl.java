/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.PourcentageService;

/**
 *
 * @author insset
 */
@SuppressWarnings("serial")
public class PourcentServiceImpl extends RemoteServiceServlet implements
        PourcentageService {

    @Override
    public Float remise(Float prix, Long remise) throws IllegalArgumentException {
        if (prix < 0) {
            throw new IllegalArgumentException("Le prix ne peut être négatif.");
        }
        
        if (remise < 0 || remise > 100) {
            throw new IllegalArgumentException("La remise doit être comprise entre 0 et 100%.");
        }
        
        float tempValue = prix * remise / 100;
        int finalValue = (int) Math.floor(tempValue * 100);
        
        return ((float) finalValue / 100);
    }


}
