package org.BdB.lab.application.utils;

public class Validators {

    public  static  boolean valideTypeDocument(char type){
       return Character.toUpperCase(type) == 'C' || Character.toUpperCase(type) == 'P';
    }

}
