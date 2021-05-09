/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.service;

import com.test.dao.InterfacePersonImplement;
import com.test.models.Persona;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class PersonaService {
    
    private InterfacePersonImplement interfacePersonImplement;
    
    public PersonaService(){
        interfacePersonImplement = new InterfacePersonImplement();
    }
    
    public Persona addPerson(Persona person){
        return interfacePersonImplement.addPerson(person);
    }
    
    public String deletePerson(int id){
        return interfacePersonImplement.deletePerson(id);
    }
    
    public boolean updatePerson(int id, Persona person){
        return interfacePersonImplement.updatePerson(id, person);
    }
    
    public Persona getPerson(int id){
        return interfacePersonImplement.getPerson(id);
    }
    
    public List<Persona> getListPersons(){
        return interfacePersonImplement.getListPersons();
    }
   
    
}
