/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.dima.javabeginner.domain;

/**
 *
 * @author Дмитрий
 */
public class Column {
    private String name;
    public Column (String name) {
        this.name = name;
    }
    
    public String getName (){
        return this.name;
        
    }
    
}
