/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dao.interfaces;

import com.test.models.Persona;
import java.util.List;

/**
 *
 * @author Jorge
 */
public interface PersonInterface {
    
    public Persona addPerson(Persona person);
    public String deletePerson(int id);
    public boolean updatePerson(int id, Persona person);
    public Persona getPerson(int id);
    public List<Persona> getListPersons();
    
}
