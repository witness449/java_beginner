/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.dima.javabeginner.repository;

import io.dima.javabeginner.domain.Column;


import java.util.*;

/**
 *
 * @author Дмитрий
 */
public class ColumnRepository {
    private final Map<String, Column> сolumnById = new LinkedHashMap<>();
     
    public void save(Column newColumn) {
        if(newColumn.getId() != null)
            throw new IllegalArgumentException("The column already stored in DB: " + newColumn.getId());
        newColumn.setId(UUID.randomUUID().toString());
        сolumnById.put(newColumn.getId(), newColumn);
       }
    
    public List<Column> findAllOrderedByPosition(){
       List<Column> tmp = new ArrayList<>();
       for (Map.Entry<String, Column> entry : this.сolumnById.entrySet()){
            Column value = entry.getValue();
            tmp.add(value);
       }
       return tmp;
    }
    
    public Column columnByName(String name){
        Column tmp = null;
        for (Map.Entry<String, Column> entry : this.сolumnById.entrySet()){
            if (name.equals(entry.getValue().getName())){
                tmp=entry.getValue();
            }
        }
        if (tmp!=null)
            return tmp;
        else{
            tmp=new Column(name);
            this.save(tmp);
            return tmp;
        }
             
        
    }
    
}

