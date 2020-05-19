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
    
    private final Map<String, User> UserById = new LinkedHashMap<>();
   
    public void save(User newUser) {
        if(newUser.getId() != null)
            throw new IllegalArgumentException("The user already stored in DB: " + newUser.getId());
        newUser.setId(UUID.randomUUID().toString());
        UserById.put(newUser.getId(), newUser);
          
    }
     
    
}
