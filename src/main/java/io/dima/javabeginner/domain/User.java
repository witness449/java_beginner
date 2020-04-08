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
public class User {
    
    private String email, firstName, lastName;

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

    @Override 
    public String toString() {
        return email;
    }
}
