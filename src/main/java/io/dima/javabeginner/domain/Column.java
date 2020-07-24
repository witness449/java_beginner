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
    private String name, colid;
    
    public Column (String name) {
        this.name = name;
    }
    
    public String getName (){
        return this.name;
        
    }
    
    public String getId() {
        return this.colid;
    }
    
    public void setId(String id){
        this.colid=id;
    }
    
  
           
   
}
