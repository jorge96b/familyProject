/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dao;

import com.test.dao.interfaces.HijoInterface;
import com.test.dao.interfaces.PersonInterface;
import com.test.models.Hijo;
import com.test.models.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class InterfaceHijosImplement implements HijoInterface {
    
    @Override
    public Hijo addHijo(Hijo hijo) {
        DataBase dataBase = new DataBase();
        try{
           
            String sql = "INSERT INTO test.children (`idChildren`, `fullName`, brithday, sexo, `idDad`, `idMom`) ";
            sql += " values(";
            sql += hijo.getIdChildren()+",";
            sql += "'"+ hijo.getFullName() + "',";
            sql += "'"+ hijo.getBirthday() + "',";
            sql += "'"+ hijo.getSexo() + "',";
            sql += hijo.getIdDad() + ",";
            sql += hijo.getIdMom() + ");";
            
            PreparedStatement stmt = dataBase.connection.prepareStatement(sql);
            stmt.executeUpdate(sql);
            return hijo;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return hijo;
    }

    @Override
    public String deleteHijo(int id) {
        try{
            DataBase dataBase = new DataBase();
            String sql = "DELETE FROM children where idChildren="+id;
            PreparedStatement stmt = dataBase.connection.prepareStatement(sql);
            stmt.executeUpdate(sql); 
            return "Se elimino la persona con el id"+id;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return "No se pudo eliminar la persona con el id"+id;
        
    }

    @Override
    public boolean updateHijo(int idHijo, Hijo hijo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hijo getHijo(int id) {
        Hijo hijo = new Hijo();
        try{
            DataBase dataBase = new DataBase();
            Statement stmt = dataBase.connection.createStatement();
            String sql = "SELECT * FROM children where idChildren="+id;
            ResultSet result = stmt.executeQuery(sql); 
            while(result.next()){
                hijo = new Hijo();
                hijo.setIdChildren(result.getInt("idChildren"));
                hijo.setFullName(result.getString("fullName"));
                hijo.setBirthday(result.getString("brithday"));
                hijo.setSexo(result.getString("sexo"));
                hijo.setIdDad(result.getInt("idDad"));
                hijo.setIdMom(result.getInt("idMom"));
                return hijo;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return hijo;
    }

    @Override
    public List<Hijo> getListHijo() {
        List<Hijo> listaHijos = new ArrayList();
        DataBase dataBase = new DataBase();
        try{
            Statement stmt = dataBase.connection.createStatement();
            String sql = "SELECT * FROM children";
            ResultSet result = stmt.executeQuery(sql); 
            while(result.next()){
                Hijo hijo = new Hijo();
                hijo.setIdChildren(result.getInt("idChildren"));
                hijo.setFullName(result.getString("fullName"));
                hijo.setBirthday(result.getString("brithday"));
                hijo.setSexo(result.getString("sexo"));
                hijo.setIdDad(result.getInt("idDad"));
                hijo.setIdMom(result.getInt("idMom"));
                listaHijos.add(hijo);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listaHijos;
    }
    
    
    
}
