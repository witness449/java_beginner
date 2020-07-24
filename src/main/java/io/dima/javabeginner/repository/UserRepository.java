/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.dima.javabeginner.repository;

import io.dima.javabeginner.domain.User;

import java.util.*;

/**
 *
 * @author Дмитрий
 */
public class UserRepository {
    
    private final Map<String, User> userById = new LinkedHashMap<>();
   
    public void save(User newUser) {
        if(newUser.getId() != null)
            throw new IllegalArgumentException("The user already stored in DB: " + newUser.getId());
        newUser.setId(UUID.randomUUID().toString());
        userById.put(newUser.getId(), newUser);
          
    }
     
    public User enterUser(String val, Scanner in){
        for (Map.Entry<String, User> entry : this.userById.entrySet()){
            String key = entry.getKey();
            User value = entry.getValue();
            if(value.getEmail().equals(val))
                return value;
           }
        System.out.print("First name: ");
        String firstName=in.nextLine();
        System.out.print("Last name: ");
        String lastName=in.nextLine();
        User tmp=new User(val);
        tmp.setFirstName(firstName);
        tmp.setLastName(lastName);
        this.save(tmp);
        return tmp;
    }
}
