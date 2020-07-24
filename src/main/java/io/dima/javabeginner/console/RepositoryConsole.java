/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.dima.javabeginner.console;

import io.dima.javabeginner.domain.Card;
import io.dima.javabeginner.domain.Column;
import io.dima.javabeginner.domain.User;
import io.dima.javabeginner.repository.CardRepository;
import io.dima.javabeginner.repository.ColumnRepository;
import io.dima.javabeginner.repository.UserRepository;

import java.util.Scanner;




/**
 *
 * @author Дмитрий
 */
public class RepositoryConsole {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        UserRepository uRep=new UserRepository();
        CardRepository cRep=new CardRepository();
        ColumnRepository ColRep=new ColumnRepository();
        Card.run(in, uRep, cRep, ColRep);
    }
}
    
    

