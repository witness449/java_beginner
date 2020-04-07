/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.java.io.dima.javabeginner.domain;

/**
 *
 * @author Дмитрий
 */
public class DomainModel {
    
    public static void main(String[] args){
        Column todo = new Column("TODO"),
        inProgress = new Column("In Progress"),
        done = new Column("Done");
        User creator = new User("project_manager@email.com"),
        assignee = new User("developer@email.com");
        Card c1 = new Card("Task #1", creator, todo);
        c1.assignTo(assignee);
        c1.moveTo(inProgress);
        Card c2 = new Card("Task #2", creator, todo);
        c2.assignTo(assignee);
        c2.setDescription("Won't fix it, created by mistake");
        c2.moveTo(done);
        c2.assignTo(creator);


}
 
    
}
