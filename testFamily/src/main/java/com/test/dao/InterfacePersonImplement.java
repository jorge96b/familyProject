/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dao;


import com.test.dao.interfaces.PersonInterface;
import com.test.models.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class InterfacePersonImplement implements PersonInterface {

    @Override
    public Persona addPerson(Persona person) {
        DataBase dataBase = new DataBase();
        try{
            String sql = "INSERT INTO test.person (`idPerson`, `fullName`, birthday, sexo)";
            sql += " values(";
            sql += person.getId()+",";
            sql += "'"+ person.getNombre() + "',";
            sql += "'"+ person.getFechaNacimiento() + "',";
            sql += "'"+ person.getSexo() + "');";
            PreparedStatement stmt = dataBase.connection.prepareStatement(sql);
            stmt.executeUpdate(sql);
            return person;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return person;
    }

    @Override
    public String deletePerson(int id) {
        try{
            DataBase dataBase = new DataBase();
            String sql = "DELETE FROM person where idPerson="+id;
            PreparedStatement stmt = dataBase.connection.prepareStatement(sql);
            stmt.executeUpdate(sql); 
            return "Se elimino la persona con el id"+id;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return "No se pudo eliminar la persona con el id"+id;
        
    }

    @Override
    public boolean updatePerson(int idPerson, Persona person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona getPerson(int id) {
        Persona persona = new Persona();
        try{
            DataBase dataBase = new DataBase();
            Statement stmt = dataBase.connection.createStatement();
            String sql = "SELECT * FROM person where idPerson="+id;
            ResultSet result = stmt.executeQuery(sql); 
            while(result.next()){
                persona.setId(result.getInt("idPerson"));
                persona.setNombre(result.getString("fullName"));
                persona.setFechaNacimiento(result.getString("birthday"));
                persona.setSexo(result.getString("sexo"));
                return persona;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return persona;
    }

    @Override
    public List<Persona> getListPersons() {
        List<Persona> listaPersonas = new ArrayList();
        DataBase dataBase = new DataBase();
        try{
            Statement stmt = dataBase.connection.createStatement();
            String sql = "SELECT * FROM person";
            ResultSet result = stmt.executeQuery(sql); 
            while(result.next()){
                Persona persona = new Persona();
                persona.setId(result.getInt("idPerson"));
                persona.setNombre(result.getString("fullName"));
                persona.setFechaNacimiento(result.getString("birthday"));
                persona.setSexo(result.getString("sexo"));
                listaPersonas.add(persona);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listaPersonas;
    }
    
    
}
