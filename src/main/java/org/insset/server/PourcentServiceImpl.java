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
    
    /**
     *
     * @param nbr
     * @return
     * @throws IllegalArgumentException
     */
    

    @Override
    public Integer division(Integer nbrA, Integer nbrB) throws IllegalArgumentException {
        int result = nbrA / nbrB;
        return result; 
    }



}
