/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jorge
 */
public class DataBase {
        
    Connection connection;
    
    public void conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test","root","");
        } catch (Exception e){
            System.out.println("Errpr en el drive");
        }
    }
    
    public DataBase(){
        conectar();
    }
    
    public static void main(String[] args){
        new DataBase();
    }
}
