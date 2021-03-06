package com.aetherwars.model;

import com.aetherwars.card.Card;
import com.aetherwars.exceptions.EmptyContainerException;
import com.aetherwars.exceptions.FullContainerException;
import com.aetherwars.exceptions.NoCardChosenException;
import com.aetherwars.exceptions.SpaceFilledException;

public class Hand implements CardContainer {
    private Card[] cards;
    private int neff;

    public Hand() {
        this.cards = new Card[5];
        this.neff = 0;
    }

    public int getNeff() {
        return this.neff;
    }

    public Boolean isFull() {
        return this.neff >= 5;
    }

    public void add(Card c) throws FullContainerException {
        /* Add card di tempat kosong pertama */
        if (this.isFull()) {
            throw new FullContainerException();
        } else {
            for (int i = 0; i < 5; i++) {
                if (this.cards[i] == null) {
                    this.cards[i] = c;
                    this.neff++;
                    return;
                }
            }
        }
    }

    public void add(Card c, int i) throws SpaceFilledException, FullContainerException {
        /* Add card sesuai indeks */
        if (this.cards[i] != null) {
            throw new SpaceFilledException();
        } else if (this.neff == 5) {
            throw new FullContainerException();
        } else {
            this.cards[i] = c;
            this.neff++;
        }
    }

    public Card take() throws EmptyContainerException {
        /* Ambil card di tempat tidak kosong pertama */
        if (this.neff == 0) {
            throw new EmptyContainerException();
        } else {
            for (int i = 0; i < 5; i++) {
                if (this.cards[i] != null) {
                    Card tmp = this.cards[i];
                    this.cards[i] = null;
                    this.neff--;
                    return tmp;
                }
            }
        }

        return null;
    }

    public Card take(int i) throws NoCardChosenException {
        /* Ambil card sesuai indeks */
        if (this.cards[i] == null) {
            throw new NoCardChosenException();
        } else {
            Card tmp = this.cards[i];
            this.cards[i] = null;
            this.neff--;

            return tmp;
        }
    }

    public void show(int i) throws NoCardChosenException {
        if (this.cards[i] == null) {
            throw new NoCardChosenException();
        } else {
            this.cards[i].show();
        }
    }

    public Card getCard(int i) {
        return this.cards[i];
    }

}
