/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.dima.javabeginner.domain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dima.javabeginner.repository.UserRepository;
import io.dima.javabeginner.repository.CardRepository;
import io.dima.javabeginner.repository.ColumnRepository;

import java.util.Scanner;

/**
 *
 * @author Дмитрий
 */
public class Card {
    
    private String title, description, cid;
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
    
    public String getId (){
        return this.cid;
    }
    
    public void setId(String Id) {
        this.cid=Id;
    }
    
    public Column getColumn (){
        return this.column;
    }
    
    public User getAssignee(){
        return this.assignee;
    }
    
    public String getTitle (){
        return this.title;
    } 
    
    public static void createCard(Scanner in, String cardTitle, String columnTitle, User user, CardRepository cRep, ColumnRepository colRep, UserRepository uRep){
        Column column=colRep.columnByName(columnTitle);
        Card tmpCard=new Card (cardTitle,user, column);
        System.out.println("You just created a card. Assign it to your friend.");
        System.out.print("Email: ");
        String assigneeEmail=in.nextLine();
        tmpCard.assignTo(uRep.enterUser(assigneeEmail, in));
        cRep.save(tmpCard);
    }    
            
    public static void run(Scanner in, UserRepository uRep, CardRepository cRep, ColumnRepository colRep) {
        System.out.println("First, log in!");
        System.out.print("Email: ");
        User currentUser = uRep.enterUser(in.nextLine(), in);
        System.out.println("Hello " + currentUser.getName() + ", now you can create a task.");
        for(;;) {
            System.out.println("Choose 1 to create a card, 2 to show the list of cards, 3 to move card, 0 to exit");
            String command = in.nextLine();
            if(command.equals("0"))
                return;
            else if(command.equals("1")){
                System.out.print("Title: ");
                String cardTitle=in.nextLine();
                System.out.print("Column: ");
                String columnTitle=in.nextLine();            
                createCard(in, cardTitle, columnTitle, currentUser, cRep, colRep, uRep);
            }
            else if(command.equals("2"))
                cRep.showCards(colRep);
            else if(command.equals("3")){
                System.out.print("Enter card title:");
                String tmpCardTitle=in.nextLine();
                Card tmpCard=cRep.findByName(tmpCardTitle);
                System.out.print("Enter column source title: ");
                String tmpColSourceName=in.nextLine();
                if (tmpCard.getColumn().getName().equals(tmpColSourceName)){
                    System.out.print("Enter column dest title: ");
                    String tmpColDestName=in.nextLine();
                    Column dest=colRep.findByName(tmpColDestName);
                    cRep.moved(tmpCard, tmpCard.getColumn(), dest);
                    tmpCard.moveTo(dest);
                    }
                else
                    throw new IllegalArgumentException("There is not such card in DB");
            }
            else
                System.out.println("The command was not recognized, try again");
        }
    }
        
            
}
