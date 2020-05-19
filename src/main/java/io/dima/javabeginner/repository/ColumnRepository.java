/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.dima.javabeginner.repository;

import io.dima.javabeginner.domain.Column;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Дмитрий
 */
public class ColumnRepository {
    
    private final Map<String, Column> ColumnById = new LinkedHashMap<>();
   
    public void save(Column newColumn) {
        if(newColumn.getId() != null)
            throw new IllegalArgumentException("The user already stored in DB: " + newColumn.getId());
        newColumn.setId(UUID.randomUUID().toString());
        ColumnById.put(newColumn.getId(), newColumn);
       }
}