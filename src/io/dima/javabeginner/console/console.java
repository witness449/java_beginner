/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.dima.javabeginner.console;

import io.dima.javabeginner.domain.Card;
import io.dima.javabeginner.domain.Column;
import io.dima.javabeginner.domain.User;
import java.util.Scanner;

/**
 *
 * @author Дмитрий
 */
public class console {
    
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println ("First, log in!");
        System.out.print ("E-mail: ");
        String user_email=sc.nextLine();
        User user=new User(user_email);
        System.out.print ("First name: ");
        String user_firstname=sc.nextLine();
        user.setFirstName(user_firstname);
        System.out.print ("Last name: ");
        String user_lastname=sc.nextLine();
        user.setLastName(user_lastname);
        System.out.println ("Hello "+user.getName()+", now you can create task.");
        System.out.print ("Title: ");
        String title=sc.nextLine();
        System.out.print ("Column: ");
        String column=sc.nextLine();
        Column card_column=new Column (column);
        Card crd=new Card(title, user, card_column);
        System.out.println ("You just created a card. Assign it to your friend");
        
        
        System.out.print ("E-mail: ");
        String friend_email=sc.nextLine();
        User friend = new User (friend_email);
        System.out.print ("First name: ");
        String friend_firstname=sc.nextLine();
        friend.setFirstName(friend_firstname);
        System.out.print ("Last name: ");
        String friend_lastname=sc.nextLine();
        friend.setLastName(friend_lastname);
             
        crd.assignTo(friend);
        
        
      
       
        
    }
    
}
