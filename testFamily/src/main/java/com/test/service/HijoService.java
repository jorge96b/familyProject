/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.service;

import com.test.dao.InterfaceHijosImplement;
import com.test.dao.InterfacePersonImplement;
import com.test.models.Hijo;
import com.test.models.Persona;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class HijoService {

    private InterfaceHijosImplement interfaceHijosImplement;
    
     public HijoService(){
        interfaceHijosImplement = new InterfaceHijosImplement();
    }
    
    public Hijo addPerson(Hijo hijo){
        return interfaceHijosImplement.addHijo(hijo);
    }
    
    public String deletePerson(int id){
        return interfaceHijosImplement.deleteHijo(id);
    }
    
    public boolean updatePerson(int id, Hijo hijo){
        return interfaceHijosImplement.updateHijo(id, hijo);
    }
    
    public Hijo getHijo(int id){
        return interfaceHijosImplement.getHijo(id);
    }
    
    public List<Hijo> getListHijos(){
        return interfaceHijosImplement.getListHijo();
    }    
}

