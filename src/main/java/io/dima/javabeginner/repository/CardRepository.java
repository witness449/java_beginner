/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.dima.javabeginner.repository;

import io.dima.javabeginner.domain.Card;
import io.dima.javabeginner.domain.Column;
import io.dima.javabeginner.domain.User;

import java.util.*;

public class CardRepository {
    private final Map<String, Card> cardById = new LinkedHashMap<>();
    private final Map<String, List<Card>> cardByAssignee = new HashMap<>();
    private final Map<String, List<Card>> cardByColumn = new HashMap<>();

    public void save(Card newCard) {
        if(newCard.getId() != null)
            throw new IllegalArgumentException("The card already stored in DB: " + newCard.getId());
        newCard.setId(UUID.randomUUID().toString());
        cardById.put(newCard.getId(), newCard);
        List<Card> cardsByColumn = cardByColumn.computeIfAbsent(newCard.getColumn().getId(), (c) -> new ArrayList<>());
        cardsByColumn.add(newCard);
        List<Card> assigneeCards = cardByAssignee.computeIfAbsent(newCard.getAssignee().getId(), (c) -> new ArrayList<>());
        assigneeCards.add(newCard);
    }
    
    public  List<Card> findByColumn(Column column) {
        return cardByColumn.get(column.getId());
    }
    
    public List<Card> findByAssignee (User assignee){
        return cardByAssignee.get(assignee.getId());
    }
    
    public Card findByName(String name){
        Card tmp = null;
        for (Map.Entry<String, Card> entry : this.cardById.entrySet()){
            if (name.equals(entry.getValue().getTitle())){
                tmp=entry.getValue();
            }
        }
        if (tmp==null)
            throw new IllegalArgumentException("There is not such card in DB");
        return tmp;
    }
    
    public void showCards(ColumnRepository colRep) {
        for (Column column : colRep.findAllOrderedByPosition()) {
            String line = column.getName() + ":\t";
            if (this.findByColumn(column)!=null){
                for (Card card : this.findByColumn(column))
                    line += card.getTitle() + "(" + card.getAssignee().getName() + "), ";
            }
            else
                line+="No cards in column "+column.getName()+"  ";
            line = line.substring(0, line.length() - 2);
            System.out.println(line);
        }
    }
    
    public void moved(Card card, Column source, Column dest){
        List<Card> sourcelist=this.cardByColumn.get(source.getId());
        List<Card> destlist=this.cardByColumn.get(dest.getId());
        sourcelist.remove(card);
        destlist.add(card);            
    }
            
    
 }

/**
 *
 * @author Дмитрий
 */

