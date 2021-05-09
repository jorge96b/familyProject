/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dao.interfaces;

import com.test.models.Hijo;
import java.util.List;

/**
 *
 * @author Jorge
 */
public interface HijoInterface {
    
    public Hijo addHijo(Hijo hijo);
    public String deleteHijo(int id);
    public boolean updateHijo(int id, Hijo hijo);
    public Hijo getHijo(int id);
    public List<Hijo> getListHijo();
}
