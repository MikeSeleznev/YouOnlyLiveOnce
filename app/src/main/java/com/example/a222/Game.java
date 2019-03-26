package com.example.a222;



public class Game {
    Players[] players;
    Cards[] cards;
    Players selectedPlayer;


    public Game(Players[] players, Cards[] cards){

        this.players = players;
        this.cards = cards;
    }


    public int numberOfPlayers(){
        return  this.players.length;
    }

    public void setSelectedPlayer(Players player){
        this.selectedPlayer = player;
    }

    public Players getSelectedPlayer(){
        return selectedPlayer;
    }

    public void minusOneCard(String pack){
        for (Cards c: cards) {
            if (c.getName().equals(pack) == true){
               c.getCards().remove(c.sizeCards()-1);
               c.setLeftCards();
            } else {
                String a = "a";
            }
        }
    }

    public String leftCardsText(String pack){
        String text = "";
        for (Cards c: cards) {
            if (c.getName().equals(pack) == true){
                text = c.leftCardsText();
            } else {
                String a = "a";
            }
        }
        return text;
    }

    public String getNamePack(String pack){
        String text = "";
        for (Cards c: cards) {
            if (c.getName().equals(pack) == true){
                text = c.getName();
            } else {
                String a = "a";
            }
        }
        return text;
    }

   public String getRandomQuestion(String pack){
       String text = "";
       for (Cards c: cards) {
           if (c.getName().equals(pack) == true){
               text = c.getRandomQuestion();
           } else {
               String a = "a";
           }
       }
       return text;
   }
}
