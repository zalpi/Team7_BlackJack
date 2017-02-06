package com.csci4020.team7_blackjack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Pigott on 2/6/2017.
 */

//TODO set up scoring rules.
//TODO set up a YOU WON/YOU LOST dialog.
//TODO set up card counting to prevent duplicates.
//TODO set up dealer switch cases.
//TODO add money to bet along with an amount option.

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private int playerScoreInt; //anything over 21 will be considered a bust
    private int dealerScoreInt;
    private int playerMoneyInt;
    private TextView playerScore, playerMoney;
    private ImageView dealerCardOne, dealerCardTwo;
    private ImageView playerCardOne, playerCardTwo;
    private boolean playerStand = false, dealerStand = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blackjack_activity);

        //creating a deck to draw from.
        Deck deck = new Deck();

        //card declarations.
        dealerCardOne = (ImageView) findViewById(R.id.dealer_card1);
        dealerCardTwo = (ImageView) findViewById(R.id.dealer_card2);
        playerCardOne = (ImageView) findViewById(R.id.player_card1);
        playerCardTwo = (ImageView) findViewById(R.id.player_card2);

        //player's score is the only thing that updates on screen.
        playerScore = (TextView) findViewById(R.id.player_score);

        //making sure scores start off at 0.
        playerScoreInt = dealerScoreInt = 0;

        //setting money to defaulted 200, max should be about 9999 maybe?
        playerMoneyInt = 200;

        Button b = (Button) findViewById(R.id.hit_button);
        b.setOnClickListener(this);  //game doesn't start until player hits
    }

    @Override
    public void onClick(View view) {

    }

    private class Deck {
        private String[] deckOfCards;
        private Deck() {
            setDeck();
        }

        public String drawCard(String card) {
            Random r = new Random();
            int value = 0;
            int i = r.nextInt((52 - 1)); //I mean the array is set up for 0-51 so dunno

            if(deckOfCards[i].equals("drawn")) {
                drawCard(card);
            } else {
                card = deckOfCards[i];
                value = getValue(card);
                deckOfCards[i] = "drawn";
            }
            return card;
        }

        public void resetDeck() {
            setDeck();
        }
        private int getValue(String card) {
            int v = 0;
            switch(card) {
                case "cTwo":
                case "dTwo":
                case "hTwo":
                case "sTwo":
                    v = 2;
                    break;
                case "cThree":
                case "dThree":
                case "hThree":
                case "sThree":
                    v = 3;
                    break;
                case "cFour":
                case "dFour":
                case "hFour":
                case "sFour":
                    v = 4;
                    break;
                case "cFive":
                case "dFive":
                case "hFive":
                case "sFive":
                    v = 5;
                    break;
                case "cSix":
                case "dSix":
                case "hSix":
                case "sSix":
                    v = 6;
                    break;
                case "cSeven":
                case "dSeven":
                case "hSeven":
                case "sSeven":
                    v = 7;
                    break;
                case "cEight":
                case "dEight":
                case "hEight":
                case "sEight":
                    v = 8;
                    break;
                case "cNine":
                case "dNine":
                case "hNine":
                case "sNine":
                    v = 9;
                    break;
                case "cTen":
                case "dTen":
                case "hTen":
                case "sTen":
                case "cJack":
                case "dJack":
                case "hJack":
                case "sJack":
                case "cQueen":
                case "dQueen":
                case "hQueen":
                case "sQueen":
                case "cKing":
                case "dKing":
                case "hKing":
                case "sKing":
                    v = 10;
                    break;
                case "cAce":
                case "dAce":
                case "hAce":
                case "sAce":
                    v = 11;
                    break;
            }

            return v;
        }
        private void setDeck() {
            String[] deckOfCards = {"cTwo", "cThree", "cFour", "cFive", "cSix", "cSeven", "cEight",
            /*Clubs*/               "cNine", "cTen", "cJack", "cQueen", "cKing", "cAce",
                                    "dTwo", "dThree", "dFour", "dFive", "dSix", "dSeven", "dEight",
            /*Diamonds*/            "dNine", "dTen", "dJack", "dQueen", "dKing", "dAce",
                                    "hTwo", "hThree", "hFour", "hFive", "hSix", "hSeven", "hEight",
            /*Hearts*/              "hNine", "hTen", "hJack", "hQueen", "hKing", "hAce",
                                    "sTwo", "sThree", "sFour", "sFive", "sSix", "sSeven", "sEight",
            /*Spades*/              "sNine", "sTen", "sJack", "sQueen", "sKing", "sAce"};
            //  Clubs: 0-12 | Diamonds: 13-25 | Hearts: 26-38 | Spades: 39 - 51
        }
    }
}
