/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.models;

/**
 *
 * @author Jorge
 */
public class Hijo {
    
    private int idChildren;
    private String fullName;
    private String birthday;
    private String sexo;
    private int idDad;
    private int idMom;

    public Hijo() {
    }
        
    public Hijo(int idChildren, String fullName, String birthday, String sexo, int idDad, int idMom) {
        this.idChildren = idChildren;
        this.fullName = fullName;
        this.birthday = birthday;
        this.sexo = sexo;
        this.idDad = idDad;
        this.idMom = idMom;
    }

    public int getIdChildren() {
        return idChildren;
    }

    public void setIdChildren(int idChildren) {
        this.idChildren = idChildren;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdDad() {
        return idDad;
    }

    public void setIdDad(int idDad) {
        this.idDad = idDad;
    }

    public int getIdMom() {
        return idMom;
    }

    public void setIdMom(int idMom) {
        this.idMom = idMom;
    }
    
}
