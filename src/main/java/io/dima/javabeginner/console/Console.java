/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.java.io.dima.javabeginner.console;

import main.java.io.dima.javabeginner.domain.Card;
import main.java.io.dima.javabeginner.domain.Column;
import main.java.io.dima.javabeginner.domain.User;
import java.util.Scanner;

/**
 *
 * @author Дмитрий
 */
public class Console {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println ("First, log in!");
        System.out.print ("E-mail: ");
        String userEmail=sc.nextLine();
        User user=new User(userEmail);
        System.out.print ("First name: ");
        String userFirstname=sc.nextLine();
        user.setFirstName(userFirstname);
        System.out.print ("Last name: ");
        String userLastname=sc.nextLine();
        user.setLastName(userLastname);
        System.out.println ("Hello "+user.getName()+", now you can create task.");
        System.out.print ("Title: ");
        String title=sc.nextLine();
        System.out.print ("Column: ");
        String column=sc.nextLine();
        Column cardColumn=new Column (column);
        Card crd=new Card(title, user, cardColumn);
        System.out.println ("You just created a card. Assign it to your friend");
        System.out.print ("E-mail: ");
        String friendEmail=sc.nextLine();
        User friend = new User (friendEmail);
        System.out.print ("First name: ");
        String friendFirstname=sc.nextLine();
        friend.setFirstName(friendFirstname);
        System.out.print ("Last name: ");
        String friendLastname=sc.nextLine();
        friend.setLastName(friendLastname);
        crd.assignTo(friend);
        }
}
