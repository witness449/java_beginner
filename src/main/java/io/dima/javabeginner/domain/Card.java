/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.java.io.dima.javabeginner.domain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Дмитрий
 */
public class Card {
    
    private String title, description;
    private User assignee, creator;
    private Column column;
    private static final Logger LOG = LoggerFactory.getLogger(Card.class);
    public Card (String title, User creator, Column column) {
        this.title = title;
        this.creator=creator;
        this.column=column;
        //System.out.println ("User "+ this.creator+" created a card "+this.title+" in column "+this.column.getName());
        LOG.info("User [{}] created a crad[{}] in column [{}]", this.creator, this.title, this.column.getName());
    }
    
    public void assignTo (User assignee){
        this.assignee=assignee;
        //System.out.println ("Card "+this.title+" was assigned to "+this.assignee.getName());
        LOG.info("Card [{}] was assigned to [{}]", title, assignee);
        
    }
    
    public void moveTo (Column column){
        this.column=column;
        //System.out.println ("Card "+this.title+" was moved to "+this.column.getName());
        LOG.info("Card [{}] was moved to [{}]", this.title, this.column.getName()); 
    }
    
    public void setDescription (String Description)    {
        this.description=Description;
        //System.out.println ("Card "+this.title+" was given a description "+ this.description);
        LOG.info("Card [{}] was given a description [{}]", this.title, this.description);
        
    }
}
