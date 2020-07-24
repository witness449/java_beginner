/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.dima.javabeginner.domain;

import java.util.Scanner;

/**
 *
 * @author Дмитрий
 */
public class User {
    
    private String email, firstName, lastName, uid;

    public User(String email) {
        this.email = email;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getName(){
        return this.firstName+" "+this.lastName;
    }

    
    public String getId(){
        return this.uid;
    }
    
    public void setId(String id){
        this.uid=id;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    @Override 
    public String toString() {
        return email;
    }
    
}
